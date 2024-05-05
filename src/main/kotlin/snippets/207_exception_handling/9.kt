package f_207_exception_handling.s_9

import kotlinx.coroutines.*

// 코루틴 예외 핸들러
// 예외 전파를 중단시키지는 않지만 예외가 발생했을 때 해야 할 것들을 정의하는 데 사용할 수 있음.

//sampleStart
fun main(): Unit = runBlocking {
  val handler =
      CoroutineExceptionHandler { ctx, exception ->
          println("Caught $exception")
      }
  val scope = CoroutineScope(SupervisorJob() + handler)
  scope.launch {
      delay(1000)
      throw Error("Some error")
  }

  scope.launch {
      delay(2000)
      println("Will be printed")
  }

  delay(3000)
    println("프린트 된다 (SupervisorJob)")
}
// Caught java.lang.Error: Some error
// Will be printed
//sampleEnd
