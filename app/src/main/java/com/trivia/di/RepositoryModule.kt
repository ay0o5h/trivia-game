package com.trivia.di

import com.trivia.repository.TriviaRepository
import com.trivia.repository.TriviaRepositoryImpl
import com.trivia.repository.data.CashQuestionsHelper
import com.trivia.repository.data.CashQuestionsHelperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(repository: TriviaRepositoryImpl): TriviaRepository

    @Binds
    abstract fun bindsQuestionsSource(questionsDataSourceImpl: CashQuestionsHelperImpl): CashQuestionsHelper
}
