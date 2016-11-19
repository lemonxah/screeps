package com.lemonxah.screeps.ai

import scala.scalajs.js
import scala.scalajs.js.{Dictionary, UndefOr}
import scala.scalajs.js.JSConverters._
import com.lemonxah.screeps.api._
import com.lemonxah.screeps.wrappers._
import com.lemonxah.screeps.wrappers.APIPickler._

import scala.collection.mutable
import prickle._
import com.lemonxah.prickle.WeakRef

import monix.eval._
import monix.execution._

import scala.util.{Failure, Success, Try}
import be.doeraene.sjsreflect.Reflect
import com.lemonxah.prickle.{NativeJsConfig, WeakRef}

class Loop() {
  import ScreepsContext._
  implicit val PrickleConfig = NativeJsConfig()

  import monix.execution.Scheduler.Implicits.global

  // Caching doesn't seem to work because for some reason the state gets messed up but not cleared when calling loop.
  //var contextCache: AIContext = null

  def getMemoryCreeps: Task[Dictionary[Creep]] = Task.delay(Memory.creeps.asInstanceOf[Dictionary[Creep]])
  def getGameCreeps: Task[Dictionary[Creep]] = Task.delay(Game.creeps)
  def getDedcreps(creps: Dictionary[Creep]): Task[Dictionary[Creep]] = {
    getGameCreeps.map { c ⇒
      creps.filter {
        case (name, creep) ⇒ !c.contains(name)
      }.toJSDictionary
    }
  }

  def removeDedcreps(creps: Dictionary[Creep]): Task[Unit] = Task.delay {
    getMemoryCreeps.foreach { mc ⇒
      creps.foreach { case(name, creep) ⇒
        println(s"Removing dedcrep: $name")
        mc.delete(name)
      }
    }
  }

  def loop(): Unit = {
    PathFinder.use(true)

    getMemoryCreeps.flatMap(getDedcreps).flatMap(removeDedcreps).runAsync

    Game.spawns.values.head.createCreep(js.Array(MOVE, MOVE))
  }
}
