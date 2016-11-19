package com.lemonxah.screeps.ai

import scala.scalajs.js
import scala.scalajs.js._
import scala.scalajs.js.{Dictionary, UndefOr}
import scala.scalajs.js.JSConverters._
import com.lemonxah.screeps.api._

import scala.collection.mutable
import prickle._
import com.lemonxah.prickle.WeakRef

import monix.eval._


import scala.util.{Failure, Success, Try}
import be.doeraene.sjsreflect.Reflect
import com.lemonxah.prickle.{NativeJsConfig, WeakRef}

@js.native
object JSON extends js.Object {
  def parse(text: String): js.Any = js.native
  def stringify[A](value: A): String = js.native
}


class Loop() {
  import ScreepsContext._
  implicit val PrickleConfig = NativeJsConfig()

  // Caching doesn't seem to work because for some reason the state gets messed up but not cleared when calling loop.
  //var contextCache: AIContext = null

  def getMemoryCreeps: Task[Dictionary[Creep]] = Memory.map(_.creeps.asInstanceOf[Dictionary[Creep]])
  def getDedcreps(creps: Dictionary[Creep]): Task[Dictionary[Creep]] = {
    Game.map { c ⇒
      creps.filter {
        case (name, creep) ⇒ !c.creeps.contains(name)
      }.toJSDictionary
    }
  }

  def removeDedcreps(creps: Dictionary[Creep]): Task[String] = {
    getMemoryCreeps.flatMap { mc ⇒
      Task.now(creps.toList.map { case(name, creep) ⇒
        mc.delete(name)
        s"Removed dedcrep: $name"
      }.mkString("\n"))
    }
  }


  def spawn(s: String)(game: Game): Task[Spawn] = Task.delay(game.spawns(s))

  def spawnCreep(body: js.Array[String])(spawn: Spawn): Task[Int | String] = Task.delay(spawn.createCreep(body))

  def log[A](value: A): Task[A] = Task.now {
    val ss = if (value.isInstanceOf[String]) {
      value
    } else {
      JSON.stringify(value)
    }
    if (ss != "" && ss != "{}") println(ss)
    value
  }

  def usePathfinder(b: Boolean): Task[Unit] = PathFinder.map(_.use(b))

  def gc: Task[Unit] = for {
    mc ← getMemoryCreeps
    dc ← getDedcreps(mc)
    s ← removeDedcreps(dc)
    _ ← log(s)
  } yield ()

  def loop(): Task[Unit] = for {
    _ ← usePathfinder(true)
    _ ← gc
  } yield ()

}
