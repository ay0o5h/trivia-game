package com.trivia.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.skydoves.cloudy.Cloudy
import com.trivia.R
import com.trivia.ui.theme.radius_25

@Composable
fun ScreenBackground(
   modifier : Modifier = Modifier
       .fillMaxSize(),
   content: @Composable () -> Unit,
){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

            Image(
                modifier = Modifier.fillMaxWidth().fillMaxHeight().blur(radius = 80.dp),
                painter = painterResource(id = R.drawable.background),
                contentDescription = "")


        content()
    }
}