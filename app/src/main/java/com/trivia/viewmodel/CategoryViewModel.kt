package com.trivia.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.trivia.repository.TriviaRepository
import com.trivia.repository.model.CategoriesType
import com.trivia.repository.model.DifficultiesType
import com.trivia.ui.bases.ButtonUIState
import com.trivia.viewmodel.state.Category
import com.trivia.viewmodel.state.CategoryUIState
import com.trivia.viewmodel.state.Difficulty
import com.trivia.viewmodel.state.DifficultyUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: TriviaRepository
) : ViewModel(), CategoryScreenInteractions, DifficultyScreenInteractions {

    private val _stateCategory by lazy { MutableStateFlow(CategoryUIState()) }
    val stateCategory by lazy { _stateCategory.asStateFlow() }

    private val _stateDifficulty by lazy { MutableStateFlow(DifficultyUIState()) }
    val stateDifficulty by lazy { _stateDifficulty.asStateFlow() }


    init {
        getData()
    }

    private fun getData() {
        _stateCategory.update { it.copy(categories = repository.getCategories()) }
        _stateDifficulty.update { it.copy(difficulties = repository.getDifficulty()) }
    }


    override fun onSelectCategory(passedCategory: Category) {
        val isNotSameCategory = passedCategory.type != _stateCategory.value.selectedCategory
        val selectedCategory =
            if (isNotSameCategory) passedCategory.type else CategoriesType.UNKNOWN

        val updatedCategories = _stateCategory.value.categories.map {
            it.copy(
                buttonUIState = if (it.type == passedCategory.type && isNotSameCategory) ButtonUIState.ClickedState
                else ButtonUIState.StartState
            )
        }
        _stateCategory.update {
            it.copy(
                selectedCategory = selectedCategory,
                isButtonNextVisible = isNotSameCategory,
                categories = updatedCategories
            )
        }
        Log.i( "onSelectCategory: ", _stateCategory.value.selectedCategory.toString())
    }


    override fun onSelectDifficulty(passedDifficulty: Difficulty) {
//        val isNotSameDifficulty = passedDifficulty.type != _stateDifficulty.value.selectedDifficulty
//        val selectedDifficulty =
//            if (isNotSameDifficulty) passedDifficulty.type else DifficultiesType.UNKNOWN
//
//        val updatedCategories = _stateDifficulty.value.difficulties.map {
//            it.copy(
//                buttonUIState = if (it.type == passedDifficulty.type && isNotSameDifficulty) ButtonUIState.ClickedState
//                else ButtonUIState.StartState
//            )
//        }
//        _stateDifficulty.update {
//            it.copy(
//                selectedDifficulty = selectedDifficulty,
//                isButtonNextVisible = isNotSameDifficulty,
//                difficulties = updatedCategories
//            )
//        }
        Log.i( "onSelectCategory: ", _stateCategory.value.selectedCategory.toString())
    }


}