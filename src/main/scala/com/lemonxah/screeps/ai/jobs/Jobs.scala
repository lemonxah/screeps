package com.lemonxah.screeps.ai.jobs

import com.lemonxah.screeps.api._
import com.lemonxah.screeps

/**
  * Project: Screeps
  * Package: com.lemonxah.screeps.ai.jobs
  * Created on 19/11/2016.
  * lemonxah aka lemonxah -
  * https://github.com/lemonxah
  * http://stackoverflow.com/users/2919672/lemon-xah
  */

trait CreepPool {
  def creeps: Vector[Creep]
}

trait Role {

}

case class Job(creep: Creep, role: Role)

object Jobs {

}
