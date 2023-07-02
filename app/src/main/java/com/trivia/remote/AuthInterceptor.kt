package com.trivia.remote

import com.trivia.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder()
            .header(API_KEY_HEADER,  BuildConfig.api_key)
            .build()
        return chain.proceed(request)
    }

    companion object {
        const val API_KEY_HEADER = "X-API-Key"
    }
}