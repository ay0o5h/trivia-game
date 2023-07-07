package com.trivia.repository.data

import com.trivia.repository.model.CategoriesType
import com.trivia.repository.model.DifficultiesType
import com.trivia.viewmodel.state.Category
import com.trivia.viewmodel.state.Difficulty

object Data {

    val categories = listOf(
        Category("Music", CategoriesType.MUSIC),
        Category("Film and TV", CategoriesType.FILM_AND_TV),
        Category("Arts and Literature", CategoriesType.ARTS_AND_LITERATURE),
        Category("General Knowledge", CategoriesType.GENERAL_KNOWLEDGE),
    )

    val difficulties = listOf(
        Difficulty("Easy", DifficultiesType.EASY),
        Difficulty("Medium", DifficultiesType.MEDIUM),
        Difficulty("Hard", DifficultiesType.HARD),
    )
}