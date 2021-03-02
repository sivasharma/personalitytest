package com.personality.main.category


import android.content.Context
import com.android.volley.Response
import com.nhaarman.mockitokotlin2.whenever
import com.personality.main.service.GsonRequest
import com.personality.main.service.VolleyService
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.powermock.api.mockito.PowerMockito.whenNew


class CategoryUseCaseTest {

    @MockK
    lateinit var contextMock: Context

    @MockK
    var volleyService = VolleyService

    lateinit var subject: CategoryUseCase

    @MockK
    lateinit var gsonRequestMock: GsonRequest<*>

    @MockK
    private lateinit var mockErrorResponse: Response.ErrorListener

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = false)

        whenNew(GsonRequest::class.java).withAnyArguments(
        ).thenReturn(gsonRequestMock)

        whenever(gsonRequestMock.errorListener).thenReturn(mockErrorResponse)

        subject = CategoryUseCase(contextMock, volleyService)
    }

    @Test
    fun `it should load personality data when called`() = runBlocking {

    }
}