package com.trivia.viewmodel.state

import com.trivia.repository.model.CategoriesType
import com.trivia.ui.bases.ButtonUIState

data class CategoryState(
    val title: String,
    val type: CategoriesType,
    val buttonUIState: ButtonUIState = ButtonUIState.StartState,
)
