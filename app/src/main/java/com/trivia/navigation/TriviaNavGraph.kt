package com.trivia.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.trivia.ui.screens.CategoryScreen
import com.trivia.ui.screens.ResultScreen
import com.trivia.ui.screens.SplashScreen

private const val START_DESTINATION ="splash"

@Composable
fun TriviaNavGraph(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = START_DESTINATION) {
        SplashScreenRoute(navController)
        ResultScreenRoute(navController)
        CategoryScreenRoute(navController)
        difficultyScreenRoute(navController)
    }
}

