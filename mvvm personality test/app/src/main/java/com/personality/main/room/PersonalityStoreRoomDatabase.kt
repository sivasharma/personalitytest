package com.personality.main.room

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PersonalityStore::class], version = 1, exportSchema = false)
abstract class PersonalityStoreRoomDatabase : RoomDatabase() {

    abstract fun personalityStoreDao(): PersonalityStoreDao

    companion object {
        @Volatile
        private var INSTANCE: PersonalityStoreRoomDatabase? = null

        @SuppressLint("SyntheticAccessor")
        fun getDatabase(context: Context): PersonalityStoreRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonalityStoreRoomDatabase::class.java,
                    "personality_store_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}