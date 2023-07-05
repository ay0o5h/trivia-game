package com.trivia.repository.model

enum class CategoriesType {
    FILM_AND_TV, MUSIC, ARTS_AND_LITERATURE, GENERAL_KNOWLEDGE, UNKNOWN;

    override fun toString(): String {
        return when (this) {
            FILM_AND_TV -> "film_and_tv"
            MUSIC -> "music"
            GENERAL_KNOWLEDGE -> "general_knowledge"
            ARTS_AND_LITERATURE -> "arts_and_literature"
            UNKNOWN -> "unknown"
        }
    }
}