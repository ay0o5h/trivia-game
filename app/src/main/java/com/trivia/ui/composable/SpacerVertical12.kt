package com.trivia.ui.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.trivia.ui.theme.space_12

@Composable
fun SpacerVertical12(){
    Spacer(modifier = Modifier.height(space_12))
}