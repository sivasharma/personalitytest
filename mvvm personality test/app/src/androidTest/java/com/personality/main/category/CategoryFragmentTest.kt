package com.personality.main.category

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import com.personality.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CategoryFragmentTest {

    @get:Rule
    var fragmentTestRule: IntentsTestRule<CategoryActivity> =
        IntentsTestRule(CategoryActivity::class.java)

    @Test
    fun itShouldReturnTotalCountOfItems() {
        val recyclerView =
            fragmentTestRule.activity.findViewById<RecyclerView>(R.id.recyclerCategoryView)
        val count = (recyclerView.adapter ?: return).itemCount
        onView(withId(R.id.recyclerCategoryView))
            .perform(scrollToPosition<RecyclerView.ViewHolder>(count - 1))
    }

    @Test
    fun itShouldReturnCorrectItemAtPosition() {
        val recyclerView = fragmentTestRule.activity.findViewById<RecyclerView>(R.id.recyclerCategoryView)
       // val count = recyclerView.adapter?.getItemId(0)

        onView(withId(R.id.recyclerCategoryView)).perform(scrollToPosition<RecyclerView.ViewHolder>(2)).check(matches(withText("lifeStyle")))
    }
}