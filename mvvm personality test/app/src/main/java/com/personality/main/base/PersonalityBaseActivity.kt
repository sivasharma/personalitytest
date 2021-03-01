package com.personality.main.base

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.personality.R

abstract class PersonalityBaseActivity : AppCompatActivity() {

    private var toolbarTitle: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        theme.applyStyle(getAppliedTheme(), true)
    }

    protected fun initActionBar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            toolbarTitle = toolbar.findViewById(R.id.toolbar_title)
            this.toolbarTitle = toolbarTitle
            actionBar.setDisplayShowHomeEnabled(false)
            actionBar.setDisplayShowTitleEnabled(false)
            actionBar.setDisplayShowCustomEnabled(true)
        }
    }

    override fun setTitle(title: CharSequence?) {
        toolbarTitle?.text = title
    }

    protected abstract fun getAppliedTheme(): Int
}