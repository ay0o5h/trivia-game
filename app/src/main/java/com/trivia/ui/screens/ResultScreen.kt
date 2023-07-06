package com.trivia.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.trivia.R
import com.trivia.ScreensRoute
import com.trivia.ui.bases.ButtonUIState
import com.trivia.ui.components.ResultCircle
import com.trivia.ui.composable.PrimaryButton
import com.trivia.ui.composable.ScreenBackground
import com.trivia.ui.composable.SpacerVertical12
import com.trivia.ui.composable.SpacerVertical20
import com.trivia.ui.composable.SpacerVertical32
import com.trivia.ui.composable.TextStyles
import com.trivia.ui.composable.WinAnimation
import com.trivia.ui.theme.space_20
import com.trivia.viewmodel.ResultViewModel
import com.trivia.viewmodel.state.ResultUIState

@Composable
fun ResultScreen(
    navController: NavHostController,
    viewModel: ResultViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()
    ResultContent(
        state=state,
        onGoMainScreen = { navController.navigate(ScreensRoute.Category.route) },
        onTryAgain = { navController.navigateUp() },
    )
}

@Composable
fun ResultContent(
    state: ResultUIState,
    onGoMainScreen:()->Unit ,
    onTryAgain:()->Unit ,
){


    ScreenBackground {
        WinAnimation(isWinner = state.isWinner)


        Column(
            verticalArrangement= Arrangement.Center,
            horizontalAlignment =  Alignment.CenterHorizontally
        ) {


            Text(
                text = stringResource(R.string.game_over),
                style = MaterialTheme.typography.titleLarge.merge(TextStyles.LargeTextStyle()),
            )
            SpacerVertical12()
            ResultCircle( result = state.score)
            SpacerVertical20()
            Text(
                modifier=Modifier.padding(horizontal = space_20),
                text =when(state.isWinner){
                    true-> stringResource(R.string.congratulations_you_won_the_game_enjoy_your_victory_and_celebrate_it)
                    false-> stringResource(R.string.good_luck_try_again_and_you_will_succeed_next_time)
                },
                style = MaterialTheme.typography.titleMedium.merge(TextStyles.MeduimTextStyle()),
            )
            SpacerVertical32()
            PrimaryButton(
                text = stringResource(R.string.try_again) ,
                buttonUIState = ButtonUIState.ClickedState
            ) {
                onTryAgain()
            }
            SpacerVertical12()
            PrimaryButton(text = stringResource(R.string.main_menu)) {
                onGoMainScreen()
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview(){
    ResultScreen(rememberNavController())
}