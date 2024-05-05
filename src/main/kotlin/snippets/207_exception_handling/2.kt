package f_207_exception_handling.s_2

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
코루틴 종료를 멈추기 위해 코루틴 빌더를 try catch로 감싸도 소용없음
코루틴 간의 상호작용은 Job을 통해서 일어나기 떄문
 */
//sampleStart
fun main(): Unit = runBlocking {
    // Don't wrap in a try-catch here. It will be ignored.
    // try catch로 래핑해도 무시된다.
    try {
        launch {
            delay(1000)
            throw Error("Some error")
        }
    } catch (e: Throwable) { // nope, does not help here, 아무일도 일어나지 않는다. (캐치도 못한다)
        println("Will not be printed")
    }

    launch {
        delay(2000)
        println("Will not be printed")
    }
}
// Exception in thread "main" java.lang.Error: Some error...
//sampleEnd
