package f_208_XXX_coroutine_scope_functions.s_6

import kotlinx.coroutines.*

/**
 * coroutineScope는 중단 메인 함수 본체를 래핑할 떄 주로 사용한다.
 * runBlocking 함수를 coroutineScope가 대체한 것이다.
 *
 */

//sampleStart
suspend fun main(): Unit = coroutineScope {
    launch {
        delay(1000)
        println("World")
    }
    println("Hello, ")
}
// Hello
// (1 sec)
// World
//sampleEnd
