package com.trivia.ui.screens.question

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.trivia.R
import com.trivia.ui.bases.ButtonUIState
import com.trivia.ui.composable.PrimaryButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun QuestionScreen(
    vm: QuestionViewModel = hiltViewModel()
) {

    val state by vm.state.collectAsState()

    Scaffold(
        topBar = {
            QuestionsTopBar()
        }
    ) {
        QuestionsContent(state = state)
    }
}


@Composable
fun QuestionsContent(
    state: QuestionState
) {

    var selectedAnswer by remember {
        mutableStateOf<String?>(null)
    }

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .blur(40.dp),
            painter = painterResource(id = R.drawable.background),
            contentScale = ContentScale.FillBounds,
            contentDescription = "background image"
        )

        val choices = state.incorrectAnswers + state.correctAnswer
        choices.shuffled()

        QuestionHorizontalProgress(progress = state.progress.toFloat())

        QuestionItem(
            progress = state.progress.toInt(),
            questionNumber = state.questionNumber,
            answerOptions = choices,
            correctAnswer = state.correctAnswer,
            onAnswerSelected = {
                selectedAnswer = it
            }
        )
    }
}

@Composable
fun QuestionItem(
    progress: Int,
    questionNumber: Int,
    answerOptions: List<String>,
    correctAnswer: String,
    onAnswerSelected: (String) -> Unit
) {
    AnswerButtons(
        answerOptions = answerOptions,
        correctAnswer = correctAnswer,
        onAnswerSelected = onAnswerSelected,
    )
}

@Composable
fun AnswerButtons(
    answerOptions: List<String>,
    correctAnswer: String,
    onAnswerSelected: (String) -> Unit
) {
    val buttonUIStateMap = remember { mutableStateMapOf<String, ButtonUIState>() }

    Column {
        answerOptions.forEach { answer ->
            val buttonUIState = buttonUIStateMap[answer] ?: ButtonUIState.StartState

            PrimaryButton(
                text = answer,
                buttonUIState = buttonUIState
            ) {
                onAnswerSelected(answer)
                val newButtonUIState =
                    if (answer == correctAnswer) ButtonUIState.CorrectState else ButtonUIState.ErrorState
                buttonUIStateMap[answer] = newButtonUIState
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}



@Composable
fun QuestionHorizontalProgress(
    progress: Float
) {
    LinearProgressIndicator(progress = progress, color = Color(0xFF6C0E9C).copy(0.6f))
}


@Composable
fun QuestionsTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.group_41), contentDescription = "")
    }
}
