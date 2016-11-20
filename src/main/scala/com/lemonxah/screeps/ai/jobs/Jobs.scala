package com.lemonxah.screeps.ai.jobs

import java.util.concurrent.ConcurrentHashMap

import com.lemonxah.screeps.api._

import scala.scalajs.js.JSConverters._
import monix.eval.Task

import scala.scalajs.js
import scala.scalajs.js._
import scalaz._
import Scalaz._
import com.lemonxah.screeps.ai.Wrapper._

import scala.collection._
import scala.collection.JavaConverters._

/**
  * Project: Screeps
  * Package: com.lemonxah.screeps.ai.jobs
  * Created on 19/11/2016.
  * lemonxah aka lemonxah -
  * https://github.com/lemonxah
  * http://stackoverflow.com/users/2919672/lemon-xah
  */
import ScreepsContext._

case class CreepRef(name: String) {
  def get: Task[Option[Creep]] = Game.map(_.creeps.get(name)).flatMap {
    case None ⇒ for {
      l ← removeDedcrep(name)
      _ ← log(l)

    } yield none[Creep]
    case Some(creep) ⇒ Task.now(creep.some)
  }
}

trait CreepPool {
  def poolName: String
  def poolSize: Int
  def available: Task[Boolean]
  def take: Task[Option[Creep]]
  def release(creep: Creep): Task[Unit]
  def updatePool(): Task[Unit]
  def addCreep(creepRef: Creep): Task[Unit]
}

object CreepPool {
//  def createPool(pSize: Int, pName: String = "creep-pool"): CreepPool = {
//    new CreepPool {
//
//      if (Memory.pools == null) {
//        println("pools was null")
//        Memory.pools = js.Dictionary[js.Dictionary[Creep]]()
//      }
//      val pools: js.Dictionary[Dictionary[Creep]] = Memory.pools.asInstanceOf[js.Dictionary[js.Dictionary[Creep]]]
//      if (pools(poolName) == null) {
//        println(s"pool: $poolName was null")
//        pools(poolName) = js.Dictionary[Creep]()
//      }
//      val creeps: js.Dictionary[Creep] = pools(poolName)
//
//      if (Memory.poolUpdating == null) Memory.poolUpdating = false
//      var updating: Boolean = Memory.poolUpdating.asInstanceOf[Boolean]
//
//      override def poolName: String = pName
//
//      override def poolSize: Int = pSize
//
//      override def available: Task[Boolean] = ??? //Task.delay(creeps.nonEmpty)
//
//      override def take: Task[Option[Creep]] = ???
////        Task.delay {
////        if (creeps.nonEmpty) {
////          val c = creeps.values.head
////          creeps.delete(creeps.keys.head)
////          c.some
////        } else {
////          none[Creep]
////        }
////      }
//
//      override def release(creep: Creep): Task[Unit] = ??? //Task.now(creeps.put(creep.name, creep))
//
//      override def updatePool(): Task[Unit] = ??? //{
////        val updating = Memory.poolUpdating.asInstanceOf[Boolean]
////        println(s"updating is : $updating and creeps.size is : ${creeps.size}")
////        if (!updating && creeps.size < poolSize) {
////          Memory.poolUpdating = true
////          var spawnedCreps = poolSize - creeps.size
////          println(s"spawning $spawnedCreps creeps")
////          Task.sequence((creeps.size until spawnedCreps).map { _ ⇒
//////            println(s"updaing pool: $poolName")
////            Game.flatMap{
////              game ⇒ spawn("steve")(game).flatMap { spawn ⇒
////                Jobs.add(Job({
////                  //println(com.lemonxah.screeps.ai.JSON.stringify(spawn.spawning))
////                  val result = if (spawn.spawning == null) {
////                    spawn.createCreep(js.Array(MOVE))
////                  } else 12
////                  try {
////                    //                  println(errcodeToString(result.toString.toInt))
////                    false
////                  } catch {
////                    case _: Throwable ⇒
////                      val name = result.toString
////                      println("adding creep to map")
////                      creeps.put(name, game.creeps(name))
////                      true
////                  }
////                }))
////              }
////            }
////          }).foreachL(_ ⇒ ())
////        } else {
////          Task.unit
////        }
////      }
//
//      override def addCreep(creep: Creep): Task[Unit] = ???
//    }
//  }
}


case class Job(id: String, task: Task[Boolean])
object Job {
  def apply(j: ⇒ Boolean): Job = new Job(java.util.UUID.randomUUID().toString, Task.delay(j))
}
case class CreepJob(require: js.Array[String], task: Creep ⇒ Task[Boolean])
case class Assigned(job: CreepJob, creep: Creep)

object Jobs {
  private[Jobs] var creepqueue: mutable.Queue[CreepJob] = mutable.Queue()
  private[Jobs] var creeprunning: mutable.MutableList[Assigned] = mutable.MutableList()
  private[Jobs] val jobqueue: scala.collection.concurrent.Map[String, Job] = new ConcurrentHashMap[String, Job]().asScala
  def addCreepJob(job: CreepJob): Task[Unit] = Task.now {
    creepqueue.enqueue(job)
  }
  def add(job: Job): Task[Unit] = Task.delay {
    println(s"adding job: ${job.id}")
    jobqueue.put(job.id, job)
  }

  def runCreep(implicit pool: CreepPool): Task[Unit] = {
    (if (creeprunning.length < pool.poolSize && creepqueue.nonEmpty) {
      Task.sequence((creeprunning.length to Math.min(creeprunning.length + creepqueue.length, pool.poolSize)).map { _ ⇒
        pool.take.map {
          case Some(creep) ⇒
            creeprunning += Assigned(creepqueue.dequeue(), creep)
            ()
          case None ⇒ ()
        }
      })
    } else Task.unit).flatMap { _ ⇒
      Task.sequence(creeprunning.toList.map(a ⇒ a.job.task(a.creep).map(if(_){
        creeprunning = creeprunning.filter(_ != a)
      }))).foreachL(_ => ())
    }
  }

  def run: Task[Unit] = {
    println(s"jobs before: ${jobqueue.size}")
    Task.sequence(jobqueue.values.map { job ⇒
      println(s"running job: ${job.id}")
      job.task.map(if(_){
        println("remove job")
        jobqueue.remove(job.id)
        println(s"jobs: ${jobqueue.size}")
      })}).foreachL(_ ⇒ ())
  }
}
