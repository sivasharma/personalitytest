package com.personality.main.categorydetail

import android.os.Bundle
import com.personality.R
import com.personality.main.base.PersonalityBaseActivity

class CategoryDetailActivity : PersonalityBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_detail_activity)
        initActionBar(findViewById(R.id.toolbar))
        title = (getString(R.string.lbl_category_detail))
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CategoryDetailFragment.newInstance())
                .commitNow()
        }
    }

    override fun getAppliedTheme(): Int {
        return R.style.ThemeOverlay_AppCompat_Light
    }
}