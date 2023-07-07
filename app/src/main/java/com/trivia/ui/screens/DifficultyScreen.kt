package com.trivia.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.trivia.R
import com.trivia.ui.composable.FillButton
import com.trivia.ui.composable.ImageBackground
import com.trivia.ui.composable.ImagesScreenDecor
import com.trivia.ui.composable.PrimaryButton
import com.trivia.ui.theme.Typography
import com.trivia.ui.theme.White_87
import com.trivia.ui.theme.space_12
import com.trivia.viewmodel.DifficultyScreenInteractions
import com.trivia.viewmodel.DifficultyViewModel
import com.trivia.viewmodel.state.DifficultyUIState

@Composable
fun DifficultyScreen(
    navController: NavController,
    viewModel: DifficultyViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    DifficultyContent(state, viewModel)
}

@Composable
fun DifficultyContent(
    state: DifficultyUIState,
    viewModel: DifficultyScreenInteractions
) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {

        ImageBackground()

        ImagesScreenDecor(
            header = painterResource(id = R.drawable.group_astrounat), footer = painterResource(
                id = R.drawable.group_space
            )
        )
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(end = 20.dp, start = 20.dp, top = 202.dp),
                text = stringResource(R.string.choose_your_game_level),
                style = Typography.titleLarge,
                color = White_87
            )

            LazyColumn(
                modifier = Modifier.padding(top = space_12),
                contentPadding = PaddingValues(horizontal = 20.dp)
            ) {
                items(state.difficulties) {
                    PrimaryButton(
                        text = it.title,
                        modifier = Modifier.padding(top = 12.dp),
                        buttonUIState = it.buttonUIState
                    ) {
                        viewModel.onSelectDifficulty(it)
                    }
                }
            }

            FillButton(
                state.isButtonNextVisible,
                modifier = Modifier.padding(top = 48.dp),
                text = stringResource(R.string.let_s_go),
                onClick = {}
            )
        }
    }
}


@Preview
@Composable
fun DifficultyScreenPreview() {
    DifficultyScreen(rememberNavController())
}
