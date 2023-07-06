package com.trivia.repository.model

enum class DifficultiesType {
    HARD, MEDIUM, EASY, UNKNOWN;

    override fun toString(): String {
        return when(this){
            HARD -> "hard"
            MEDIUM -> "medium"
            EASY -> "easy"
            UNKNOWN -> "unknown"
        }
    }
}