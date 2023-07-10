package com.trivia.ui.screens.result.composables

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import com.trivia.R
import com.trivia.ui.theme.space_16
import com.trivia.ui.theme.space_20
import com.trivia.ui.theme.space_24
import com.trivia.ui.theme.space_56

@SuppressLint("SuspiciousIndentation")
@Composable
fun Winfireworks(
    isWinner: Boolean = false,
) {
    var isVisiable by remember {
        mutableStateOf(isWinner)
    }
    val transition = rememberInfiniteTransition()

    val scaleImage by  transition.animateFloat(
        targetValue = if (isVisiable) 1f else 0f,
        initialValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing,
            ),
            repeatMode = RepeatMode.Restart,
        )
    )
    Log.d("AYA", "isVisiable: $isVisiable")
    val alpha by animateFloatAsState(
        targetValue = if (isVisiable) 1f else 0f,
    )
        Column(
            modifier= Modifier.fillMaxSize()
                .animateContentSize().alpha(alpha)
                .padding(top = space_56)
        ) {
            AnimatedImage(
                modifier = Modifier.fillMaxWidth().padding(start = space_24)
                    .clip(MaterialTheme.shapes.extraLarge)
                    .scale(scaleImage),
                scaleImage = scaleImage,
                painterResource =R.drawable.win_4
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = space_16),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                AnimatedImage(scaleImage = scaleImage, painterResource = R.drawable.win_3)
                AnimatedImage(scaleImage = scaleImage, painterResource = R.drawable.win_1)
                AnimatedImage(scaleImage = scaleImage, painterResource = R.drawable.win_3)

            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = space_16),
                horizontalArrangement = Arrangement.spacedBy(space_20),
            ) {
                AnimatedImage(scaleImage = scaleImage, painterResource = R.drawable.win_6)
                Spacer(modifier = Modifier.weight(1f))
                AnimatedImage(scaleImage = scaleImage, painterResource = R.drawable.win_5)
            }
        }
}

@Composable
fun AnimatedImage(
    scaleImage: Float,
    painterResource: Int,
    modifier: Modifier = Modifier.clip(MaterialTheme.shapes.extraLarge)
        .scale(scaleImage)
){
    Image(
        painter = painterResource(painterResource),
        modifier = modifier,
        contentDescription ="" )
}