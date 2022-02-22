package pawk

import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread

fun main() {

    var num = 1

    // queue of size 5
    val workQueue = LinkedBlockingQueue<Int>(5)

    val producer = thread {
        while(true) {
            workQueue.put(num)
            println("[${num++}] Producer added a new element to the queue")
        }
    }

    val consumer = thread {
        while(true) {
            Thread.sleep(1000)
            println("[${workQueue.take()}] Consumer took an element out of the queue")
        }
    }
}