package com.personality.main.logs

import android.util.Log

class PersonalityLogger : LogInterface {
    override fun log(lvl: Int, tag: String, message: String) {
        logTo(lvl, tag, message)
    }

    private fun logTo(lvl: Int, tag: String, message: String) {
        when (lvl) {
            Logger.debug -> Log.d(tag, message)
            Logger.info -> Log.i(tag, message)
            Logger.verbose -> Log.v(tag, message)
            Logger.error -> Log.e(tag, message)
        }
    }
}