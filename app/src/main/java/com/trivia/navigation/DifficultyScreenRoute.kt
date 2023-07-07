package com.trivia.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.trivia.repository.model.CategoriesType
import com.trivia.repository.model.DifficultiesType
import com.trivia.ui.screens.DifficultyScreen



private const val ROUTE = "DifficultyScreen"
fun NavGraphBuilder.difficultyScreenRoute(navController: NavController) {
    composable(
        route = "$ROUTE/{${ScreensRoute.Category.route}}",

        arguments = listOf(
            navArgument(ScreensRoute.Category.route) { type = NavType.EnumType(CategoriesType::class.java) },
            )
    ) { DifficultyScreen(navController) }
}

class DifficultyScreenArgs(savedStateHandle: SavedStateHandle) {
    val category: CategoriesType = savedStateHandle.get<CategoriesType>(ScreensRoute.Category.route) ?: CategoriesType.UNKNOWN


}

fun NavController.navigateToDifficultyScreen(type: CategoriesType) {
    navigate("$ROUTE/${type.name}")
}




