package com.example.nytimes.data.remote.network.interceptor

import com.example.nytimes.data.remote.API_KEY
import com.example.nytimes.data.remote.API_KEY_WORD
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder();
        val originalHttpUrl = chain.request().url;
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(API_KEY_WORD, API_KEY).build();
        request.url(url);
        return chain.proceed(request.build());
    }
}