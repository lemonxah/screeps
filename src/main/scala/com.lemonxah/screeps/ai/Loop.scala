package com.lemonxah.screeps.ai

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.JSConverters._
import com.lemonxah.screeps.api._
import com.lemonxah.screeps.wrappers._
import com.lemonxah.screeps.wrappers.APIPickler._

import scala.collection.mutable
import prickle._
import com.lemonxah.prickle.WeakRef

import scala.util.{Failure, Success, Try}
import be.doeraene.sjsreflect.Reflect
import com.lemonxah.prickle.{NativeJsConfig, WeakRef}

class Loop() {
  import ScreepsContext._

  implicit val PrickleConfig = NativeJsConfig()

  // Caching doesn't seem to work because for some reason the state gets messed up but not cleared when calling loop.
  //var contextCache: AIContext = null

  def loop(): Unit = {
    PathFinder.use(true)
    //
    //    {
    //      val cls = Reflect.getClassForName("com.lemonxah.screeps.ai.tasks.GetEnergy")
    ////      println(cls)
    //      val cstrs = Reflect.getDeclaredConstructors(cls.get)
    ////      println(cstrs)
    //    }
    Game.creeps.foreach {
      case (name, creep) ⇒ println(s"$name - ${creep.fatigue}")
    }

  }
}
