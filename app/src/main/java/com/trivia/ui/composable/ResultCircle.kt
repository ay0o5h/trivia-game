package com.trivia.ui.composable

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
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trivia.ui.theme.Blue
import com.trivia.ui.theme.Purple

@Composable
fun ResultCircle(
    result: Int
) {
    Surface(
        modifier = Modifier.size(140.dp),
        shape = CircleShape,
        border = BorderStroke(
            4.dp, brush = Brush.horizontalGradient(listOf(Purple, Blue))
        )
    ) {
        val text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = White.copy(0.87f), fontSize = 36.sp)) {
                append(result.toString())
            }
            withStyle(style = SpanStyle(color = White.copy(0.7f), fontSize = 36.sp)) {
                append("/")
            }

            withStyle(style = SpanStyle(color = White.copy(0.7f), fontSize = 28.sp)) {
                append("10")
            }
        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = text, fontSize = 36.sp, color = White, fontWeight = FontWeight(500))
        }
    }
}


@Preview
@Composable
fun ResultCirclePrev() {
    ResultCircle(8)
}