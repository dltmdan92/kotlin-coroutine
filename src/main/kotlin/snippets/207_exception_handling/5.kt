package f_207_exception_handling.s_5

import kotlinx.coroutines.*

//sampleStart
fun main(): Unit = runBlocking {
    // 하나의 코루틴이 취소되어도 다른 코루틴이 취소되지 않는다는 점에서,
    // 같은 잡을 다수의 코루틴에서 컨텍스트로 사용하는 것이 좀 더 낫다.
  val job = SupervisorJob()
  launch(job) {
      delay(1000)
      throw Error("Some error")
  }
  launch(job) {
      delay(2000)
      println("Will be printed")
  }
  job.join()
}
// (1 sec)
// Exception...
// (1 sec)
// Will be printed
//sampleEnd
