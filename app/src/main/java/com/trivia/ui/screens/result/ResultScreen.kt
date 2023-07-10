package com.trivia.ui.screens.result

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
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
import com.trivia.navigation.toCategory
import com.trivia.navigation.toQuestionsScreen
import com.trivia.ui.bases.ButtonUIState
import com.trivia.ui.composable.GlowCircle
import com.trivia.ui.composable.MainScaffold
import com.trivia.ui.composable.OutlineButton
import com.trivia.ui.composable.SpacerVertical12
import com.trivia.ui.composable.SpacerVertical20
import com.trivia.ui.composable.SpacerVertical32
import com.trivia.ui.composable.TextStyles
import com.trivia.ui.composable.Winfireworks
import com.trivia.ui.theme.space_20

@Composable
fun ResultScreen(
    navController: NavHostController,
    viewModel: ResultViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
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
        header = {
            Image(
                painter = painterResource(id = R.drawable.group_astrounat),
                contentDescription = stringResource(R.string.space),
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )
        },
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
                        style = MaterialTheme.typography.titleLarge.merge(TextStyles.LargeTextStyle()),
                    )
                    SpacerVertical12()
                    GlowCircle(result = state.score)
                    SpacerVertical20()
                    Text(
                        modifier = Modifier.padding(horizontal = space_20),
                        text = when (state.isWinner) {
                            true -> stringResource(R.string.congratulations_you_won_the_game_enjoy_your_victory_and_celebrate_it)
                            false -> stringResource(R.string.good_luck_try_again_and_you_will_succeed_next_time)
                        },
                        style = MaterialTheme.typography.titleMedium.merge(TextStyles.MeduimTextStyle()),
                    )
                    SpacerVertical32()
                    OutlineButton(
                        text = stringResource(R.string.try_again),
                        buttonUIState = ButtonUIState.ClickedState,
                        onClick = { onTryAgain() }
                    )
                    SpacerVertical12()
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
    ResultScreen(rememberNavController())
}