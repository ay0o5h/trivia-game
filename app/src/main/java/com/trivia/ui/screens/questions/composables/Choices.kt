package com.trivia.ui.screens.questions.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.trivia.ui.bases.ButtonUIState
import com.trivia.ui.composable.OutlineButton
import com.trivia.viewmodel.questions.QuestionsInteractionsListener
import com.trivia.viewmodel.questions.QuestionsUiState

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