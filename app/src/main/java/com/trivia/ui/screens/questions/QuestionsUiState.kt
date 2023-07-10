package com.trivia.ui.screens.questions

import com.trivia.ui.bases.ButtonUIState

data class QuestionsUiState(
    val questions: List<QuestionUiState> = emptyList(),
    val currentQuestionNumber: Int = 1,
    val totalQuestion: Int = 10,
    val passedQuestion: Int = 0,
    val currentTime: Int = 0,
    val maxTime: Int = 30,
    val shouldNavigate: Boolean = false,
    val selectedAnswer: String? = null,
    val selectedAnswerState: ButtonUIState? = null,
    val showCorrect: Boolean = false,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
) {
    data class QuestionUiState(
        val question: String = "",
        val correctAnswer: String = "",
        val otherAnswers: List<String> = emptyList(),
        val optionsAfterShuffled: List<String> = emptyList()
    )

    val currentQuestion: QuestionUiState
        get() = if (questions.isNotEmpty()) questions[currentQuestionNumber - 1] else QuestionUiState()

    val hasSubmitButton: Boolean
        get() = selectedAnswer != null

    val isCorrectAnswer
        get() = selectedAnswer == currentQuestion.correctAnswer

    val isLastQuestion
        get() = currentQuestionNumber == questions.size
}
