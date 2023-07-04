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
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.trivia.ui.bases.ButtonUIState
import com.trivia.ui.theme.Blue
import com.trivia.ui.theme.Purple
import com.trivia.ui.theme.RedDark
import com.trivia.ui.theme.RedLight
import com.trivia.ui.theme.TextWhite
import com.trivia.ui.theme.White_36
import com.trivia.ui.theme.White_60
import com.trivia.ui.theme.White_70
import com.trivia.ui.theme.fontSize_18
import com.trivia.ui.theme.radius_28
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
                        color = when (buttonUIState){
                            ButtonUIState.ErrorState -> RedDark
                           else -> White_60
                        },
                        shape = RoundedCornerShape(percent = radius_28)
                    )
                    .background(color = when (buttonUIState){
                        ButtonUIState.StartState -> Transparent
                        ButtonUIState.ErrorState -> RedDark
                        ButtonUIState.CorrectState -> White_60
                        ButtonUIState.ClickedState -> White_60
                    }, shape = RoundedCornerShape(percent = radius_28))

    ) {

        Text(
            text = text,
            fontSize = fontSize_18,
            fontWeight = FontWeight.W500,
            color = White_70)
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    PrimaryButton(text = "Button", onClick = {})
}