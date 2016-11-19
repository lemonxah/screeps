package com.lemonxah.screeps.ai.jobs

import com.lemonxah.screeps.api._

import scala.scalajs.js.JSConverters._
import monix.eval.Task

import scala.collection.mutable
import scala.scalajs.js
import scala.scalajs.js._
import scalaz._, Scalaz._
import com.lemonxah.screeps.ai.Wrapper._
/**
  * Project: Screeps
  * Package: com.lemonxah.screeps.ai.jobs
  * Created on 19/11/2016.
  * lemonxah aka lemonxah -
  * https://github.com/lemonxah
  * http://stackoverflow.com/users/2919672/lemon-xah
  */
import ScreepsContext._

class CreepRef(name: String) {
  def get: Task[Option[Creep]] = Game.map(_.creeps.get(name)).flatMap {
    case None ⇒ for {
      l ← removeDedcrep(name)
      _ ← log(l)
    } yield none[Creep]
    case Some(creep) ⇒ Task.now(creep.some)
  }
}

trait CreepPool {
  def creeps: mutable.MutableList[CreepRef]
  def available: Boolean
  def take: CreepRef
  def release(creep: CreepRef): Unit
}

object CreepPool {
  implicit val defaultPool = new CreepPool {

    override def creeps: mutable.MutableList[CreepRef] = ???
    override def available: Boolean = ???
    override def take: CreepRef = ???
    override def release(creep: CreepRef): Unit = ???
  }
}

case class Job(require: js.Array[String], task: CreepRef ⇒ Task[Boolean])
case class Assigned(job: Job, creep: CreepRef)

object Jobs {
  private[jobs] var queue: mutable.Queue[Job] = mutable.Queue()
  private[jobs] var running: mutable.MutableList[Assigned] = mutable.MutableList()
  def addJob(job: Job): Task[Unit] = Task.now {
    queue.enqueue(job)
  }
  def run(implicit pool: CreepPool): Task[Unit] = {
    while(pool.available) {
      running += Assigned(queue.dequeue(), pool.take)
    }
    Task.sequence(running.toList.map(a ⇒ a.job.task(a.creep).map(if(_){
      running = running.filter(_ != a)
    }))).foreachL(_ => ())
  }
}
