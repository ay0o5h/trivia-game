package com.trivia.ui.screens.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.trivia.R
import com.trivia.navigation.LocalNavController

import com.trivia.navigation.navigateToDifficultyScreen
import com.trivia.ui.composable.FillButton
import com.trivia.ui.composable.MainScaffold
import com.trivia.ui.composable.OutlineButton
import com.trivia.ui.composable.SpacerVertical12
import com.trivia.ui.theme.Typography
import com.trivia.ui.theme.White_87
import com.trivia.ui.theme.space_12
import com.trivia.ui.theme.space_16
import com.trivia.ui.theme.space_202
import com.trivia.ui.theme.space_48

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val navController=  LocalNavController.current
    fun navigateToDifficultyScreen() {
        navController.navigateToDifficultyScreen(state.selectedCategory)
    }
    CategoryContent(state, viewModel, ::navigateToDifficultyScreen)
}

@Composable
fun CategoryContent(
    state: CategoryUIState, listener: CategoryScreenInteractions, onNavigate: () -> Unit
) {
    MainScaffold(
        header = {
            Image(
                painter = painterResource(id = R.drawable.group_astrounat),
                contentDescription = stringResource(R.string.space),
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )
        },
        footer = {
            Image(
                painter = painterResource(id = R.drawable.group_space),
                contentDescription = stringResource(R.string.space),
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )
        }
    ) {

        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            
            Text(
                modifier = Modifier.padding(end = space_16, start = space_16, top = space_202),
                text = (stringResource(R.string.choose_the_game_category)),
                style = Typography.titleLarge,
                color = White_87
            )

            SpacerVertical12()

            state.categories.forEach{
                OutlineButton(
                    text = it.title,
                    modifier = Modifier.padding(top = space_12),
                    buttonUIState = it.buttonUIState
                ) {
                    listener.onSelectCategory(it)
                }
            }

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
    CategoryScreen()
}