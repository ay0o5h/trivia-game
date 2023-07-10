package com.trivia.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.trivia.ui.screens.category.CategoryScreen

private const  val  ROUTE ="category"

fun NavGraphBuilder.categoryScreenRoute(){
    composable(
        route= ROUTE,
    )
    {
        CategoryScreen()
    }
}

fun NavController.toCategory(){
    navigate(ROUTE){
        popBackStack()
    }
}