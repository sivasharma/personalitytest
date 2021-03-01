package com.personality.main.category

import android.os.Bundle
import com.personality.R
import com.personality.main.base.PersonalityBaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryActivity : PersonalityBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_activity)
        initActionBar(findViewById(R.id.toolbar))
        title = (getString(R.string.lbl_category))
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CategoryFragment.newInstance())
                .commitNow()
        }
    }

    override fun getAppliedTheme(): Int {
        return R.style.ThemeOverlay_AppCompat_Light
    }
}