package com.trivia.ui.composable

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.trivia.R
import com.trivia.ui.theme.White_70
import com.trivia.ui.theme.White_87

@Composable
fun IconArrow(
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(id = R.drawable.arrowright),
        contentDescription = "arrowright",
        tint = White_87,
        modifier = modifier.size(24.dp)
    )
}