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
import androidx.compose.ui.res.stringResource
import com.trivia.R

@Composable
fun ScreenWithHeaderAndFooterImages(modifier: Modifier = Modifier, header: Painter, footer: Painter) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = header,
            contentDescription = stringResource(R.string.space),
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            contentScale = ContentScale.FillBounds
        )
        Image(
            painter = footer,
            contentDescription = stringResource(R.string.space),
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.FillBounds
        )
    }
}