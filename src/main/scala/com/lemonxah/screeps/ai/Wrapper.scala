package com.lemonxah.screeps.ai

import com.lemonxah.screeps.api._
import scala.scalajs.js.JSConverters._
import monix.eval.Task

import scala.scalajs.js
import scala.scalajs.js._

/**
  * Project: Screeps
  * Package: com.lemonxah.screeps.ai
  * Created on 19/11/2016.
  * lemonxah aka lemonxah -
  * https://github.com/lemonxah
  * http://stackoverflow.com/users/2919672/lemon-xah
  */
@js.native
object JSON extends js.Object {
  def parse(text: String): js.Any = js.native
  def stringify[A](value: A): String = js.native
}

object Wrapper {
  import ScreepsContext._
  implicit class dynamicConversions(v: js.Dynamic) {
    def as[A] = v.asInstanceOf[A]
  }

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

  def removeDedcrep(name: String): Task[String] = {
    getMemoryCreeps.map { mc ⇒
        mc.delete(name)
        s"Removed dedcrep: $name"
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

}
