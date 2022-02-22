package pawk

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {

        val child1 = launch {
            delay(Long.MAX_VALUE)
        }

        val child2 = launch {
            // child1 coroutine 동작이 끝날 때까지 대기한다.
            child1.join()
            println("Child 1 is cancelled")

            delay(100)
            println("Child 2 is still alive")
        }

        println("Cancelling child 1...")
        child1.cancel()
        child2.join()
        println("Parent is not cancelled")
    }

    job.join()
}
