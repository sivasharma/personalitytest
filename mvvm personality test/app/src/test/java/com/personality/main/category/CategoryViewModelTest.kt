package com.personality.main.category

import androidx.lifecycle.MutableLiveData
import com.personality.main.model.PersonalityDataWrapper
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CategoryViewModelTest {

    @MockK
    lateinit var categoryUseCaseMock: CategoryUseCase

    lateinit var subject: CategoryViewModel

    @Before
    fun setUp() {
        // initMocks(this)
        MockKAnnotations.init(this, relaxUnitFun = true)
        subject = CategoryViewModel(categoryUseCaseMock)
        // when(categoryUseCaseMock.loadPersonalityData()).re

    }

    @Test
    fun `it should return progressbar status as true when data is initially loaded`() =
        runBlocking {
            subject.loadPersonalityData()

            assertTrue(subject.progressBarStatus.get())
        }

    @Test
    fun `it should not return progressbar status as false when data is fully loaded`() =
        runBlocking {
            subject.loadPersonalityData()

            assertFalse(subject.progressBarStatus.get())
        }

    @Test
    fun `it should post the response when data is successfully received`() =
        runBlocking {
          //  subject.personalityData = MutableLiveData(PersonalityDataWrapper())
            val dd = subject.loadPersonalityData()

         //   subject.personalityData.value

        }
}