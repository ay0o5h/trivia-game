package com.trivia.ui.screens.question

import com.trivia.remote.response.Question
import com.trivia.remote.response.QuestionInfo
import com.trivia.ui.bases.ButtonUIState

data class QuestionState(
    val progress:String = "0",
    val questionNumber:Int = 0,
    val correctAnswer:String = "",
    val incorrectAnswers: List<String> = listOf(),
    val buttonState:ButtonUIState = ButtonUIState.StartState,
    val question: Question = Question("")
)