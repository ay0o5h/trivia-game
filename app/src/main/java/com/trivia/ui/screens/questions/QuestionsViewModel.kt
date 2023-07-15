package com.trivia.ui.screens.questions

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
        getData()
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                _state.update { it.copy(isLoading = true) }
                val questionUiState: QuestionUiState =
                    triviaRepository.getCurrentQuestion(args.category, args.difficulty)
                        .toQuestionUiState()
                _state.update {
                    it.copy(
                        currentQuestion = questionUiState,
                        isLoading = false,
                        isError = false
                    )
                }
                startTimer()
            }.onFailure {
                _state.update { it.copy(isError = true, isLoading = false) }
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
    private fun changeSelectedAnswer(answer: QuestionsUiState.AnswerButton) {
        _state.update {
            it.apply {
                currentQuestion.selectedAnswerButton = answer
                currentQuestion.highlightSelectedItem()
            }
        }
    }

    private fun submit() {
        if (state.value.currentQuestion.hasSubmitButton) {
            checkIfCorrectAnswer()
        }
    }

    private fun checkIfCorrectAnswer() {
        viewModelScope.launch {
            if (state.value.currentQuestion.isCorrectAnswer) {
                _state.update {
                    it.copy(passedQuestion = it.passedQuestion + 1)
                        .apply { currentQuestion.setSelectedAnswerStateAndShowCorrect(ButtonUIState.CorrectState) }
                }
            } else {
                _state.update {
                    it.apply { currentQuestion.setSelectedAnswerStateAndShowCorrect(ButtonUIState.ErrorState) }
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
                it.copy(currentQuestionNumber = it.currentQuestionNumber + 1)
            }
            timer?.cancel()
            getData()
        }
    }

    override fun onClickAnswer(answer: QuestionsUiState.AnswerButton) {
        changeSelectedAnswer(answer)
    }

    override fun onClickSubmit() {
        submit()
    }
    // endregion
}

private fun QuestionInfo.toQuestionUiState(): QuestionUiState {
    val correctAnswer = QuestionsUiState.AnswerButton(correctAnswer ?: "")
    val inCorrectAnswers = incorrectAnswers?.filterNotNull()
        ?.map { QuestionsUiState.AnswerButton(it) } ?: emptyList()

    return QuestionUiState(
        question = removeHtmlTags(question?.text ?: ""),
        correctAnswerButton = correctAnswer,
        otherAnswerButtons = inCorrectAnswers,
        optionsAfterShuffled = (inCorrectAnswers + correctAnswer).shuffled()
    )
}

private fun removeHtmlTags(input: String): String {
    val htmlRegex = "<[^>]+>".toRegex()
    return input.replace(htmlRegex, "")
}
