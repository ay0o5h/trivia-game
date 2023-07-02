package com.trivia.di

import com.trivia.BuildConfig
import com.trivia.remote.AuthInterceptor
import com.trivia.remote.TriviaService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(AuthInterceptor())
            .build()
    }

    @Singleton
    @Provides
    fun provideGson(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofitBuilder(
        client: OkHttpClient,
        factory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(factory)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit): TriviaService {
        return retrofit.create(TriviaService::class.java)
    }


}