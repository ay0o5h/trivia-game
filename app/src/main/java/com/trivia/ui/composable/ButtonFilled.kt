package com.trivia.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.trivia.ui.theme.PurpleDark
import com.trivia.ui.theme.Typography
import com.trivia.ui.theme.White36
import com.trivia.ui.theme.White_36
import com.trivia.ui.theme.White_70
import com.trivia.ui.theme.space_15
import com.trivia.ui.theme.space_28
import com.trivia.ui.theme.space_38
import com.trivia.ui.theme.space_56


@Composable
fun ButtonFilled(
    isVisible: Boolean,
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    ) {


    AnimatedVisibility(visible = isVisible, enter = fadeIn(), exit = fadeOut()) {
        Box(
            modifier = modifier
                .height(space_56)
                .clip(RoundedCornerShape(space_28))
                .background(color = White_36)
                .clickable(
                    interactionSource = CreateMutableInteractionSource(),
                    indication = CreateIndication(),
                    onClick = onClick
                )
        ) {
            Text(
                text = text,
                color = White_70,
                style = Typography.titleMedium,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(vertical = space_15, horizontal = space_38),

                )
        }

    }
}


@Preview
@Composable
fun ButtonContinuePreview() {
    ButtonFilled(true, text = "", onClick = {})
}
