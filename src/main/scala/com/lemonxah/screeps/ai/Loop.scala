package com.lemonxah.screeps.ai

import com.lemonxah.screeps.ai.Wrapper._
import monix.eval._

class Loop() {
  def run: Task[Unit] = for {
    _ ← usePathfinder(true)
    _ ← gc
  } yield ()
}
