package com.rdrundla.android.grasp

import android.util.Log

object Log {
    private val TAG = StringBuilder("GRASP/")

    fun i(tag: String, msg: String) {
        Log.i(TAG.append(tag).toString(), msg)
    }

    fun v(tag: String, msg: String) {
        Log.v(TAG.append(tag).toString(), msg)
    }

    fun d(tag: String, msg: String) {
        Log.d(TAG.append(tag).toString(), msg)
    }

    fun e(tag: String, msg: String) {
        Log.e(TAG.append(tag).toString(), msg)
    }
}