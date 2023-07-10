package com.trivia.navigation


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

import androidx.navigation.compose.composable
import com.trivia.ui.screens.splash.SplashScreen


private const  val  ROUTE ="splash"

fun NavGraphBuilder.splashScreenRoute(){
    composable(
       route= ROUTE,
    )
    {
        SplashScreen()
    }
}

