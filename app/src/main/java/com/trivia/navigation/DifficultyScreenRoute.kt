package com.trivia.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.trivia.navigation.DifficultyScreenArgs.Companion.CATEGORY
import com.trivia.repository.model.CategoriesType
import com.trivia.repository.model.DifficultiesType
import com.trivia.ui.screens.DifficultyScreen

fun NavController.navigateToDifficultyScreen(category:String) {
    navigate("$ROUTE/$category")
}

private const val ROUTE = "DifficultyScreen"
fun NavGraphBuilder.difficultyScreenRoute(navController: NavController) {
    composable(
        route = "$ROUTE/{$CATEGORY}",

        arguments = listOf(
            navArgument(CATEGORY) { type = NavType.EnumType(CategoriesType::class.java) },
            )
    ) { DifficultyScreen(navController) }
}

class DifficultyScreenArgs(savedStateHandle: SavedStateHandle) {
    val category: CategoriesType = savedStateHandle.get<CategoriesType>(CATEGORY) ?: CategoriesType.UNKNOWN

    companion object {
        const val CATEGORY = "category"
    }
}

fun NavController.navigateToDifficultyScreen(type: CategoriesType) {
    navigate("$ROUTE/${type.name}")
}



