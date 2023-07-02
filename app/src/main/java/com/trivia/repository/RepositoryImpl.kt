package com.trivia.repository

import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class RepositoryImpl : Repository {


    private suspend fun <T> wrapBaseResponse(
        response: suspend () -> Response<List<T>>
    ): List<T> {
        return try {
            val apiResponse = response()
            if (apiResponse.isSuccessful) {
                val responseBody = apiResponse.body()
                responseBody ?: throw Throwable("No Data Found")
            } else {
                throw Throwable(" Not Success Request ")
            }
        } catch (e: HttpException) {
            when (e.code()) {
                401 -> throw CustomError.UnauthorizedException("Unauthorized")
                404 -> throw CustomError.NotFoundException("Resource not found")
                else -> throw e
            }
        } catch (e: IOException) {
            throw CustomError.NetworkException("Network error")
        } catch (e: Throwable) {
            throw e
        }
    }

}