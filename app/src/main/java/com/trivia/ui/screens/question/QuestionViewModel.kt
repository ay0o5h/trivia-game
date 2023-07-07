package com.trivia.ui.screens.question


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.trivia.remote.response.QuestionInfo
import com.trivia.repository.TriviaRepository
import com.trivia.repository.model.CategoriesType
import com.trivia.repository.model.Difficulty
import com.trivia.ui.bases.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(
    private val repository: TriviaRepository,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<QuestionState>(QuestionState()) {


    private val args: Int = savedStateHandle["category"] ?: 0

    var questions by mutableStateOf<List<QuestionInfo>>(emptyList())
        private set


    var currentQuestion = 0

    init {
        getQuestions()
        timer()
    }


    private var timer: Job? = null

    fun timer(): Job {
        return viewModelScope.launch(Dispatchers.Main) {
            val totalSeconds = 10
            val tickSeconds = 1
            for (second in 0 until totalSeconds) {
                val time = String.format(
                    "%02d:%02d",
                    (totalSeconds - second) / 60, // Get minutes
                    (totalSeconds - second) % 60 // Get remaining seconds
                )

                Log.d("ZZZZZ", time)
                delay(1000)
            }

            // Move to the next question when the timer completes
            moveToNextQuestion()
        }
    }

    fun moveToNextQuestion() {
        // Increment the current question index
        currentQuestion++

        if (currentQuestion < questions.size) {
            // If there are more questions, display the next question
            val nextQuestion = questions[currentQuestion]
            nextQuestion.let {
                _state.value = QuestionState(
                    question = it.question!!,
                    correctAnswer = it.correctAnswer!!,
                    incorrectAnswers = it.incorrectAnswers!!
                )
            }

            // Reset the timer for the next question
            timer?.cancel()
            timer = timer()
        } else {
            // If all questions have been answered, handle the end of the quiz or desired behavior
            // handleQuizEnd()
        }
    }


    fun getQuestions() {
        viewModelScope.launch {
           questions = repository.getQuestions(CategoriesType.GENERAL_KNOWLEDGE, Difficulty.EASY)
        }
    }
}




sealed class QuestionsEffects{
    object Timeout
    object QuizEnded
}

