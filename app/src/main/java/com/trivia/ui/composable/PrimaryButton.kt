package com.trivia.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.trivia.ui.bases.ButtonUIState
import com.trivia.ui.theme.Blue
import com.trivia.ui.theme.Purple
import com.trivia.ui.theme.RedDark
import com.trivia.ui.theme.RedLight
import com.trivia.ui.theme.TextWhite
import com.trivia.ui.theme.fontSize_18
import com.trivia.ui.theme.radius_50
import com.trivia.ui.theme.space_15
import com.trivia.ui.theme.space_2
import com.trivia.ui.theme.space_8

@Composable
fun PrimaryButton(
    text: String,
    fraction : Float = 9f,
    buttonUIState: ButtonUIState = ButtonUIState.StartState,
    onClick: () -> Unit,
){
    Button(

        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White,
        ),
        contentPadding= PaddingValues( vertical = space_15),
        onClick = onClick,
                modifier = Modifier
                    .fillMaxWidth(fraction = fraction)
                .padding(space_8)
                    .border(
                        width = space_2,
                        brush = when (buttonUIState){
                            ButtonUIState.ErrorState -> Brush.horizontalGradient(
                                colors = listOf(
                                    RedDark,
                                    RedLight),
                            )
                           else-> Brush.horizontalGradient(
                            colors = listOf(
                                Purple,
                                Blue),
                        )},
                        shape = RoundedCornerShape(percent = radius_50)
                    )
                    .background(
                        brush =when (buttonUIState){
                            ButtonUIState.StartState -> Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Transparent),
                            )
                            ButtonUIState.ErrorState -> Brush.horizontalGradient(
                                colors = listOf(
                                    RedDark,
                                    RedLight),
                            )
                            ButtonUIState.CorrectState -> Brush.horizontalGradient(
                                colors = listOf(
                                    Purple,
                                    Blue),
                            )
                            ButtonUIState.ClickedState -> Brush.horizontalGradient(
                                colors = listOf(
                                    Purple,
                                    Blue),
                            )
                        },
                        shape = RoundedCornerShape(radius_50)
                    )
    ) {

        Text(
            text = text,
            fontSize = fontSize_18,
            fontWeight = FontWeight.W500,
            color = TextWhite)
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    PrimaryButton(text = "Button", onClick = {})
}
