package f_201_starting_coroutines.s_6

import kotlinx.coroutines.*

//sampleStart
// main함수를 runBlocking이 아닌 suspend 함수로 정의할 수 있다.
suspend fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    delay(2000L)
}
// Hello,
// (1 sec)
// World!
// World!
// World!
//sampleEnd
