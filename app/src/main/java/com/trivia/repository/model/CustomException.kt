package com.trivia.repository.model

sealed class CustomException() : Exception() {
    data class NetworkException(override val message: String) : CustomException()
    data class UnsuccessfulRequestException(override val message: String) : CustomException()
    data class NoDataException(override val message: String) : CustomException()
}
