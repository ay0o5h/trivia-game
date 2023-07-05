package com.trivia.viewmodel.state

import com.trivia.repository.model.CategoriesType

data class CategoryUIState(
    val isButtonNextVisible: Boolean = false,
    val categories: List<CategoryState> = listOf(
        CategoryState("Music", CategoriesType.MUSIC),
        CategoryState("Film and TV", CategoriesType.FILM_AND_TV),
        CategoryState("Arts and Literature", CategoriesType.ARTS_AND_LITERATURE),
        CategoryState("General Knowledge", CategoriesType.GENERAL_KNOWLEDGE),
    ),
    val selectedCategory: CategoriesType = CategoriesType.UNKNOWN,
)