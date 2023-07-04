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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trivia.elements.IconArrow
import com.trivia.ui.theme.Blue
import com.trivia.ui.theme.Purple

@Composable
fun FilledCircularButton(isVisible: Boolean, modifier: Modifier = Modifier) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(Purple, Blue)
    )
    AnimatedVisibility(visible = isVisible, enter = fadeIn(), exit = fadeOut()) {
        Box(modifier = modifier
            .size(56.dp)
            .clip(shape = CircleShape)
            .background(brush = gradient)
            .clickable(interactionSource = CreateMutableInteractionSource(),
                indication = CreateIndication(),
                onClick = {})) {
            IconArrow(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


@Preview
@Composable
fun Preview() {
    FilledCircularButton(true)

}
