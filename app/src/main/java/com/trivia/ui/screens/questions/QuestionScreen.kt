package com.trivia.ui.screens.questions

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.trivia.R
import com.trivia.navigation.toResultScreen
import com.trivia.ui.composable.FillButton
import com.trivia.ui.composable.ImageBackground
import com.trivia.ui.composable.ScreenWithHeaderAndFooterImages
import com.trivia.ui.screens.questions.composables.AnimatedTimerProgress
import com.trivia.ui.screens.questions.composables.Choices
import com.trivia.ui.screens.questions.composables.QuestionNumber
import com.trivia.ui.theme.TriviaTheme
import com.trivia.ui.theme.Typography
import com.trivia.ui.theme.White_87
import com.trivia.ui.theme.space_16
import com.trivia.ui.theme.space_24
import com.trivia.ui.theme.space_8
import com.trivia.viewmodel.questions.QuestionsInteractionsListener
import com.trivia.viewmodel.questions.QuestionsUiState
import com.trivia.viewmodel.questions.QuestionsViewModel

@Composable
fun QuestionsScreen(
    navController: NavController,
    viewModel: QuestionsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
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
) {
    Box(modifier = Modifier.fillMaxSize()) {
        ImageBackground()
        ScreenWithHeaderAndFooterImages(header = painterResource(id = R.drawable.group_astrounat))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .scrollable(rememberScrollState(), Orientation.Vertical),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(space_8),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    QuestionNumber(state.currentQuestionNumber, state.totalQuestion)
                    AnimatedTimerProgress(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = space_16, vertical = space_8),
                        currentTime = state.currentTime,
                        maxTime = state.maxTime
                    )
                }

                Text(
                    text = state.currentQuestion.question,
                    style = Typography.titleLarge,
                    color = White_87,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = space_16, vertical = space_24)
                )

                Choices(state, listener)
            }
            Spacer(modifier = Modifier.weight(1f))
            FillButton(
                isVisible = state.hasSubmitButton,
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


@Preview
@Composable
fun Preview() {
    TriviaTheme {
        QuestionsScreenContent(
            state = QuestionsUiState(
                currentTime = 15,
                questions = listOf(
                    QuestionsUiState.QuestionUiState(
                        "Where is Moody?",
                        "moody",
                        listOf("ada", "asdaq", "ryryr"),
                    ),
                ),
            ),
            listener = object : QuestionsInteractionsListener {
                override fun onClickAnswer(answer: String) {
                    TODO("Not yet implemented")
                }

                override fun onClickSubmit() {
                    TODO("Not yet implemented")
                }
            })
    }
}