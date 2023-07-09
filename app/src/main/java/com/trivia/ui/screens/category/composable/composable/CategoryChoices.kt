package com.trivia.ui.screens.category.composable.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.trivia.ui.composable.OutlineButton
import com.trivia.ui.theme.space_12
import com.trivia.viewmodel.category.CategoryScreenInteractions
import com.trivia.viewmodel.state.CategoryUIState

@Composable
fun CategoryChoices(state: CategoryUIState, viewModel: CategoryScreenInteractions) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(state.categories) {
            OutlineButton(
                text = it.title,
                modifier = Modifier.padding(top = space_12),
                buttonUIState = it.buttonUIState
            ) {
                viewModel.onSelectCategory(it)
            }
        }
    }
}

