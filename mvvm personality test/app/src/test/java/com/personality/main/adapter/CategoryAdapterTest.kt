package com.personality.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.personality.R
import com.personality.databinding.ItemCategoryBinding
import com.personality.main.model.PersonalityDataWrapper
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

class CategoryAdapterTest {

    lateinit var subject: CategoryAdapter

    @MockK
    lateinit var viewMock: View

    @MockK
    private lateinit var viewGroupMock: ViewGroup

    @MockK
    lateinit var personalityDataWrapperMock: PersonalityDataWrapper

    @MockK
    lateinit var layoutInflaterMock: LayoutInflater

    @MockK
    lateinit var listenerMock: CategoryAdapter.ClickListener

    @Mock
    private val contextMock: Context? = null

    @MockK
    private lateinit var viewBinderMock: ItemCategoryBinding

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
      //  PowerMockito.mockStatic(LayoutInflater::class.java)

        subject = CategoryAdapter(personalityDataWrapperMock, listenerMock)
    }

    @Test
    fun `it should return proper count of items`() {
        every { personalityDataWrapperMock.categories } returns listOf("3", "2", "1")
        val count = subject.itemCount

        assertEquals(3, count)
    }

    @Test
    fun `bind view holder`() {
        subject.onBindViewHolder(createViewHolder(), 2)
    }

    private fun createViewHolder(): CategoryAdapter.ViewHolder {
        val layoutId: Int = R.layout.item_category
        every { viewGroupMock.context } returns contextMock

        every {
            DataBindingUtil.inflate<ItemCategoryBinding>(
                layoutInflaterMock,
                layoutId,
                viewGroupMock,
                false
            )} returns viewBinderMock

        every { LayoutInflater.from(contextMock) } returns layoutInflaterMock

        every { viewBinderMock.root } returns viewMock
        return subject.onCreateViewHolder(viewGroupMock, layoutId)
    }

}