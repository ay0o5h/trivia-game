package com.trivia.ui.screens.questions

import com.trivia.ui.bases.ButtonUIState

data class QuestionsUiState(
    val questions: List<QuestionUiState> = emptyList(),
    val currentQuestionNumber: Int = 1,
    val totalQuestion: Int = 10,
    val passedQuestion: Int = 0,
    val currentTime: Int = 0,
    val maxTime: Int = 30,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val shouldNavigate: Boolean = false,
) {
    data class QuestionUiState(
        val question: String = "",
        val correctAnswerButton: AnswerButton = AnswerButton(),
        val otherAnswerButtons: List<AnswerButton> = emptyList(),
        var optionsAfterShuffled: List<AnswerButton> = emptyList(),
        var selectedAnswerButton: AnswerButton? = null,
    ) {
        val hasSubmitButton: Boolean
            get() = selectedAnswerButton != null

        val isCorrectAnswer
            get() = selectedAnswerButton?.text == correctAnswerButton.text

        fun setSelectedAnswerStateAndShowCorrect(state: ButtonUIState) {
            val position = optionsAfterShuffled.map { it.text }.indexOf(selectedAnswerButton?.text)
            if (position == -1) {
                return
            }
            val newList = optionsAfterShuffled.toMutableList()

            newList.removeAt(position)
            newList.add(
                position,
                optionsAfterShuffled[position].copy(buttonUIState = state)
            )
            optionsAfterShuffled =
                newList.map { it.copy(buttonUIState = if (it.text == correctAnswerButton.text) ButtonUIState.CorrectState else it.buttonUIState) }
        }

        fun highlightSelectedItem() {
            val position = optionsAfterShuffled.map { it.text }.indexOf(selectedAnswerButton?.text)
            if (position == -1) {
                return
            }
            val newList = optionsAfterShuffled.toMutableList()

            newList.removeAt(position)
            newList.add(
                position,
                optionsAfterShuffled[position].copy(buttonUIState = ButtonUIState.ClickedState)
            )
            optionsAfterShuffled =
                newList.map { it.copy(buttonUIState = if (it.text == selectedAnswerButton?.text) it.buttonUIState else ButtonUIState.StartState) }
        }
    }

    data class AnswerButton(
        val text: String = "",
        val buttonUIState: ButtonUIState = ButtonUIState.StartState,
    )

    val currentQuestion: QuestionUiState
        get() = if (questions.isNotEmpty()) questions[currentQuestionNumber - 1] else QuestionUiState()

    val isLastQuestion
        get() = currentQuestionNumber == questions.size
}
