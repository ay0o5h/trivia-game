package com.trivia.repository.model

enum class Categories {
    SCIENCE,MUSIC ;

    override fun toString(): String {
        return when(this){
            SCIENCE -> "science"
            MUSIC -> "music"
        }
    }
}