package com.trivia.viewmodel.questions

data class QuestionsUiState(
    val questions: List<QuestionUiState> = emptyList(),
    val currentQuestionNumber: Int = 1,
    val totalQuestion: Int = 10,
    val passedQuestion: Int = 0,
    val currentTime: Int = 0,
    val maxTime: Int = 30,
    val shouldNavigate: Boolean = false,
) {
    data class QuestionUiState(
        val question: String = "",
        val correctAnswer: String = "",
        val otherAnswers: List<String> = emptyList(),
        val selectedAnswer: String? = null,
        val optionsAfterShuffled: List<String> = emptyList()
    )

    var currentQuestion: QuestionUiState = QuestionUiState()
        get() = if (questions.isNotEmpty()) questions[currentQuestionNumber - 1] else QuestionUiState()

    val hasSubmitButton: Boolean
        get() = currentQuestion.selectedAnswer != null

    val isCorrectAnswer
        get() = currentQuestion.selectedAnswer == currentQuestion.correctAnswer

    val isLastQuestion
        get() = currentQuestionNumber == questions.size
}
