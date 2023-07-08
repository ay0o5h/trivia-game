package com.trivia.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.trivia.repository.model.CategoriesType
import com.trivia.repository.model.DifficultiesType
import com.trivia.ui.screens.questions.QuestionsScreen

private const val ROUTE = "questions"

fun NavGraphBuilder.questionsScreenRoute(navController: NavController) {
    composable(
        "$ROUTE/${QuestionsScreenArgs.CATEGORY}/${QuestionsScreenArgs.DIFFICULTY}",
        arguments = listOf(
            navArgument(QuestionsScreenArgs.CATEGORY) {
                type = NavType.EnumType(CategoriesType::class.java)
            },
            navArgument(QuestionsScreenArgs.DIFFICULTY) {
                type = NavType.EnumType(DifficultiesType::class.java)
            },
        )
    ) {
        QuestionsScreen(navController)
    }
}

class QuestionsScreenArgs(savedStateHandle: SavedStateHandle) {
    val category: CategoriesType =
        savedStateHandle.get<CategoriesType>(CATEGORY) ?: CategoriesType.UNKNOWN
    val difficulty: DifficultiesType =
        savedStateHandle.get<DifficultiesType>(DIFFICULTY) ?: DifficultiesType.EASY

    companion object {
        const val CATEGORY = "category"
        const val DIFFICULTY = "difficulty"
    }
}

fun NavController.toQuestionsScreen(type: CategoriesType, difficultiesType: DifficultiesType) {
    navigate("$ROUTE/${type.name}/${difficultiesType.name}")
}
