package com.trivia.repository

import com.trivia.remote.response.QuestionInfo
import com.trivia.repository.model.CategoriesType
import com.trivia.repository.model.Difficulty

interface TriviaRepository {

    suspend fun getQuestions(category: CategoriesType, difficulty: Difficulty): List<QuestionInfo>

}