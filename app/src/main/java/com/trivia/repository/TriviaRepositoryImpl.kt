package com.trivia.repository

import com.trivia.remote.TriviaService
import com.trivia.remote.response.QuestionInfo
import com.trivia.repository.data.DataSource
import com.trivia.repository.model.CategoriesType
import com.trivia.repository.model.CustomException
import com.trivia.repository.model.DifficultiesType
import com.trivia.viewmodel.state.Category
import com.trivia.viewmodel.state.Difficulty
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class TriviaRepositoryImpl @Inject constructor(
    private val apiService: TriviaService
): TriviaRepository  {

    override suspend fun getQuestions(category: CategoriesType, difficultiesType: DifficultiesType): List<QuestionInfo> {
        return wrapBaseResponse { apiService.getQuestions(categoriesType = category, difficultiesType = difficultiesType) }
    }

    override fun getCategories(): List<Category> {
        return DataSource.categories
    }

    override fun getDifficulty(): List<Difficulty> {
        return DataSource.difficulties
    }

    private suspend fun <T> wrapBaseResponse(
        response: suspend () -> Response<List<T>>
    ): List<T> {
        return try {
            val apiResponse = response()
            when {
                apiResponse.isSuccessful -> {
                    apiResponse.body() ?: throw CustomException.NoDataException("No Data Found")
                }
                else -> throw CustomException.UnsuccessfulRequestException("Not success request")
            }
        } catch (e: IOException) {
            throw CustomException.NetworkException("Network error")
        }
    }

}