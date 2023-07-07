package com.trivia.remote.response

import com.google.gson.annotations.SerializedName


data class QuestionInfo(
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("correctAnswer")
    val correctAnswer: String? = null,
    @SerializedName("difficulty")
    val difficulty: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("incorrectAnswers")
    val incorrectAnswers: List<String>? = null,
    @SerializedName("isNiche")
    val isNiche: Boolean? = null,
    @SerializedName("question")
    val question: Question? = null,
    @SerializedName("regions")
    val regions: List<String?>? = null,
    @SerializedName("tags")
    val tags: List<String?>? = null,
    @SerializedName("type")
    val type: String? = null
)