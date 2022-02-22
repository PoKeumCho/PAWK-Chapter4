package pawk

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() =

    // Scope context
    runBlocking<Unit> {

                // Supplied context
        launch(Dispatchers.Default) {

            // Coroutine context
            val threadName = Thread.currentThread().name
            println("I'm executing in $threadName")
        }
}