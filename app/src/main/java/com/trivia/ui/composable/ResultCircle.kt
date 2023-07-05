package com.trivia.ui.composable

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trivia.ui.theme.Blue
import com.trivia.ui.theme.Gray
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
        modifier = Modifier.size(space_140)
            .background(color=Color.Transparent),
        shape = CircleShape,
        color= Color.Transparent,
        border = BorderStroke(
           space_4, color =  White_36, )
        )
    {

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
                Text(
                    text = text,
                    fontSize = fontSize_36,
                    color = White,
                    fontWeight = FontWeight.W500
                )
            }

    }
}


@Preview
@Composable
fun ResultCirclePrev() {
    ResultCircle(8)
}


@Composable
fun TwoCircles() {
    val firstCircle = Surface(
        modifier = Modifier
            .padding(16.dp)
            .clip(CircleShape),
        color = Color.White.copy(alpha = 0.36f)
    ) {
        Text("First Circle")
    }

    val secondCircle = Surface(
        modifier = Modifier
            .padding(16.dp)
            .clip(CircleShape)
            .size(150.dp),
        color = Color.White.copy(alpha = 0.36f),
        border = BorderStroke(
            space_4, color =  Purple, )

    ) {
        Text("Second Circle")
    }

    Box {
        firstCircle
        secondCircle
    }
}

@Preview
@Composable
fun TwoCirclesPreview() {
    TwoCircles()
}
