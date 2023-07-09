package com.trivia.viewmodel.questions

interface QuestionsInteractionsListener {
    fun onClickAnswer(answer: String)
    fun onClickSubmit()
}