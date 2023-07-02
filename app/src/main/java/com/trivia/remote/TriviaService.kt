package com.trivia.remote

import com.trivia.remote.resourses.QuestionInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TriviaService {

    @GET("questions")
    suspend fun getQuestions(
        @Query("limit") limit: Int = 10,
        @Query("categories") categories: String,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String = "text_choice",
    ): Response<List<QuestionInfo>>

    @GET("question/{id}")
    suspend fun getQuestionById(
        @Path("id") id: Int,
    ): Response<QuestionInfo>
}