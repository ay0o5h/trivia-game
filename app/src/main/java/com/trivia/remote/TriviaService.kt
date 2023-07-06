package com.trivia.remote

import com.trivia.remote.response.QuestionInfo
import com.trivia.repository.model.CategoriesType
import com.trivia.repository.model.DifficultiesType
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TriviaService {

    @GET("questions")
    suspend fun getQuestions(
        @Query("limit") limit: Int = 10,
        @Query("categories") categoriesType: CategoriesType,
        @Query("difficulty") difficultiesType: DifficultiesType,
        @Query("type") type: String = "text_choice",
    ): Response<List<QuestionInfo>>

    @GET("question/{id}")
    suspend fun getQuestionById(
        @Path("id") id: Int,
    ): Response<QuestionInfo>
}