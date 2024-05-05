package f_207_exception_handling.s_1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
코루틴에서도 잡히지 않은 예외가 발생했을 때 종료된다. (스레드도 비슷)
차이점 - 코루틴 빌더는 부모도 종료시키며(예외 전파), 취소된 부모는 자식들 모두를 취소시킨다. 그리고 부모에게 전파한다.
runBlocking은 부모가 없는 코루틴이기 때문에 프로그램을 종료시킨다. (runBlocking은 예외를 다시 던진다.)
 */

//sampleStart
fun main(): Unit = runBlocking {
    launch {
        launch {
            delay(1000)
            throw Error("Some error")
        }

        launch {
            delay(2000)
            println("Will not be printed")
        }

        launch {
            delay(500) // faster than the exception
            println("Will be printed")
        }
    }

    launch {
        delay(2000)
        println("Will not be printed")
    }
}
// Will be printed
// Exception in thread "main" java.lang.Error: Some error...
//sampleEnd
