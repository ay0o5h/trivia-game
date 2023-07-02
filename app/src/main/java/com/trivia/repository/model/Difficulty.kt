package com.trivia.repository.model

enum class Difficulty {
    HARD, MEDIUM, EASY;

    override fun toString(): String {
        return when(this){
            HARD -> "hard"
            MEDIUM -> "medium"
            EASY -> "easy"
        }
    }
}