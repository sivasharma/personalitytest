package com.recepie.ui.main.room

import androidx.annotation.WorkerThread
import com.personality.main.room.PersonalityStore
import com.personality.main.room.PersonalityStoreDao

class PersonalityStoreRepository(private val perStoreDao: PersonalityStoreDao) {

    val getPersonalizedList: List<PersonalityStore> = perStoreDao.getPersonalityList()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(pStore: PersonalityStore) {
        perStoreDao.insert(pStore)
    }
}