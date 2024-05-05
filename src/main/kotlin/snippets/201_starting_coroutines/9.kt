package f_201_starting_coroutines.s_9

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

// async 코루틴 빌더는 return 값이 있어야 한다.
// launch는 리턴 값이 필요하지 않을 때 사용한다.

//sampleStart
suspend fun main() = coroutineScope {
    println("A")
    val start = System.currentTimeMillis()
    println("$start")
    val a: Deferred<Int> = async {
        println("${Thread.currentThread().name}")
        delay(1000L)
        10
    }
    println("B")
    val b: Deferred<Int> = async {
        println("${Thread.currentThread().name}")
        delay(1000L)
        20
    }
    println("C")
    println(a.await() + b.await())
    val end = System.currentTimeMillis()
    println("$end")
    println(end - start)
}
// A
// B
// C
// (1 sec)
// 30
//sampleEnd
