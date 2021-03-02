package com.personality.main.savedresult

import android.os.Bundle
import com.personality.R
import com.personality.main.base.PersonalityBaseActivity

class PersonalityResultActivity : PersonalityBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_detail_activity)
        initActionBar(findViewById(R.id.toolbar))
        title = (getString(R.string.lbl_result))
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PersonalityResultFragment.newInstance())
                .commitNow()
        }
    }

    override fun getAppliedTheme(): Int {
        return R.style.ThemeOverlay_AppCompat_Light
    }
}