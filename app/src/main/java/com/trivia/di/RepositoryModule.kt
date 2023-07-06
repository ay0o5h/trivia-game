package com.trivia.di

import com.trivia.remote.TriviaService
import com.trivia.repository.TriviaRepository
import com.trivia.repository.TriviaRepositoryImpl
import com.trivia.viewmodel.CategoryViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(repository: TriviaRepositoryImpl): TriviaRepository
}
