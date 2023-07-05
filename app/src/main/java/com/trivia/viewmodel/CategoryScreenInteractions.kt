package com.trivia.viewmodel

import com.trivia.repository.model.CategoriesType

interface CategoryScreenInteractions {
    fun onSelectCategory(type: CategoriesType)
}
