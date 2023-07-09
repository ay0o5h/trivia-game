package com.trivia.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.trivia.R
import com.trivia.navigation.toCategory
import com.trivia.ui.composable.ImageBackground
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController,
) {
    LaunchedEffect(Unit) {
        delay(1000)
        navController.toCategory()
    }
    SplashContent()
}
@Composable
fun SplashContent() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ImageBackground()
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