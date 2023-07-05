package com.trivia.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.skydoves.cloudy.Cloudy
import com.trivia.R
import com.trivia.ui.bases.ButtonUIState
import com.trivia.ui.composable.PrimaryButton
import com.trivia.ui.theme.Purple

@Composable
fun SplashScreen(
    navController: NavHostController,
){
    SplashContent()
}

@Composable
fun SplashContent(){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight().blur(radius = 80.dp),
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = ""
                )

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = ""
            )

    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}