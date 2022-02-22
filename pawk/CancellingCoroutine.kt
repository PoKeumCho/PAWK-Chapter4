package pawk

import kotlinx.coroutines.*


fun main() = runBlocking {

    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime

        // while(true) {
        while(isActive) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm working..")
                nextPrintTime += 500
            }
        }

        if (!isActive) {
            throw CancellationException()
        }
    }
    delay(1200)
    println("main: I'm going to cancel this job")
    job.cancel()
    println("main: Done")
}