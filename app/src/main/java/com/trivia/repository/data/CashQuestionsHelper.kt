package com.trivia.repository.data

import com.trivia.remote.response.QuestionInfo

interface CashQuestionsHelper {
    fun setActiveQuestions(questions: List<QuestionInfo>)
    fun pollCurrentQuestion(): QuestionInfo?
    fun peekCurrentQuestion(): QuestionInfo?
    fun clear()
}