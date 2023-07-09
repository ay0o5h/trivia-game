package com.trivia.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.trivia.R

@Composable
fun astronautHeader(){
    Image(
        painter = painterResource(id = R.drawable.group_astrounat),
        contentDescription = stringResource(R.string.astronaut),
        modifier = Modifier
            .fillMaxWidth(),
        contentScale = ContentScale.FillBounds
    )
}