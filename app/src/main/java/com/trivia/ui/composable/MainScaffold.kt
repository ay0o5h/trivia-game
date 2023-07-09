package com.trivia.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.trivia.R
import com.trivia.ui.theme.radius_80


@Composable
fun MainScaffold(
    header : (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier.fillMaxSize(),
    content: @Composable () -> Unit
){
  Box (
      modifier = modifier,
      contentAlignment = Alignment.Center
  ){
      Image(
          modifier = modifier
              .fillMaxSize()
              .blur(radius = radius_80.dp),
          painter = painterResource(id = R.drawable.background),
          contentDescription = "",
          contentScale = ContentScale.FillBounds
      )
      header?.invoke()
      content()
  }
}

