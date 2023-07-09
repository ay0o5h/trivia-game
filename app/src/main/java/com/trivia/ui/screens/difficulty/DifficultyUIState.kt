package com.trivia.ui.screens.difficulty

import com.trivia.repository.model.DifficultiesType
import com.trivia.ui.screens.difficulty.Difficulty

data class DifficultyUIState(
    val isButtonNextVisible: Boolean = false,
    val difficulties: List<Difficulty> = emptyList(),
    val selectedDifficulty: DifficultiesType = DifficultiesType.UNKNOWN,
)
