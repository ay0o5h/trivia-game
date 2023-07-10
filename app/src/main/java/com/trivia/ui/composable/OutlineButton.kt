package com.trivia.ui.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.shape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.tooling.preview.Preview
import com.trivia.ui.bases.ButtonUIState
import com.trivia.ui.theme.RedDark
import com.trivia.ui.theme.Typography
import com.trivia.ui.theme.White_36
import com.trivia.ui.theme.radius_50
import com.trivia.ui.theme.space_15
import com.trivia.ui.theme.space_16
import com.trivia.ui.theme.space_2

@Composable
fun OutlineButton(
    text: String,
    fraction: Float = 9f,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonUIState: ButtonUIState = ButtonUIState.StartState,
    ) {

    val buttonColor by animateColorAsState(
        targetValue = when (buttonUIState) {
            ButtonUIState.ClickedState -> White_36
            ButtonUIState.StartState -> Transparent
            ButtonUIState.ErrorState -> RedDark
            ButtonUIState.CorrectState -> White_36
        },
    )

    val borderColor by animateColorAsState(
        targetValue = when (buttonUIState) {
            ButtonUIState.ErrorState -> RedDark
            else -> White_36
        },
    )


    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Transparent,
            contentColor = Color.White,
        ),
        contentPadding = PaddingValues(vertical = space_15, horizontal = space_16),
        onClick = onClick,
        shape= RoundedCornerShape(percent = radius_50),
        modifier = modifier
            .fillMaxWidth(fraction = fraction)
            .padding(horizontal = space_16)
            .border(
                width = space_2,
                color = borderColor,
                shape = RoundedCornerShape(percent = radius_50)
            )
            .background(
                color = buttonColor, shape = RoundedCornerShape(percent = radius_50)
            )

    ) {

        Text(
            text = text,
            style = Typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    OutlineButton(text = "Button", onClick = {})
}
