package f_206_cancellation.s_9

import kotlinx.coroutines.*

//sampleStart
suspend fun main(): Unit = coroutineScope {
    val job = launch {
        delay(1000)
    }
    // invokeCompletion: 잡이 'Completed' 또는 "Cancelled"와 같은 마지막 상태에 도달했을 때 호출될 핸들러를 지정한다.
    // 핸들러의 파라미터인 exception은 잡이 예외없이 끝나면 null이다.
    // 코루틴이 취소되었으면 CancellationException이 된다.
    job.invokeOnCompletion { exception: Throwable? ->
        println("Finished")
        println("The exception was: $exception") // JobCancellationException
    }
    delay(400)
    job.cancelAndJoin()
}
// Finished
//sampleEnd
