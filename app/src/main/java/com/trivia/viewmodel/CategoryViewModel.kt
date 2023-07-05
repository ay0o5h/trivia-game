package com.trivia.viewmodel

import com.trivia.repository.model.CategoriesType
import com.trivia.ui.bases.BaseViewModel
import com.trivia.ui.bases.ButtonUIState
import com.trivia.viewmodel.state.CategoryState
import com.trivia.viewmodel.state.CategoryUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor() : BaseViewModel<CategoryUIState>(CategoryUIState()),
    CategoryScreenInteractions {


    override fun onSelectCategory(passedCategory: CategoryState) {
        val isNotSameCategory = passedCategory.type != _state.value.selectedCategory
        val selectedCategory = if (isNotSameCategory) passedCategory.type else CategoriesType.UNKNOWN

        val updatedCategories = _state.value.categories.map {
            it.copy(buttonUIState = if (it.type == passedCategory.type && isNotSameCategory) ButtonUIState.ClickedState
            else ButtonUIState.StartState)
        }
        _state.update {
            it.copy(
                selectedCategory = selectedCategory,
                isButtonNextVisible = isNotSameCategory,
                categories = updatedCategories
            )
        }
    }


}