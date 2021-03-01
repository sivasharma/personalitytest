package com.personality.main.model

import com.google.gson.annotations.SerializedName
import java.util.*

class QuestionType {
    @SerializedName("type")
    val type: String? = null

    @SerializedName("options")
    val options: List<String> = Collections.emptyList()

    @SerializedName("condition")
    val condition: Conditions? = null

    @SerializedName("range")
    val range: QuestionsRange? = null
}
