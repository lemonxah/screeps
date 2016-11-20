package com.lemonxah.screeps.ai

import com.lemonxah.screeps.ai.Wrapper._
import com.lemonxah.screeps.ai.jobs.{CreepPool, Jobs}
import monix.eval._

import scala.scalajs.js
import com.lemonxah.screeps.api.ScreepsContext._
import com.lemonxah.screeps.ai.Wrapper._
import com.lemonxah.screeps.ai.tasks.Tasks._
import com.lemonxah.screeps.api._

class Loop() {
  //implicit val pool = CreepPool.createPool(2)

  def manageCreeps(count: Int) = Memory.flatMap { mem ⇒
    Game.map { game ⇒
      // checking workers for dedcreps
      if (!js.isUndefined(mem.workers)) {
        val workers = mem.workers.as[js.Dictionary[Creep]]
//        println(JSON.stringify(workers))
        workers.foreach {
          case (name, creep) ⇒
//            println(s"checking name: $name, creep: ${JSON.stringify(creep)}")
            if (!game.creeps.contains(name))
              mem.workers.as[js.Dictionary[Creep]].delete(name)
        }
      }

      val spawn = game.spawns.values.toList.sortWith(_.energy > _.energy).head
      if(spawn.spawning == null) {
        // spawned a creep and need to add it to a list
        if (!js.isUndefined(mem.newname) && mem.newname.toString != "") {
          println(s"adding ${mem.newname} to workers")
          val name: String = mem.newname.toString
          mem.newname = ""
          if (js.isUndefined(mem.workers)) {
            mem.workers = js.Dictionary((name, game.creeps(name)))
          } else {
            mem.workers.as[js.Dictionary[Creep]].put(name, game.creeps(name))
          }
        }
        if (js.isUndefined(mem.workers) || mem.workers.as[js.Dictionary[Creep]].keys.size < count) {
          if (spawn.energy > 200) {
            val n = spawn.createCreep(js.Array(WORK, CARRY, MOVE))
            println(s"spawning $n")
          } else {
            println(s"waiting for energy on spawner: ${spawn.name}")
          }
        }
      } else {
        mem.newname = spawn.spawning.name
        println(s"waiting spawn of ${spawn.spawning.name}")
      }
    }
  }

  def runCreeps = Memory.flatMap { mem ⇒
    Game.flatMap { game ⇒
      if (!js.isUndefined(mem.workers)) {
        val workers = mem.workers.as[js.Dictionary[Creep]]
        workers.map {
          case (name, _) ⇒
            val creep = game.creeps(name)
            upgrade(creep)
        }.foldLeft(Task.unit) {
          case (p, t) ⇒ p.flatMap(_ ⇒ t)
        }
      } else Task.unit
    }
  }

  def run: Task[Unit] = for {
    _ ← usePathfinder(true)
    _ ← manageCreeps(4)
    _ ← runCreeps
//    _ ← Jobs.runCreep
//    _ ← Jobs.run
    _ ← gc
  } yield ()
}
