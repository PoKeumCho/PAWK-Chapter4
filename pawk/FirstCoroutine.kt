package pawk

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val job: Job = launch {
        var i = 0
        while(true) {
            println("$i I'm working")
            i++
            delay(10)
            //Thread.sleep(10L)
        }
    }

    delay(30)
    job.cancel()
}