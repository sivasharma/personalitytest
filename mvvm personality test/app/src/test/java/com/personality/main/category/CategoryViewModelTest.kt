package com.personality.main.category

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.personality.main.logs.LogInterface
import com.personality.main.logs.Logger
import com.personality.main.model.PersonalityDataWrapper
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


class CategoryViewModelTest {

    @MockK
    lateinit var categoryUseCaseMock: CategoryUseCase

    @MockK
    lateinit var personalityDataWrapperMock: PersonalityDataWrapper

    @MockK
    lateinit var logger: LogInterface

    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var subject: CategoryViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Logger.setLoggerInterface(logger)
        subject = CategoryViewModel(categoryUseCaseMock)
    }

    @Test
    fun `it should return progressbar status as true when data is initially loaded`() {

    }

    @Test
    fun `it should return progressbar status as false when data is fully loaded`() {
        subject.handleResponse(personalityDataWrapperMock)

        assertFalse(subject.progressBarStatus.get())
    }

}