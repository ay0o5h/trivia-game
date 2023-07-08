package com.trivia.viewmodel.questions

import androidx.lifecycle.viewModelScope
import com.trivia.repository.TriviaRepository
import com.trivia.ui.bases.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val triviaRepository: TriviaRepository,
) : BaseViewModel<QuestionsUiState>(QuestionsUiState()) {
    // region get all questions
    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch(Dispatchers.IO) {
//            triviaRepository.getQuestions()
        }
    }
    // endregion
}