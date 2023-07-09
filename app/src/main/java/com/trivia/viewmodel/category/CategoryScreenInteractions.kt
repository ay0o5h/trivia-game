package com.trivia.viewmodel.category

import com.trivia.viewmodel.state.Category

interface CategoryScreenInteractions {
    fun onSelectCategory(passedCategory: Category)
}
