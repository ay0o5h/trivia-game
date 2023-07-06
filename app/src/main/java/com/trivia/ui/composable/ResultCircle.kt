package com.trivia.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.trivia.ui.theme.Purple
import com.trivia.ui.theme.White_36
import com.trivia.ui.theme.fontSize_28
import com.trivia.ui.theme.fontSize_36
import com.trivia.ui.theme.space_140
import com.trivia.ui.theme.space_4

@Composable
fun ResultCircle(
    result: Int
) {
    Surface(
        modifier = Modifier.size(
            space_140),
        color= Color.Transparent,
        shape = CircleShape,
        border = BorderStroke(
            space_4, brush = Brush.verticalGradient(listOf(Purple, White_36))
        )
    ) {
        val text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = White.copy(0.87f), fontSize = fontSize_36)) {
                append(result.toString())
            }
            withStyle(style = SpanStyle(color = White.copy(0.7f), fontSize = fontSize_36)) {
                append("/")
            }

            withStyle(style = SpanStyle(color = White.copy(0.7f), fontSize = fontSize_28)) {
                append("10")
            }
        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = text, fontSize = fontSize_36, color = White, fontWeight = FontWeight.W500)
        }
    }
}


@Preview
@Composable
fun ResultCirclePrev() {
    ResultCircle(8)
}