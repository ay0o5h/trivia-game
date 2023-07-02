package com.trivia.remote.resourses


import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("text")
    val text: String?
)