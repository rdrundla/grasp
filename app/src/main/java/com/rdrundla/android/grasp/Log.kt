package com.rdrundla.android.grasp

import android.util.Log

object Log {
    fun i(tag: String, msg: String) {
        Log.i(getTag(tag), msg)
    }

    fun v(tag: String, msg: String) {
        Log.v(getTag(tag), msg)
    }

    fun d(tag: String, msg: String) {
        Log.d(getTag(tag), msg)
    }

    fun e(tag: String, msg: String) {
        Log.e(getTag(tag), msg)
    }

    private fun getTag(tag: String): String {
        return "GRASP/$tag"
    }
}