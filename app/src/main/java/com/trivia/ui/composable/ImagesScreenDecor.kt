package com.trivia.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

@Composable
fun ImagesScreenDecor(modifier: Modifier = Modifier, header: Painter, footer: Painter) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = header,
            contentDescription = "space",
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            contentScale = ContentScale.FillBounds
        )
        Image(
            painter = footer,
            contentDescription = "space",
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.FillBounds

        )
    }
}