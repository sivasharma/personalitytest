package com.personality.main.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

class PersonalityDataWrapper {
    @SerializedName("categories")
    val categories: List<String> = Collections.emptyList()

    @SerializedName("questions")
    val questions: List<Questions> = Collections.emptyList()
}