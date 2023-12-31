package com.trivia.ui.screens.difficulty

import com.trivia.repository.model.DifficultiesType
import com.trivia.ui.bases.ButtonUIState

data class Difficulty(
    val title: String,
    val type: DifficultiesType,
    val buttonUIState: ButtonUIState = ButtonUIState.StartState,
)
