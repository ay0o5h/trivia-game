package com.trivia.ui.screens

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.cloudy.Cloudy
import com.trivia.R
import com.trivia.ui.bases.ButtonUIState
import com.trivia.ui.composable.PrimaryButton

@Composable
fun SplashScreen(){
    SplashContent()
}

@Composable
fun SplashContent(){
    Box(modifier = Modifier
        .fillMaxSize().blur(radius=40.dp),
        contentAlignment = Alignment.Center
    ) {
        Cloudy(radius = 25){
            Image(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                painter = painterResource(id = R.drawable.background),
                contentDescription = "")
        }

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "")
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}