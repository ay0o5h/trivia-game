package com.trivia.ui.screens.result

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.trivia.R
import com.trivia.navigation.LocalNavController
import com.trivia.navigation.toCategory
import com.trivia.navigation.toQuestionsScreen
import com.trivia.ui.bases.ButtonUIState
import com.trivia.ui.composable.GlowCircle
import com.trivia.ui.composable.MainScaffold
import com.trivia.ui.composable.OutlineButton
import com.trivia.ui.screens.result.composables.Winfireworks
import com.trivia.ui.theme.space_12
import com.trivia.ui.theme.space_16
import com.trivia.ui.theme.space_20
import com.trivia.ui.theme.space_32
import com.trivia.ui.theme.Typography


@Composable
fun ResultScreen(
    viewModel: ResultViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val navController=  LocalNavController.current
    ResultContent(
        state = state,
        onGoMainScreen = { navController.toCategory() },
        onTryAgain = {
            navController.toQuestionsScreen(
                viewModel.args.category,
                viewModel.args.difficulty
            )
        },
    )
}

@Composable
fun ResultContent(
    state: ResultUIState,
    onGoMainScreen: () -> Unit,
    onTryAgain: () -> Unit,
) {

    MainScaffold(
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Winfireworks(isWinner = state.isWinner)
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Text(
                        text = stringResource(R.string.game_over),
                        style = Typography.bodyMedium,
                    )
                    Spacer(modifier = Modifier.height(space_12))
                    GlowCircle(result = state.score)
                    Text(
                        modifier = Modifier.padding(start = space_16,end =space_16,bottom = space_32,top=space_20),
                        text = when (state.isWinner) {
                            true -> stringResource(R.string.congratulations_you_won_the_game_enjoy_your_victory_and_celebrate_it)
                            false -> stringResource(R.string.good_luck_try_again_and_you_will_succeed_next_time)
                        },
                        style = Typography.titleSmall
                    )
                    OutlineButton(
                        text = stringResource(R.string.try_again),
                        buttonUIState = ButtonUIState.ClickedState,
                        onClick = { onTryAgain() }
                    )
                    Spacer(modifier = Modifier.height(space_12))
                    OutlineButton(
                        text = stringResource(R.string.main_menu),
                        onClick = { onGoMainScreen() }
                    )
                }
            }
        }
    )

}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
    ResultScreen()
}