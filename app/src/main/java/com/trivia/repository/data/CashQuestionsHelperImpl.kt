package com.trivia.repository.data

import com.trivia.remote.response.QuestionInfo
import java.util.LinkedList
import java.util.Queue
import javax.inject.Inject

class CashQuestionsHelperImpl @Inject constructor() : CashQuestionsHelper {
    private val questionsQueue: Queue<QuestionInfo> = LinkedList()

    override fun setActiveQuestions(questions: List<QuestionInfo>) {
         questionsQueue.addAll(questions)
    }

    override fun pollCurrentQuestion(): QuestionInfo? {
       return questionsQueue.poll()
    }

    override fun peekCurrentQuestion(): QuestionInfo? {
        return questionsQueue.peek()
    }

    override fun clear() {
        questionsQueue.clear()
    }
}