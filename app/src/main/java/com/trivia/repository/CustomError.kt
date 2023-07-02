package com.trivia.repository

sealed class CustomError(message: String) : Exception() {

    class UnauthorizedException(message: String) : CustomError(message)

    class NotFoundException(message: String) : CustomError(message)

    class NetworkException(message: String) : CustomError(message)

}