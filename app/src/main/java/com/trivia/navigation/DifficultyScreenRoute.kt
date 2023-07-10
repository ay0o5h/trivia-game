package com.trivia.navigation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.trivia.navigation.DifficultyScreenArgs.Companion.CATEGORY
import com.trivia.repository.model.CategoriesType
import com.trivia.ui.screens.difficulty.DifficultyScreen



private const val ROUTE = "DifficultyScreen"
fun NavGraphBuilder.difficultyScreenRoute() {
    composable(
        route = "$ROUTE/{$CATEGORY}",

        arguments = listOf(
            navArgument(CATEGORY) { type = NavType.EnumType(CategoriesType::class.java) },
            )
    ) { DifficultyScreen() }
}

class DifficultyScreenArgs(savedStateHandle: SavedStateHandle) {
    val category: CategoriesType = savedStateHandle.get<CategoriesType>(CATEGORY) ?: CategoriesType.UNKNOWN

    companion object {
        const val CATEGORY = "category"
    }
}

fun NavController.navigateToDifficultyScreen(type: CategoriesType) {
    navigate("$ROUTE/${type.name}".also { Log.e("TAGTAG", "navigateToDifficultyScreen: $it", ) })
}




