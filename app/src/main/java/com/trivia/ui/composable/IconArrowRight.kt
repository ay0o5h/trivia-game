package com.trivia.ui.composable

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.trivia.R
import com.trivia.ui.theme.White_87
import com.trivia.ui.theme.space_24

@Composable
fun IconArrowRight(
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(id = R.drawable.arrowright),
        contentDescription = stringResource(R.string.arrowright),
        tint = White_87,
        modifier = modifier.size(space_24)
    )
}