package com.personality.main.category

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.personality.R
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class CategoryFragmentTest {

    @Rule
    @JvmField
    var fragmentTestRule = ActivityTestRule(CategoryActivity::class.java, true, true)

    @Test
    fun itShouldReturnTotalCountOfItems() {
        val recyclerView =
            fragmentTestRule.activity.findViewById<RecyclerView>(R.id.recyclerCategoryView)
        val count = (recyclerView.adapter!!).itemCount
        onView(withId(R.id.recyclerCategoryView))
            .perform(scrollToPosition<RecyclerView.ViewHolder>(count - 1))
    }

    @Test
    fun itShouldReturnCorrectItemAtPosition() {
        onView(withId(R.id.recyclerCategoryView))
            .inRoot(RootMatchers.withDecorView(Matchers.`is`(fragmentTestRule.activity.window.decorView)))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
    }
}