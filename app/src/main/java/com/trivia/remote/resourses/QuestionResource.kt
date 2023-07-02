package com.trivia.remote.resourses


import com.google.gson.annotations.SerializedName

data class QuestionResource(
    @SerializedName("text")
    val text: String?
)