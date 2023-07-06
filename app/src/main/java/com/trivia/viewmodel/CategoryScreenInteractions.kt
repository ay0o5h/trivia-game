package com.trivia.viewmodel

import com.trivia.viewmodel.state.Category

interface CategoryScreenInteractions {
    fun onSelectCategory(passedCategory: Category)
}
