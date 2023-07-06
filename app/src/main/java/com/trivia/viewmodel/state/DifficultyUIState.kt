package com.trivia.viewmodel.state

import com.trivia.repository.model.DifficultiesType

data class DifficultyUIState(
    val isButtonNextVisible: Boolean = false,
    val difficulties: List<Difficulty> = emptyList(),
    val selectedDifficulty: DifficultiesType = DifficultiesType.UNKNOWN,
)
