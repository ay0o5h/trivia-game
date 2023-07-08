package com.trivia.ui.screens.questions.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.trivia.R
import com.trivia.ui.theme.Typography
import com.trivia.ui.theme.White_60
import com.trivia.ui.theme.fontSize_16

@Composable
fun QuestionNumber(
    questionNumber: Int,
    totalQuestionsCount: Int
) {
    Text(text = buildAnnotatedString {
        append(stringResource(id = R.string.question))
        append(" $questionNumber")
        withStyle(SpanStyle(fontSize = fontSize_16)) {
            append("/$totalQuestionsCount")
        }
    }, style = Typography.titleLarge, color = White_60)
}