package f_201_starting_coroutines.s_1

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//sampleStart
fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("${Thread.currentThread().name} World!")
    }
    GlobalScope.launch {
        delay(1000L)
        println("${Thread.currentThread().name} World!")
    }
    GlobalScope.launch {
        delay(1000L)
        println("${Thread.currentThread().name} World!")
    }
    println("${Thread.currentThread().name} Hello,")
    Thread.sleep(2000L)
}
// Hello,
// (1초후)
// World!
// World!
// World!
//sampleEnd
