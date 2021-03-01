package com.personality.main.savedresult

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.personality.R

class PersonalityResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_detail_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PersonalityResultFragment.newInstance())
                .commitNow()
        }
    }
}