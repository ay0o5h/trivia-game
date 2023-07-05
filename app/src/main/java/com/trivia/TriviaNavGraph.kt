package com.trivia

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.trivia.ui.screens.CategoryScreen
import com.trivia.ui.screens.ResultScreen
import com.trivia.ui.screens.SplashScreen

@Composable
fun TriviaNavGraph(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = ScreensRoute.Splash.route) {
        composable(ScreensRoute.Splash.route) {
            SplashScreen(navController)
        }
        composable(
            ScreensRoute.Result.route,
            arguments = listOf(navArgument("score") {
                NavType.IntType
                defaultValue = 0
            })) {
            ResultScreen(navController)
        }
        composable(ScreensRoute.Category.route) {
            CategoryScreen(navController)
        }
    }
}

