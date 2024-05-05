package f_207_exception_handling.s_4

import kotlinx.coroutines.*

/*
아래 예제에서는 SupervisorJob은 단 하나의 자식만 가지기 떄문에 예외를 처리하는 데 아무런 도움이 안됨
Job은 코루틴 컨텍스트 중에서 상속되지 않는 유일한 컨텍스트이다.
코루틴은 각각 자신만의 잡을 가지고 있고, 잡을 다른 코루틴에 전달하여 부모 관계를 맺는다.
여기서 SupervisorJob()이 첫번쨰 launch의 부모가 되고, 자식 코루틴에서 예외가 발생하면 첫번쨰 launch 코루틴으로 전달이 되며, Job이 취소되고 자식 코루틴 또한 전부 취소되며 마지막으로 예외가 던져진다.
 */

//sampleStart
fun main(): Unit = runBlocking {
    // Don't do that, SupervisorJob with one children
    // and no parent works similar to just Job
    launch(SupervisorJob()) { // 1
        launch {
            delay(1000)
            throw Error("Some error")
        }

        launch {
            delay(2000)
            println("Will not be printed")
        }
    }

    delay(3000)
}
// Exception...
//sampleEnd
