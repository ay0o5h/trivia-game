package com.trivia.navigation


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

import androidx.navigation.compose.composable
import com.trivia.ui.screens.splash.SplashScreen


private const  val  ROUTE ="splash"

fun NavGraphBuilder.SplashScreenRoute(navController: NavController){
    composable(
       route= ROUTE,
    )
    {
        SplashScreen(navController as NavHostController)
    }
}

fun NavController.toSplash(){
    navigate(ROUTE)
}
