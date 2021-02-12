package com.rdrundla.android.grasp.jobscheduler

import android.app.job.JobParameters
import android.app.job.JobService
import com.rdrundla.android.grasp.Log
import kotlinx.coroutines.*
import kotlin.random.Random

class RandomNumberJobService : JobService() {
    var job: Job? = null
    override fun onStartJob(params: JobParameters?): Boolean {
        Log.i(TAG, "onStartJob: ")

        job = GlobalScope.launch {
            for (i in 1..10) {
                if (isActive) {
                    generateRandomNumber()
                    delay(1000)
                }
            }
        }
        return true
    }

    private fun generateRandomNumber() {
        Log.i(TAG, "randomNumber: " + random.nextInt(100))
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.i(TAG, "onStopJob")
        job?.cancel()
        return true
    }

    companion object {
        private val TAG = RandomNumberJobService::class.java.simpleName
        private val random = Random(0)
    }
}
