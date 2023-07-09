package com.trivia.ui.screens.category

import com.trivia.repository.model.CategoriesType
import com.trivia.ui.bases.ButtonUIState

data class Category(
    val title: String,
    val type: CategoriesType,
    val buttonUIState: ButtonUIState = ButtonUIState.StartState,
)
