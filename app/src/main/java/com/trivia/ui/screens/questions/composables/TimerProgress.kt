package com.trivia.ui.screens.questions.composables

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.trivia.ui.theme.PurpleDark
import com.trivia.ui.theme.White36
import com.trivia.ui.theme.White_60

@Composable
fun CustomProgress(
    progress: Float,
    modifier: Modifier = Modifier,
    progressColor: Color = PurpleDark.copy(0.6f),
    trackColor: Color = White36,
    strokeWidth: Dp = 15.dp,
    strokeColor: Color = White_60
) {
    Box(
        modifier = modifier
            .height(strokeWidth)
            .drawBehind {
                drawRoundRect(
                    color = trackColor,
                    cornerRadius = CornerRadius(100f)
                )
                drawRoundRect(
                    color = progressColor,
                    cornerRadius = CornerRadius(100f),
                    size = Size(size.width * progress, size.height)
                )
                drawRoundRect(
                    strokeColor,
                    style = Stroke(width = 1.dp.toPx(), cap = StrokeCap.Round),
                    cornerRadius = CornerRadius(100f)
                )
            }
    )
}

@Composable
fun AnimatedTimerProgress(
    modifier: Modifier = Modifier,
    maxTime: Int = 30,
    currentTime: Int = 30,
) {
    val animatedProgress by animateFloatAsState(
        targetValue = currentTime.toFloat() / maxTime.toFloat(),
        animationSpec = tween(1000, easing = LinearEasing)
    )
    CustomProgress(
        progress = animatedProgress,
        strokeWidth = 15.dp,
        modifier = modifier
    )
}


@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xFF421069)
@Composable
fun PreviewProgress() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedTimerProgress(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            currentTime = 15
        )
    }
}