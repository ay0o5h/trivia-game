package com.trivia.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

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
        questionsScreenRoute(navController)
    }
}

