package f_201_starting_coroutines.s_6

import kotlinx.coroutines.*

//sampleStart
fun main() = runBlocking {
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
