package f_206_cancellation.s_12

import kotlinx.coroutines.*

//sampleStart
suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        repeat(1_000) { i ->
            Thread.sleep(200)
            // yield는 코루틴을 중단하고 즉시 재실행한다.
            // 중단점이 생겼기 때문에 취소를 포함해 중단 중에 필요한 모든 작업을 할 수 있게 된다.
            yield()
            println("Printing $i")
        }
    }
    delay(1100)
    job.cancelAndJoin()
    println("Cancelled successfully")
    delay(1000)
}
// Printing 0
// Printing 1
// Printing 2
// Printing 3
// Printing 4
// Cancelled successfully
//sampleEnd
