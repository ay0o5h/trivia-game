package com.trivia.viewmodel.questions

data class QuestionsUiState(
    val questions: List<QuestionUiState> = emptyList(),
    val questionNumber: Int = 1,
    val totalQuestion: Int = 10,
    val passedQuestion: Int = 0,
    val hasSubmitButton: Boolean = false,
) {
    data class QuestionUiState(
        val question: String = "",
        val correctAnswer: String = "",
        val otherAnswers: List<String> = emptyList(),
        val selectedAnswer: String? = null,
        val optionsAfterShuffled: List<String> = emptyList()
    )
}
