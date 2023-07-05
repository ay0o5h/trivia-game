package com.trivia.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.trivia.ui.bases.BaseViewModel
import com.trivia.viewmodel.state.ResultUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class ResultViewModel @Inject constructor (
    savedStateHandle: SavedStateHandle
) : BaseViewModel<ResultUIState>(ResultUIState()){
    private val args :Int = savedStateHandle["score"] ?: 0

    init{
        getResult()
    }
    private fun getResult(){
        _state.update {
            it.copy(
                score = args,
                isWinner = itIsWinner()
            )
        }
    }
   private fun itIsWinner() : Boolean{
       if(args > 5){
           return  true
       }
       return false
   }
}