package pawk

import kotlinx.coroutines.*
import java.lang.AssertionError

fun main() = runBlocking {

    val ceh = CoroutineExceptionHandler { _, exception ->
        println("Handled $exception")
    }
    val supervisor = SupervisorJob()
    val scope = CoroutineScope(coroutineContext + ceh + supervisor)
    with (scope) {

        val firstChild = launch {
            println("First child is failing")
            throw AssertionError("First child is cancelled")
        }

        val secondChild = launch {
            firstChild.join()

            delay(10)
            println("First child is cancelled: ${firstChild.isCancelled}, " +
                    "but second one is still active")
        }

        // wait until the second child completes
        secondChild.join()
    }
}