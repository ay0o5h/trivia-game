package com.trivia.remote.response


import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("text")
    val text: String?
)