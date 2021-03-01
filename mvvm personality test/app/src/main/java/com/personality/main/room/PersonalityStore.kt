package com.personality.main.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personality_store")
class PersonalityStore(
    @PrimaryKey()
    @ColumnInfo(name = "question")
    val question: String,
    @ColumnInfo(name = "option")
    val option: String,
)