package pawk

import kotlinx.coroutines.*

suspend fun wasteCpu() = withContext(Dispatchers.Default) {

    var nextPrintTime = System.currentTimeMillis()

    while(isActive) {   // make it cancellable
        if (System.currentTimeMillis() >= nextPrintTime) {
            println("job: I'm working..")
            nextPrintTime += 500
        }
    }

    // clean up
    if (!isActive) {

    }
}

fun main() = runBlocking {

    val job = launch {
        try {
            wasteCpu()
        } catch (e: CancellationException) {
            // handle cancellation
            println("main: Handle cancellation")
        }
    }

    delay(1000)

    // 현재 coroutine 에 종료하라는 신호를 보내고, 정상 종료할 때까지 대기한다.
    job.cancelAndJoin()

    println("main: Done")
}