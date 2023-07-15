package com.trivia.repository.data

import com.trivia.remote.response.QuestionInfo

interface CashQuestionsHelper {
    fun setActiveQuestions(questions: List<QuestionInfo>)
    fun getCurrentQuestion(): QuestionInfo?
    fun clear()
}