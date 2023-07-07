package com.trivia.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.trivia.navigation.DifficultyScreenArgs
import com.trivia.repository.TriviaRepository
import com.trivia.repository.model.CategoriesType
import com.trivia.repository.model.DifficultiesType
import com.trivia.ui.bases.BaseViewModel
import com.trivia.ui.bases.ButtonUIState
import com.trivia.viewmodel.state.Category
import com.trivia.viewmodel.state.CategoryUIState
import com.trivia.viewmodel.state.Difficulty
import com.trivia.viewmodel.state.DifficultyUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DifficultyViewModel @Inject constructor(
    private val repository: TriviaRepository,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<DifficultyUIState>(DifficultyUIState()), DifficultyScreenInteractions {

    val args = DifficultyScreenArgs(savedStateHandle).category

    init {
        getData()
    }

    private fun getData() {
        _state.update { it.copy(difficulties = repository.getDifficulty()) }
    }

    override fun onSelectDifficulty(passedDifficulty: Difficulty) {
        val isNotSameDifficulty = passedDifficulty.type != _state.value.selectedDifficulty
        val selectedDifficulty =
            if (isNotSameDifficulty) passedDifficulty.type else DifficultiesType.UNKNOWN

        val updatedCategories = _state.value.difficulties.map {
            it.copy(
                buttonUIState = if (it.type == passedDifficulty.type && isNotSameDifficulty) ButtonUIState.ClickedState
                else ButtonUIState.StartState
            )
        }
        _state.update {
            it.copy(
                selectedDifficulty = selectedDifficulty,
                isButtonNextVisible = isNotSameDifficulty,
                difficulties = updatedCategories
            )
        }
        Log.i( "onSelectCategory: ", _state.value.selectedDifficulty.toString())
    }

}