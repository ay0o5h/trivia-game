package com.trivia.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trivia.ui.theme.TextWhite

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    isWrongAnswer: Boolean = false,
    isCorrectAnswer: Boolean = false,
    isClicked: Boolean = false
){
    Button(

        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White,
        ),
        contentPadding= PaddingValues( vertical = 15.dp),
        onClick = onClick,
                modifier = Modifier
                    .fillMaxWidth()
                .padding(8.dp)
                    .border(
                        width = 4.dp,
                        brush = Brush.horizontalGradient(colors =  listOf(Color(0xFFBE61E9), Color(0xFF0657A3))),
                        shape = RoundedCornerShape(percent = 50)
                    )
                    .background(
                        brush = Brush.horizontalGradient(
                            colors =     listOf(Color(0xFFBE61E9),
                                Color(0xFF0657A3)),
                        ),
                        shape = RoundedCornerShape(percent = 50)
                    )
    ) {

        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight(500),
            color = TextWhite)
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    PrimaryButton(text = "Button", onClick = {})
}
