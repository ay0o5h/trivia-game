package com.trivia.viewmodel.questions

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.trivia.navigation.QuestionsScreenArgs
import com.trivia.remote.response.QuestionInfo
import com.trivia.repository.TriviaRepository
import com.trivia.ui.bases.BaseViewModel
import com.trivia.ui.bases.ButtonUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val triviaRepository: TriviaRepository,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<QuestionsUiState>(QuestionsUiState()), QuestionsInteractionsListener {
    val args = QuestionsScreenArgs(savedStateHandle)

    // region get all questions
    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                val questionsUiState: List<QuestionsUiState.QuestionUiState> =
                    triviaRepository.getQuestions(args.category, args.difficulty)
                        .toQuestionsUiState()
                _state.update { it.copy(questions = questionsUiState) }
                startTimer()
            }.onFailure {
                // todo: handle error state
            }
        }
    }
    // endregion

    // region timer
    private var timer: Job? = null
    private fun startTimer() {
        timer = viewModelScope.launch {
            timer = null
            _state.update { it.copy(currentTime = 0) }
            while (state.value.currentTime < state.value.maxTime) {
                _state.update { it.copy(currentTime = it.currentTime + 1) }
                delay(1000)
            }
            timeOut()
        }
    }

    private fun timeOut() {
        timer?.cancel()
        nextQuestionOrNavigate()
    }
    // endregion

    // region interactions
    private fun changeSelectedAnswer(answer: String) {
        _state.update { it.copy(selectedAnswer = answer) }
    }

    private fun submit() {
        if (state.value.hasSubmitButton) {
            checkIfCorrectAnswer()
        }
    }

    private fun checkIfCorrectAnswer() {
        viewModelScope.launch {
            if (state.value.isCorrectAnswer) {
                _state.update {
                    it.copy(
                        selectedAnswerState = ButtonUIState.CorrectState,
                        passedQuestion = it.passedQuestion + 1,
                        showCorrect = true
                    )
                }
            } else {
                _state.update {
                    it.copy(
                        selectedAnswerState = ButtonUIState.ErrorState,
                        showCorrect = true
                    )
                }
            }
            delay(500)
            nextQuestionOrNavigate()
        }
    }

    private fun nextQuestionOrNavigate() {
        if (state.value.isLastQuestion) {
            _state.update { it.copy(shouldNavigate = true) }
        } else {
            _state.update {
                it.copy(
                    currentQuestionNumber = it.currentQuestionNumber + 1,
                    selectedAnswer = null,
                    selectedAnswerState = null,
                    showCorrect = false
                )
            }
            timer?.cancel()
            startTimer()
        }
    }

    override fun onClickAnswer(answer: String) {
        changeSelectedAnswer(answer)
    }

    override fun onClickSubmit() {
        submit()
    }
    // endregion
}

private fun List<QuestionInfo>.toQuestionsUiState(): List<QuestionsUiState.QuestionUiState> {
    return map {
        val correctAnswer = it.correctAnswer ?: ""
        val inCorrectAnswers = it.incorrectAnswers?.filterNotNull() ?: emptyList()
        QuestionsUiState.QuestionUiState(
            question = it.question?.text ?: "",
            correctAnswer = correctAnswer,
            otherAnswers = inCorrectAnswers,
            optionsAfterShuffled = (inCorrectAnswers + correctAnswer).shuffled()
        )
    }
}
