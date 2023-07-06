package com.trivia.viewmodel

import com.trivia.viewmodel.state.Difficulty

interface DifficultyScreenInteractions {
   fun onSelectDifficulty(passedDifficulty: Difficulty)

}