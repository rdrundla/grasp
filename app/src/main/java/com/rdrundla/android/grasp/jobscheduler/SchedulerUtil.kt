package com.rdrundla.android.grasp.jobscheduler

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import com.rdrundla.android.grasp.Log
import com.rdrundla.android.grasp.jobscheduler.JobId.RANDOM_NUMBER_JOB

object SchedulerUtil {

    private val TAG = SchedulerUtil::class.java.simpleName
    fun schedule(context: Context, jobId: JobId) {
        val jobInfo =
            when (jobId) {
                RANDOM_NUMBER_JOB -> {
                    getRandomNumberGeneratorJob(context)
                }
            }

        context.getSystemService(JobScheduler::class.java)
            .schedule(jobInfo)
        Log.i(TAG, "schedule: $jobId Job Scheduled!")
    }

/*    private fun isScheduled(context: Context, jobId: JobId): Boolean {
        return context.getSystemService(JobScheduler::class.java)
            .getPendingJob(jobId.value) != null
    }*/

    fun cancel(context: Context, jobId: JobId) {
        Log.i(TAG, "cancel: $jobId Canceled!")
        context.getSystemService(JobScheduler::class.java)
            .cancel(jobId.value)
    }

    private fun getRandomNumberGeneratorJob(context: Context): JobInfo {
        val componentName = ComponentName(context, RandomNumberJobService::class.java)
        val jobInfoBuilder: JobInfo.Builder = JobInfo.Builder(
            RANDOM_NUMBER_JOB.value,
            componentName
        )
        return jobInfoBuilder
            .setPeriodic(15 * 60 * 1000)
            .setPersisted(true)
            .build()
    }
}
