package com.trivia.ui.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.trivia.ui.theme.space_32

@Composable
fun SpacerVertical32(){
    Spacer(modifier = Modifier.height(space_32))
}