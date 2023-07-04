package com.trivia.ui.bases

sealed class ButtonUIState(){
    object ErrorState : ButtonUIState()

    object ClickedState : ButtonUIState()

    object StartState : ButtonUIState()

    object CorrectState : ButtonUIState()
}