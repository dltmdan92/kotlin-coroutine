package f_201_starting_coroutines.s_4

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

//sampleStart
fun main() {
    runBlocking {
        delay(1000L)
        println("${Thread.currentThread().name} World!")
    }
    runBlocking {
        delay(1000L)
        println("${Thread.currentThread().name} World!")
    }
    runBlocking {
        delay(1000L)
        println("${Thread.currentThread().name} World!")
    }
    println("${Thread.currentThread().name} Hello,")
}
// (1초 후)
// World!
// (1초 후)
// World!
// (1초 후)
// World!
// Hello,
//sampleEnd
