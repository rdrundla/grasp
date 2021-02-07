package com.rdrundla.android.grasp.jobscheduler

import android.app.job.JobParameters
import android.app.job.JobService
import com.rdrundla.android.grasp.Log
import kotlin.random.Random

class RandomNumberJobService : JobService() {

    private val TAG = RandomNumberJobService::class.java.simpleName

    private val random = Random(0)

    override fun onStartJob(params: JobParameters?): Boolean {
        Log.i(TAG, "onStartJob: ")
        Thread {
            for (i in 1..20) {
                generateRandomNumber()
                Thread.sleep(1000)
            }
        }.start()
        return true
    }

    private fun generateRandomNumber() {
        Log.i(TAG, "randomNumber: " + random.nextInt(100))
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.i(TAG, "onStopJob")
        return true
    }
}
