package com.trivia.ui.composable

import android.graphics.fonts.FontFamily
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trivia.ui.theme.TextWhite
import com.trivia.ui.theme.fontSize_22

@Composable
fun Title(
    text: String,
    modifier: Modifier = Modifier.padding(horizontal = 16.dp)
) {
    Text(
        text = text,
        modifier=modifier,
        fontSize = fontSize_22,
            fontWeight = FontWeight.W600,
            color = TextWhite,
            textAlign = TextAlign.Center)
}