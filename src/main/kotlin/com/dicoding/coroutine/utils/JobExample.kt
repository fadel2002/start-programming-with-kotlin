package com.dicoding.coroutine.utils
import kotlinx.coroutines.*

fun pointer(){}
@InternalCoroutinesApi
fun main() = runBlocking {
    val job = launch {
        delay(3000)
        println("Start new job!")
    }

    delay(2000)
    job.cancel(cause = CancellationException("time is up!"))
    println("Cancelling job...")
    if (job.isCancelled) {
        println("Job is cancelled because ${job.getCancellationException().message}")
    }
}

