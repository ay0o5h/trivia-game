package com.trivia.ui.screens.questions

interface QuestionsInteractionsListener {
    fun onClickAnswer(answer: QuestionsUiState.AnswerButton)
    fun onClickSubmit()
}