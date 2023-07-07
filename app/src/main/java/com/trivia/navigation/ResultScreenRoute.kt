package com.trivia.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.trivia.ui.screens.ResultScreen


private const  val  ROUTE ="Result"


fun NavGraphBuilder.ResultScreenRoute(navController: NavController){

    composable(
        route="${ROUTE}/" +
                "${ResultScreenArgs.SCORE}/${ResultScreenArgs.CATEGORY_NAME}/${ResultScreenArgs.LEVEL}",
        arguments = listOf(navArgument(ResultScreenArgs.SCORE) {
            NavType.IntType
            defaultValue = 0
        },navArgument(ResultScreenArgs.CATEGORY_NAME) {
            NavType.StringType
            defaultValue = ""
        },navArgument(ResultScreenArgs.LEVEL) {
            NavType.StringType
            defaultValue = ""
        }))
    {
        ResultScreen(navController as NavHostController)
    }
}

class ResultScreenArgs(savedStateHandle: SavedStateHandle) {
    val score: Int = checkNotNull(savedStateHandle[SCORE])
    val categoryGame: String = checkNotNull(savedStateHandle[CATEGORY_NAME])
    val level: Int = checkNotNull(savedStateHandle[LEVEL])
    companion object {
        const val  SCORE="score"
        const val CATEGORY_NAME="categoryGame"
        const val  LEVEL ="level"
    }

}

fun NavController.toResultScreen(score : String,categoryGame:String,level:String){
    navigate(
        "${ROUTE}/" +
                "${ResultScreenArgs.SCORE}/${ResultScreenArgs.CATEGORY_NAME}/${ResultScreenArgs.LEVEL}",
    )
}

