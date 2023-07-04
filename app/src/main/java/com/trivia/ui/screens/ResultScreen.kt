package com.trivia.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.trivia.R
import com.trivia.ui.bases.ButtonUIState
import com.trivia.ui.composable.PrimaryButton
import com.trivia.ui.composable.ResultCircle
import com.trivia.ui.composable.ScreenBackground
import com.trivia.ui.composable.SpacerVertical12
import com.trivia.ui.composable.SpacerVertical20
import com.trivia.ui.composable.SpacerVertical32
import com.trivia.ui.composable.TextStyles
import com.trivia.ui.theme.space_20

@Composable
fun ResultScreen(){
    ResultContent()
}

@Composable
fun ResultContent(){
    ScreenBackground {
        Column(
            verticalArrangement= Arrangement.Center,
            horizontalAlignment =  Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.game_over),
                style = MaterialTheme.typography.titleLarge.merge(TextStyles.LargeTextStyle()),
            )
            SpacerVertical12()
            ResultCircle( result = 8)
            SpacerVertical20()
            Text(
                modifier=Modifier.padding(horizontal = space_20),
                text = stringResource(R.string.congratulations_you_won_the_game_enjoy_your_victory_and_celebrate_it),
                style = MaterialTheme.typography.titleMedium.merge(TextStyles.MeduimTextStyle()),
            )
            SpacerVertical32()
            PrimaryButton(
                text = stringResource(R.string.try_again) ,
                buttonUIState = ButtonUIState.ClickedState
            ) {
            }
            SpacerVertical12()
            PrimaryButton(text = stringResource(R.string.main_menu)) {
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview(){
    ResultScreen()
}