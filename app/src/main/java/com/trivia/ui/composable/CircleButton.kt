package com.trivia.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trivia.ui.theme.PurpleDark
import com.trivia.ui.theme.White36
import com.trivia.ui.theme.space_56

@Composable
fun CircleButton(
    isVisible: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val gradient = Brush.linearGradient(
        colors = listOf(White36, PurpleDark),
        start = Offset(x = 0f, y = 150f),
        end = Offset(x = 250f, y = 0f),
    )

    AnimatedVisibility(visible = isVisible, enter = fadeIn(), exit = fadeOut()) {
        Box(
            modifier = modifier
                .size(space_56)
                .clip(shape = CircleShape)
                .background(brush = gradient)
                .clickable(
                    interactionSource = CreateMutableInteractionSource(),
                    indication = CreateIndication(),
                    onClick = onClick
                )
        ) {
            IconArrowRight(modifier = Modifier.align(Alignment.Center).size(24.dp))
        }
    }
}


@Preview
@Composable
fun ButtonNextPreview() {
    CircleButton(true, onClick = {})
}