package com.trivia.navigation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.trivia.repository.model.CategoriesType
import com.trivia.repository.model.DifficultiesType
import com.trivia.ui.screens.ResultScreen


private const val ROUTE = "Result"


fun NavGraphBuilder.ResultScreenRoute(navController: NavController) {

    composable(
        route = "${ROUTE}/" +
                "{${ResultScreenArgs.SCORE}}/{${ResultScreenArgs.CATEGORY}}/{${ResultScreenArgs.DIFFICULTY}}",
        arguments = listOf(navArgument(ResultScreenArgs.SCORE) {
            NavType.IntType
            defaultValue = 0
        },  navArgument(ResultScreenArgs.CATEGORY) {
            type = NavType.EnumType(CategoriesType::class.java)
        },
            navArgument(ResultScreenArgs.DIFFICULTY) {
                type = NavType.EnumType(DifficultiesType::class.java)
            },)
    )
    {
        ResultScreen(navController as NavHostController)
    }
}

class ResultScreenArgs(savedStateHandle: SavedStateHandle) {
    val score: Int = checkNotNull(savedStateHandle[SCORE])
    val category: CategoriesType =
        savedStateHandle.get<CategoriesType>(QuestionsScreenArgs.CATEGORY) ?: CategoriesType.MUSIC
    val difficulty: DifficultiesType =
        savedStateHandle.get<DifficultiesType>(QuestionsScreenArgs.DIFFICULTY) ?: DifficultiesType.EASY
    companion object {
        const val SCORE = "score"
        const val CATEGORY = "category"
        const val DIFFICULTY = "difficulty"
    }

}

fun NavController.toResultScreen(score: Int, categoryGame: String, difficultiesType: String) {
        navigate("${ROUTE}/${score}/${categoryGame}/${difficultiesType}"){
            popBackStack()
        }
}

