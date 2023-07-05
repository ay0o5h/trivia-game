package com.trivia.viewmodel.state

import com.trivia.repository.model.CategoriesType

data class Category(
    val title: String,
    val type: CategoriesType
)