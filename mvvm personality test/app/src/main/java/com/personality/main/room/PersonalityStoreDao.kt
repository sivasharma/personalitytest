package com.personality.main.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PersonalityStoreDao {

    @Query("SELECT * FROM personality_store ORDER BY question ASC")
     fun getPersonalityList(): List<PersonalityStore>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(personalityStore: PersonalityStore)

    @Query("DELETE FROM personality_store")
    suspend fun deleteAll()
}