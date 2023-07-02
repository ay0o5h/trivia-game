package com.trivia.respository.datasourses

import com.trivia.remote.TriviaService
import com.trivia.remote.resourses.QuestionInfoResource
import javax.inject.Inject

interface RemoteDataSource  {
    suspend fun getQuestions(
        limit: Int = 10,
        categories: String,
        difficulty: String,
        type: String = "text_choice",
    ) :List<QuestionInfoResource>

    suspend fun getQuestionById(
        id: Int,
    ) :QuestionInfoResource
}