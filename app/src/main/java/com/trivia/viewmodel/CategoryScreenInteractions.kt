package com.trivia.viewmodel

import com.trivia.viewmodel.state.CategoryState

interface CategoryScreenInteractions {
    fun onSelectCategory(passedCategory: CategoryState)
}
