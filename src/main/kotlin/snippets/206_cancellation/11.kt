package f_206_cancellation.s_11

import kotlinx.coroutines.*

//sampleStart
suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        repeat(1_000) { i ->
            // 중단점은 delay이어야 한다.
            // Thread.sleep은 코루틴의 중단점도 아니고 절대로 써서는 안된다.
            Thread.sleep(200) // We might have some
            // complex operations or reading files here
            println("Printing $i")
        }
    }
    delay(1000)
    job.cancelAndJoin()
    println("Cancelled successfully")
    delay(1000)
}
// Printing 0
// Printing 1
// Printing 2
// ... (up to 1000)
//sampleEnd
