package com.trivia.ui.screens.difficulty

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.trivia.R
import com.trivia.navigation.toQuestionsScreen
import com.trivia.ui.composable.FillButton
import com.trivia.ui.composable.ImageBackground
import com.trivia.ui.composable.ScreenWithHeaderAndFooterImages
import com.trivia.ui.composable.SpacerVertical12
import com.trivia.ui.composable.TextHeader
import com.trivia.ui.screens.difficulty.composable.DifficultyChoices
import com.trivia.ui.theme.space_48

@Composable
fun DifficultyScreen(
    navController: NavController,
    viewModel: DifficultyViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    DifficultyContent(
        navigateToQuestionsScreen = {
            navController.toQuestionsScreen(
                viewModel.category,
                state.selectedDifficulty
            )
        },
        state,
        viewModel
    )
}

@Composable
fun DifficultyContent(
    navigateToQuestionsScreen: () -> Unit,
    state: DifficultyUIState,
    viewModel: DifficultyScreenInteractions
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

            TextHeader(stringResource(R.string.choose_your_game_level))

            SpacerVertical12()

            DifficultyChoices(state, viewModel)

            FillButton(
                state.isButtonNextVisible,
                modifier = Modifier.padding(top = space_48),
                text = stringResource(R.string.let_s_go),
                onClick = navigateToQuestionsScreen
            )
        }
    }
}


@Preview
@Composable
fun DifficultyScreenPreview() {
    DifficultyScreen(rememberNavController())
}
