package com.trivia.ui.screens.category

import com.trivia.repository.model.CategoriesType
import com.trivia.ui.screens.category.Category

data class CategoryUIState(
    val isButtonNextVisible: Boolean = false,
    val categories: List<Category> = emptyList(),
    val selectedCategory: CategoriesType = CategoriesType.UNKNOWN,
)