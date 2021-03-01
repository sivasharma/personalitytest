package com.personality.main.room

import com.nhaarman.mockitokotlin2.whenever
import com.recepie.ui.main.room.PersonalityStoreRepository

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks

class PersonalityStoreRepositoryTest {

    lateinit var subject: PersonalityStoreRepository

    @Mock
    lateinit var personalityStoreDaoMock: PersonalityStoreDao

    @Before
    fun setUp() {
        initMocks(this)
        subject = PersonalityStoreRepository(personalityStoreDaoMock)
    }

    @Test
    fun `it Should insert data successfully`() = runBlocking {
        val pStore = PersonalityStore("sample", "test")
        subject.insert(pStore)

        verify(personalityStoreDaoMock).insert(pStore)

        assertEquals(pStore.question, "sample")
        assertEquals(pStore.option, "test")
    }

    @Test
    fun `it should return size zero when no data is added`() {
        val subject = getPersonalityStoreRepository()
        val result = subject.getPersonalizedList

        assertEquals(result.size, 0)
    }

    @Test
    fun `it should return proper count when data is inserted`() = runBlocking {
        val pStore1 = PersonalityStore("sample", "test")
        val pStore2 = PersonalityStore("sample", "test")
        whenever(personalityStoreDaoMock.getPersonalityList()).thenReturn(listOf(pStore1, pStore2))
        subject = getPersonalityStoreRepository()
        val result = subject.getPersonalizedList

        assertEquals(result.size, 2)
    }

    private fun getPersonalityStoreRepository(): PersonalityStoreRepository {
        return PersonalityStoreRepository(personalityStoreDaoMock)
    }
}