package com.lemonxah.screeps.ai

import com.lemonxah.screeps.api._
import monix.execution.Scheduler.Implicits.global

import scala.scalajs.js
import scala.scalajs.js.annotation._

object Main extends js.JSApp {
  def main(): Unit = {
    println("This should not be called")
  }

  @JSExport
  def getLoop(ctx: ScreepsContextImpl): js.Function0[Unit] = {
    ScreepsContext.current = ctx

    val loop = new Loop()
    () => {
      try {
        loop.run.runAsync
      } catch {
        case e: Throwable =>
          ctx.Console.log(s"Exception while running loop: $e")
      }
      ()
    }
  }
}
