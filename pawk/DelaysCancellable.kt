package pawk

import kotlinx.coroutines.*

suspend fun cancelWithDelay() =
    withContext(Dispatchers.Default) {

        var nextPrintTime = System.currentTimeMillis()

        while(true) {

            delay(10)

            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm working..")
                nextPrintTime += 500
            }
        }
}

fun main() = runBlocking {

    val job = launch {
        try {
            cancelWithDelay()
        } catch (e: CancellationException) {
            // handle cancellation
            println("main: Handle cancellation")
            withContext(NonCancellable) {
                wasteCpu()
            }
        }
    }

    delay(1000)
    job.cancelAndJoin()
    println("main: Done")
}