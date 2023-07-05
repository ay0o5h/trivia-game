package com.trivia.viewmodel

import com.trivia.repository.model.CategoriesType
import com.trivia.ui.bases.BaseViewModel
import com.trivia.viewmodel.state.CategoryUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update

@HiltViewModel
class CategoryViewModel() : BaseViewModel<CategoryUIState>(CategoryUIState()),
    CategoryScreenInteractions {


    override fun onSelectCategory(type: CategoriesType) {
        val isVisible = type != _state.value.selectedCategory
        val category = if (type != _state.value.selectedCategory) type else CategoriesType.UNKNOWN
        _state.update { it.copy(selectedCategory = category, isButtonNextVisible = isVisible) }
    }


}