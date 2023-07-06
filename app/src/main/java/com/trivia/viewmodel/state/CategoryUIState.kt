package com.trivia.viewmodel.state

import com.trivia.repository.model.CategoriesType

data class CategoryUIState(
    val isButtonNextVisible: Boolean = false,
    val categories: List<Category> = emptyList(),
    val selectedCategory: CategoriesType = CategoriesType.UNKNOWN,
)