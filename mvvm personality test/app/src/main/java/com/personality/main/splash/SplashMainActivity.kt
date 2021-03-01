package com.personality.main.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.personality.R
import com.personality.main.logs.Logger
import com.personality.main.logs.PersonalityLogger

class SplashMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        initLogger()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container,
                        SplashFragment.newInstance()
                    )
                    .commitNow()
        }
    }

    private fun initLogger() {
        Logger.setLoggerInterface(PersonalityLogger())
    }
}