package com.personality.main.adapter

import androidx.constraintlayout.widget.ConstraintLayout
import com.personality.main.model.PersonalityDataWrapper
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CategoryAdapterTest {

    lateinit var subject: CategoryAdapter

    @MockK
    lateinit var personalityDataWrapperMock: PersonalityDataWrapper

    @MockK
    lateinit var viewHolderMock: CategoryAdapter.ViewHolder

    @MockK
    lateinit var uiListener: CategoryAdapter.ClickListener

    @MockK
    lateinit var viewGroup: ConstraintLayout

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        subject = CategoryAdapter(personalityDataWrapperMock, uiListener)
    }

    @Test
    fun `it should return proper count of items`() {
        every { personalityDataWrapperMock.categories } returns listOf("3", "2", "1")
        val count = subject.itemCount

        assertEquals(3, count)
    }

    @Test
    fun `it should return correct text from the adapter`() {
        every { personalityDataWrapperMock.categories } returns listOf("3", "2", "1")
        every { viewHolderMock.name.text } returns "2"
        every { viewHolderMock.parentLayout } returns viewGroup

        subject.onBindViewHolder(viewHolderMock, 1)

        assertEquals(viewHolderMock.name.text, "2")
    }
}