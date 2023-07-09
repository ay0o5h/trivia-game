package com.trivia.ui.screens.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.trivia.R
import com.trivia.navigation.navigateToDifficultyScreen
import com.trivia.ui.composable.FillButton
import com.trivia.ui.composable.ImageBackground
import com.trivia.ui.composable.ScreenWithHeaderAndFooterImages
import com.trivia.ui.composable.OutlineButton
import com.trivia.ui.composable.SpacerVertical12
import com.trivia.ui.composable.TextHeader
import com.trivia.ui.screens.category.composable.composable.CategoryChoices
import com.trivia.ui.theme.space_12
import com.trivia.ui.theme.space_48
import com.trivia.viewmodel.category.CategoryScreenInteractions
import com.trivia.viewmodel.category.CategoryViewModel
import com.trivia.viewmodel.state.CategoryUIState

@Composable
fun CategoryScreen(
    navController: NavHostController, viewModel: CategoryViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    fun navigateToDifficultyScreen() {
        navController.navigateToDifficultyScreen(state.selectedCategory)
    }
    CategoryContent(state, viewModel, ::navigateToDifficultyScreen)
}


@Composable
fun CategoryContent(
    state: CategoryUIState, viewModel: CategoryScreenInteractions, onNavigate: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {

        ImageBackground()

        ScreenWithHeaderAndFooterImages(
            header = painterResource(id = R.drawable.group_astrounat), footer = painterResource(
                id = R.drawable.group_space
            )
        )

        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextHeader(stringResource(R.string.choose_the_game_category))

            SpacerVertical12()

            CategoryChoices(state, viewModel)
            
            FillButton(
                state.isButtonNextVisible,
                modifier = Modifier.padding(top = space_48),
                text = stringResource(R.string.next),
                onClick = onNavigate
            )
        }
    }
}




@Preview
@Composable
fun CategoryScreenPreview() {
    CategoryScreen(rememberNavController())
}