package com.trivia

sealed class ScreensRoute(val route: String) {
    object Splash : ScreensRoute("splash")
    object Result : ScreensRoute("result/{score}")
    object Category : ScreensRoute("category")
}
