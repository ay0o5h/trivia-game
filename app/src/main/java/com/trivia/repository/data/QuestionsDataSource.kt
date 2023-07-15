package com.trivia.repository.data

import com.trivia.remote.response.QuestionInfo

interface QuestionsDataSource {
    fun setActiveQuestions(questions: List<QuestionInfo>)
    fun getCurrentQuestion(): QuestionInfo?
    fun clear()
}