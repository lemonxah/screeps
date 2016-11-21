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
  def run: Task[Unit] = for {
    _ ← usePathfinder(true)
    c ← manageCreeps(6)
    _ ← runCreeps
    _ ← gc
  } yield ()
}
