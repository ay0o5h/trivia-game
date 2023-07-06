package com.trivia.repository

import com.trivia.remote.response.QuestionInfo
import com.trivia.repository.model.CategoriesType
import com.trivia.repository.model.DifficultiesType
import com.trivia.viewmodel.state.Category
import com.trivia.viewmodel.state.Difficulty

interface TriviaRepository {

    suspend fun getQuestions(category: CategoriesType, difficultiesType: DifficultiesType): List<QuestionInfo>

    fun getCategories(): List<Category>

    fun getDifficulty(): List<Difficulty>
}