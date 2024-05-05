package f_207_exception_handling.s_6

import kotlinx.coroutines.*

//sampleStart
fun main(): Unit = runBlocking {
    // 예외 전파를 막는 또 다른 방법은 코루틴 빌더를 supervisorScope로 래핑하는 것
  supervisorScope {
      launch {
          delay(1000)
          throw Error("Some error")
      }

      launch {
          delay(2000)
          println("Will be printed")
      }
  }
  delay(1000)
  println("Done")
}
// Exception...
// Will be printed
// (1 sec)
// Done
//sampleEnd
