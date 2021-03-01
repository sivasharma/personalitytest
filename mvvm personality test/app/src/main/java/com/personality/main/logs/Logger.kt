package com.personality.main.logs

import com.personality.BuildConfig


object Logger {
     const val verbose = 2
     const val debug = 3
     const val info = 4
     const val error = 6

    fun setLoggerInterface(logInterface: LogInterface) {
        this.logger = logInterface
    }

    private lateinit var logger: LogInterface

    fun v(tag: String, message: String) {
        safeLog(verbose, tag, message)
    }

    fun d(tag: String, message: String) {
        safeLog(debug, tag, message)
    }

    fun i(tag: String, message: String) {
        safeLog(info, tag, message)
    }

    fun e(tag: String, message: String) {
        safeLog(error, tag, message)
    }

    private fun safeLog(lvl: Int, tag: String, message: String?) {
        if (!BuildConfig.IS_PRODUCTION && message != null) {
            logger.log(lvl, tag, message)
        }
    }
}