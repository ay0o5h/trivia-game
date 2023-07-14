package com.trivia.ui.screens.category

import com.trivia.repository.TriviaRepository
import com.trivia.repository.model.CategoriesType
import com.trivia.ui.bases.BaseViewModel
import com.trivia.ui.bases.ButtonUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: TriviaRepository
) : BaseViewModel<CategoryUIState>(CategoryUIState()), CategoryScreenInteractions {

    init {
        getData()
    }

    private fun getData() {
        _state.update { it.copy(categories = repository.getCategories()) }
    }

    override fun onSelectCategory(passedCategory: Category) {
        val isDifferentCategorySelected = passedCategory.type != _state.value.selectedCategory
        val selectedCategory =
            if (isDifferentCategorySelected) passedCategory.type else CategoriesType.UNKNOWN

        val updatedCategories = _state.value.categories.map {
            it.copy(
                buttonUIState = if (it.type == passedCategory.type && isDifferentCategorySelected) ButtonUIState.ClickedState
                else ButtonUIState.StartState
            )
        }
        updateState(selectedCategory,isDifferentCategorySelected,updatedCategories)
    }

    private fun updateState(
        selectedCategory: CategoriesType,
        isVisible: Boolean,
        categories: List<Category>
    ) {
        _state.update {
            it.copy(
                selectedCategory = selectedCategory,
                isButtonNextVisible = isVisible,
                categories = categories
            )
        }
    }

}