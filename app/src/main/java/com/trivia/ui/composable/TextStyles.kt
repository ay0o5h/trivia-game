package com.trivia.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.trivia.ui.theme.White_70
import com.trivia.ui.theme.fontSize_14
import com.trivia.ui.theme.fontSize_24

object TextStyles {
    @Composable
    fun LargeTextStyle(): TextStyle {
        return TextStyle(
            fontSize = fontSize_24,
            fontWeight = FontWeight.W500,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
    @Composable
    fun MeduimTextStyle(): TextStyle {
        return TextStyle(
            fontSize = fontSize_14,
            color = White_70,
            textAlign = TextAlign.Center
        )
    }
}