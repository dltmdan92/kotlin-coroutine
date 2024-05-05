package f_206_cancellation.s_8

import kotlinx.coroutines.*
import kotlin.random.Random

//sampleStart
suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            delay(200)
            println("Coroutine finished")
        } finally {
            println("Finally")
            // 코루틴이 취소되었는데 중단 함수를 반드시 호출해야 하는 경우
            // ex) DB 롤백 등
            // NonCancellable 이라는 별도의 컨텍스트를 사용한다.
            withContext(NonCancellable) {
                delay(1000L)
                println("Cleanup done")
            }
        }
    }
    delay(100)
    println("before cancelAndJoin")
    job.cancelAndJoin()
    println("Done")
}
// Finally
// Cleanup done
// Done
//sampleEnd
