package com.personality.main.model

import com.google.gson.annotations.SerializedName

class Positive {
    @SerializedName("question")
    val pQuestion: String? = null

    @SerializedName("category")
    val pCategory: String? = null

    @SerializedName("question_type")
    val questionType: QuestionType? = null
}
