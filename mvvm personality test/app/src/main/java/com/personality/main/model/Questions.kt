package com.personality.main.model

import com.google.gson.annotations.SerializedName

class Questions {
    @SerializedName("question")
    val question: String? = null

    @SerializedName("category")
    val category: String? = null

    @SerializedName("question_type")
    val questionType: QuestionType? = null
}