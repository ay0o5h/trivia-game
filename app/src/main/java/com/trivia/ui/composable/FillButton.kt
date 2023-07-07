package com.trivia.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trivia.ui.theme.PurpleDark
import com.trivia.ui.theme.Typography
import com.trivia.ui.theme.White36
import com.trivia.ui.theme.White_70


@Composable
fun FillButton(
    isVisible: Boolean,
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    val gradient = Brush.linearGradient(
        colors = listOf(White36, PurpleDark),
        start = Offset(x = -20f, y = 150f),
        end = Offset(x = 400f, y = -100f),
    )

    AnimatedVisibility(visible = isVisible, enter = fadeIn(), exit = fadeOut()) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(28.dp))
                .background(brush = gradient)
                .clickable(
                    interactionSource = CreateMutableInteractionSource(),
                    indication = CreateIndication(),
                    onClick = onClick
                )
        ) {
            Text(
                text = text,
                color = White_70,
                style = Typography.titleMedium,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(vertical = 15.dp, horizontal = 38.dp),

                )
        }

    }
}


@Preview
@Composable
fun ButtonContinuePreview() {
    FillButton(true, text = "", onClick = {})
}
