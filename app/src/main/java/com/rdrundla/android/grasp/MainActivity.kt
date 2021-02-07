package com.rdrundla.android.grasp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.rdrundla.android.grasp.jobscheduler.JobId
import com.rdrundla.android.grasp.jobscheduler.SchedulerUtil

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun scheduleJob(view: View) {
        Log.i(TAG, "scheduleJob: ")
        SchedulerUtil.schedule(applicationContext, JobId.RANDOM_NUMBER_JOB)
    }

    fun cancelJob(view: View) {
        Log.i(TAG, "cancelJob: ")
        SchedulerUtil.cancel(applicationContext, JobId.RANDOM_NUMBER_JOB)
    }
}