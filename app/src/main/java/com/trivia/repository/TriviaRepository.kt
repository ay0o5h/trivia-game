package com.trivia.repository

import com.trivia.remote.response.QuestionInfo
import com.trivia.repository.model.Categories
import com.trivia.repository.model.Difficulty

interface TriviaRepository {

    suspend fun getQuestions(category: Categories,difficulty: Difficulty): List<QuestionInfo>

}