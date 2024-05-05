package f_207_exception_handling.s_8

import kotlinx.coroutines.*

// CancellationException은 부모까지 전파되지 않는다. 현재 코루틴을 취소시킬 뿐이다. 그리고 자식 코루틴 또한 취소시킨다.
object MyNonPropagatingException : CancellationException()

suspend fun main(): Unit = coroutineScope {
  launch { // 1
      launch { // 2
          delay(2000)
          println("Will not be printed")
      }
      throw MyNonPropagatingException // 3
  }
  launch { // 4
      delay(2000)
      println("Will be printed")
  }
}
// (2 sec)
// Will be printed
