package com.trivia.viewmodel.state

import com.trivia.repository.model.CategoriesType

data class CategoryUIState(
    val isButtonNextVisible: Boolean = false,
    val categories: List<Category> = listOf(
        Category("Music", CategoriesType.MUSIC),
        Category("Film and TV", CategoriesType.FILM_AND_TV),
        Category("Arts and Literature", CategoriesType.ARTS_AND_LITERATURE),
        Category("General Knowledge", CategoriesType.GENERAL_KNOWLEDGE),
    ),
    val selectedCategory: CategoriesType = CategoriesType.UNKNOWN
)