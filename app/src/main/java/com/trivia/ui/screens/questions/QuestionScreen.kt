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
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.trivia.R
import com.trivia.navigation.toResultScreen
import com.trivia.ui.bases.ButtonUIState
import com.trivia.ui.composable.FillButton
import com.trivia.ui.composable.ImageBackground
import com.trivia.ui.composable.OutlineButton
import com.trivia.ui.composable.ScreenWithHeaderAndFooterImages
import com.trivia.ui.screens.questions.composables.AnimatedTimerProgress
import com.trivia.ui.theme.TriviaTheme
import com.trivia.ui.theme.Typography
import com.trivia.ui.theme.White_60
import com.trivia.ui.theme.White_87
import com.trivia.ui.theme.fontSize_16
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
                            .padding(horizontal = space_16),
                        currentTime = state.currentTime,
                        maxTime = state.maxTime
                    )
                }

                Text(
                    text = state.currentQuestion.question,
                    style = Typography.titleLarge,
                    color = White_87,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = space_16)
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

@Composable
fun Choices(
    state: QuestionsUiState,
    listener: QuestionsInteractionsListener,
    modifier: Modifier = Modifier
) {
    val buttonsStateList = remember { mutableStateMapOf<String, ButtonUIState>() }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        state.currentQuestion.optionsAfterShuffled.forEach {
            val buttonUIState = buttonsStateList[it] ?: ButtonUIState.StartState

            OutlineButton(
                text = it,
                onClick = { listener.onClickAnswer(it) },
                buttonUIState = buttonUIState,
            )
        }
    }

    state.selectedAnswer?.let { answer ->
        buttonsStateList[answer] = state.selectedAnswerState ?: ButtonUIState.ClickedState
        buttonsStateList.forEach { (t, _) ->
            if (answer != t) buttonsStateList[t] = ButtonUIState.StartState
        }
    }

    if (state.showCorrect && state.selectedAnswer != null) {
        buttonsStateList[state.currentQuestion.correctAnswer] = ButtonUIState.CorrectState
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