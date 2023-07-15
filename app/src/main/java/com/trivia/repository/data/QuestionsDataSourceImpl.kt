package com.trivia.repository.data

import com.trivia.remote.response.QuestionInfo
import java.util.LinkedList
import java.util.Queue
import javax.inject.Inject

class QuestionsDataSourceImpl @Inject constructor() : QuestionsDataSource {
    private val questionsQueue: Queue<QuestionInfo> = LinkedList()

    override fun setActiveQuestions(questions: List<QuestionInfo>) {
         questionsQueue.addAll(questions)
    }

    override fun getCurrentQuestion(): QuestionInfo? {
       return questionsQueue.poll()
    }

    override fun clear() {
        questionsQueue.clear()
    }
}