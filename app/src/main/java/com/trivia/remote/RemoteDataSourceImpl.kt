package com.trivia.remote

import android.util.Log
import com.trivia.remote.resourses.QuestionInfoResource
import com.trivia.respository.datasourses.RemoteDataSource
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val triviaService: TriviaService
) : RemoteDataSource {
    override suspend fun getQuestions(
        limit: Int,
        categories: String,
        difficulty: String,
        type: String
    ): List<QuestionInfoResource> {
        return  tryToExecute {
            triviaService.getQuestions(
                limit = limit ,
                categories = categories,
                difficulty= difficulty,
                type= type)
        }
    }

    override suspend fun getQuestionById(id: Int): QuestionInfoResource {
        return tryToExecute { triviaService.getQuestionById(id) }
    }
    private suspend fun <T> tryToExecute(func: suspend () -> Response<T>): T {
        val response = func()
        Log.d("TAG", "tryToExecute: ${response.code()}")
        if (response.isSuccessful) {
            return response.body() ?: throw Exception("Body is null")
        }
        throw IOException()
        }

}