package com.trivia.ui.screens.questions

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.hilt.navigation.compose.hiltViewModel
import com.trivia.R
import com.trivia.navigation.LocalNavController
import com.trivia.navigation.toResultScreen
import com.trivia.ui.composable.ButtonFilled
import com.trivia.ui.composable.MainScaffold
import com.trivia.ui.composable.OutlineButton
import com.trivia.ui.screens.questions.composables.AnimatedTimerProgress
import com.trivia.ui.theme.Typography
import com.trivia.ui.theme.White_60
import com.trivia.ui.theme.White_87
import com.trivia.ui.theme.fontSize_16
import com.trivia.ui.theme.space_12
import com.trivia.ui.theme.space_16
import com.trivia.ui.theme.space_24
import com.trivia.ui.theme.space_8

@Composable
fun QuestionsScreen(
    viewModel: QuestionsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavController.current
    QuestionsScreenContent(state = state, listener = viewModel)
    LaunchedEffect(key1 = state.shouldNavigate) {
        if (state.shouldNavigate) {
            navController.toResultScreen(
                state.passedQuestion,
                viewModel.args.category.name,
                viewModel.args.difficulty.name
            )
        }
    }
}

@Composable
fun QuestionsScreenContent(
    state: QuestionsUiState,
    listener: QuestionsInteractionsListener,
    modifier: Modifier = Modifier
) {
    MainScaffold(
        modifier = modifier,
        header = {
            Image(
                painter = painterResource(id = R.drawable.group_astrounat),
                contentDescription = stringResource(R.string.space),
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )
        },
        content = {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = buildAnnotatedString {
                            append(stringResource(id = R.string.question))
                            append(" ${state.currentQuestionNumber}")
                            withStyle(SpanStyle(fontSize = fontSize_16)) { append("/${state.totalQuestion}") }
                        },
                        style = Typography.titleLarge.copy(color = White_60),
                        modifier = Modifier.padding(bottom = space_8)
                    )
                    AnimatedTimerProgress(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = space_16, vertical = space_8),
                        currentTime = state.currentTime,
                        maxTime = state.maxTime
                    )
                    Text(
                        text = state.currentQuestion.question,
                        style = Typography.titleLarge.copy(color = White_87),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = space_16, vertical = space_24)
                    )
                    state.currentQuestion.optionsAfterShuffled.forEach {
                        OutlineButton(
                            text = it.text,
                            onClick = { listener.onClickAnswer(it) },
                            buttonUIState = it.buttonUIState,
                            modifier = Modifier.padding(bottom = space_12)
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    ButtonFilled(
                        isVisible = state.currentQuestion.hasSubmitButton,
                        text = stringResource(id = R.string.submit),
                        onClick = { listener.onClickSubmit() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = space_16)
                            .padding(bottom = space_24)
                    )
                }
            }
        }
    )
}