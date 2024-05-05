package f_207_exception_handling.s_3

import kotlinx.coroutines.*



/*
코루틴 종료를 멈추는 가장 중요한 방법은 SupervisorJob을 사용하는 것
SupervisorJob을 사용하면 자식에서 발생한 모든 예외를 무시할 수 있음
 */
//sampleStart
fun main(): Unit = runBlocking {
  val scope = CoroutineScope(SupervisorJob())
  scope.launch {
      delay(1000)
      throw Error("Some error")
  }

  scope.launch {
      delay(2000)
      println("Will be printed")
  }

  delay(3000)
}
// Exception...
// Will be printed
//sampleEnd
