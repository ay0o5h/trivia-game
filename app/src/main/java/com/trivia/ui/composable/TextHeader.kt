package com.trivia.ui.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.trivia.ui.theme.Typography
import com.trivia.ui.theme.White_87
import com.trivia.ui.theme.space_16
import com.trivia.ui.theme.space_202

@Composable
fun TextHeader(text: String,modifier: Modifier = Modifier) {
    Text(
        modifier = Modifier.padding(end = space_16, start = space_16, top = space_202),
        text = text,
        style = Typography.titleLarge,
        color = White_87
    )
}