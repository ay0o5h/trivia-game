package com.trivia.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

private const val START_DESTINATION ="splash"
val LocalNavController = compositionLocalOf<NavHostController> { error("NO CONTROLLER EXIST") }

@Composable
fun TriviaNavGraph(
    navController: NavHostController
){

    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(navController = navController, startDestination = START_DESTINATION) {
            splashScreenRoute()
            resultScreenRoute()
            categoryScreenRoute()
            difficultyScreenRoute()
            questionsScreenRoute()
        }
    }
}

