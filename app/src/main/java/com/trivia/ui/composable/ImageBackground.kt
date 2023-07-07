package com.trivia.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.trivia.R

@Composable
fun ImageBackground(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .fillMaxSize()
            .blur(radius = 80.dp),
        painter = painterResource(id = R.drawable.background),
        contentDescription = "",
        contentScale = ContentScale.FillBounds
    )
}