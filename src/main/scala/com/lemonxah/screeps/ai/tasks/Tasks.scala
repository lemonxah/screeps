package com.lemonxah.screeps.ai.tasks

import monix.eval.Task
import com.lemonxah.screeps.api._
import com.lemonxah.screeps.api.ScreepsContext._

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js._
import com.lemonxah.screeps.ai.Wrapper._
/**
  * Project: Screeps
  * Package: com.lemonxah.screeps.ai.tasks
  * Created on 20/11/2016.
  * lemonxah aka lemonxah -
  * https://github.com/lemonxah
  * http://stackoverflow.com/users/2919672/lemon-xah
  */
object Tasks {
  implicit def dynamicToBoolean(v: js.Dynamic): Boolean = v.toString.toBoolean
  implicit def dynamicToInt(v: js.Dynamic): Int = v.toString.toInt

  def manageCreeps(count: Int) = Memory.flatMap { mem ⇒
    Game.map { game ⇒
      // checking workers for dedcreps
      if (!js.isUndefined(mem.workers)) {
        val workers = mem.workers.as[js.Dictionary[Creep]]
        workers.foreach {
          case (name, creep) ⇒
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
          if (game.rooms.values.head.energyAvailable > 200) {
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
        workers.toList.zipWithIndex.map {
          case ((name, _), i) ⇒
            val creep = game.creeps(name)
            if (i < 2)
              build(creep)
            else if (i < 4)
              harvest(creep)
            else
              upgrade(creep)
        }.foldLeft(Task.unit) {
          case (p, t) ⇒ p.flatMap(_ ⇒ t)
        }
      } else Task.unit
    }
  }

  def doWork(creep: Creep, workingPhrase: String)(f: Creep ⇒ Unit): Task[Unit] = Memory.map { mem ⇒
    def updateSources(creep: Creep) = {
      if (creep.memory.sourcesid.as[Int] == 1)
        creep.memory.sourcesid = 0
      else
        creep.memory.sourcesid = 1
    }

    if (js.isUndefined(creep.memory.working)) {
      println(s"first harvest for ${creep.name}")
      creep.memory.working = false
    }
    if (js.isUndefined(creep.memory.sourcesid)) {
      println("sourcesid undefined")
      creep.memory.sourcesid = 0
      updateSources(creep)
    }

    if(creep.carry.energy == 0 && creep.memory.working) {
      creep.say("harvesting")
      creep.memory.working = false
    }
    if(creep.carry.energy == creep.carryCapacity && !creep.memory.working) {
      creep.say(workingPhrase)
      creep.memory.working = true
    }
    if(!creep.memory.working) {
      val sources = creep.room.find(FIND_SOURCES)
      if(creep.harvest(sources(creep.memory.sourcesid)) == ERR_NOT_IN_RANGE) {
        creep.moveTo(sources(creep.memory.sourcesid))
      } else if (creep.harvest(sources(creep.memory.sourcesid)) == ERR_NOT_ENOUGH_RESOURCES) {
        updateSources(creep)
      }
    }
    else f(creep)
  }

  def harvest(c: Creep): Task[Unit] = doWork(c, "delivering") { creep ⇒
    creep.room.find(FIND_STRUCTURES, FindFilter[StructureExtension]({ structure ⇒ {
      (structure.structureType == STRUCTURE_EXTENSION ||
        structure.structureType == STRUCTURE_SPAWN
        ) &&
        structure.energy < structure.energyCapacity
    }
    })).headOption.fold {
      creep.room.find(FIND_STRUCTURES, FindFilter[StructureStorage]({ storage ⇒ {
        storage.structureType == STRUCTURE_STORAGE &&
          storage.store(RESOURCE_ENERGY) >= 0
      }
      })).headOption.fold (up(creep)) { target ⇒
        if (creep.transfer(target, RESOURCE_ENERGY) == ERR_NOT_IN_RANGE) creep.moveTo(target)
      }
      0
    } { target ⇒
      if (creep.transfer(target, RESOURCE_ENERGY) == ERR_NOT_IN_RANGE) creep.moveTo(target)
      1
    }
  }

  def up(creep: Creep): Unit = {
    if(creep.upgradeController(creep.room.controller) == ERR_NOT_IN_RANGE) {
      creep.moveTo(creep.room.controller)
    }
  }

  def upgrade(c: Creep): Task[Unit] = doWork(c, "upgrading")(up)

  def build(c: Creep): Task[Unit] = doWork(c, "building") { creep ⇒
    val targets = creep.room.find(FIND_CONSTRUCTION_SITES, FindFilter[ConstructionSite](_ ⇒ true))
    targets.sortWith(_.progress > _.progress).headOption.fold (up(creep)) { site ⇒
      if (creep.build(site) == ERR_NOT_IN_RANGE) creep.moveTo(site)
    }
  }
}
