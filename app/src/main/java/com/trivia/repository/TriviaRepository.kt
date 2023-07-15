package com.trivia.repository

import com.trivia.remote.response.QuestionInfo
import com.trivia.repository.model.CategoriesType
import com.trivia.repository.model.DifficultiesType
import com.trivia.ui.screens.category.Category
import com.trivia.ui.screens.difficulty.Difficulty

interface TriviaRepository {

    suspend fun getCurrentQuestion(category: CategoriesType, difficultiesType: DifficultiesType): QuestionInfo

    fun getCategories(): List<Category>

    fun getDifficulty(): List<Difficulty>
}