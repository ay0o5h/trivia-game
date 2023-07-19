package com.trivia.ui.screens.questions

import com.trivia.ui.bases.ButtonUIState

data class QuestionsUiState(
    val currentQuestionNumber: Int = 1,
    val totalQuestion: Int = 10,
    val passedQuestion: Int = 0,
    val currentTime: Int = 0,
    val maxTime: Int = 30,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val shouldNavigate: Boolean = false,
    val question: String = "",
    val correctAnswerButton: AnswerButton = AnswerButton(),
    val options: List<AnswerButton> = emptyList(),
    val selectedAnswerButton: AnswerButton? = null,
) {

    data class AnswerButton(
        val text: String = "",
        val buttonUIState: ButtonUIState = ButtonUIState.StartState,
    )

    val isLastQuestion
        get() = currentQuestionNumber == 10

    val hasSubmitButton: Boolean
        get() = options.any { it.buttonUIState == ButtonUIState.ClickedState }

    val isCorrectAnswer
        get() = selectedAnswerButton != null && selectedAnswerButton.text == correctAnswerButton.text

}

data class QuestionUiState(
    val question: String = "",
    val correctAnswerButton: QuestionsUiState.AnswerButton = QuestionsUiState.AnswerButton(),
    val otherAnswerButtons: List<QuestionsUiState.AnswerButton> = emptyList(),
    var optionsAfterShuffled: List<QuestionsUiState.AnswerButton> = emptyList(),
    var selectedAnswerButton: QuestionsUiState.AnswerButton? = null,
)