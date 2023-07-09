package com.trivia.viewmodel.difficulty

import com.trivia.viewmodel.state.Difficulty

interface DifficultyScreenInteractions {
   fun onSelectDifficulty(passedDifficulty: Difficulty)

}