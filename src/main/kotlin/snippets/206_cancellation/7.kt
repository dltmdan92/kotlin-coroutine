package f_206_cancellation.s_7

import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            delay(2000)
            println("Job is done")
        } finally {
            println("Finally")
            // 코루틴 정리 과정(cancel) 중에 중단 & 또 다른 코루틴을 허용하지 않는다.
            // 코루틴은 무시되고
            launch { // will be ignored
                println("Will not be printed")
            }
            // 중단은 Exception을 발생시킬 것이다. (CancellationException)
            delay(1000) // here exception is thrown
            println("Will not be printed")
        }
    }
    delay(1000)
    job.cancelAndJoin()
    println("Cancel done")
}
// (1 sec)
// Finally
// Cancel done
