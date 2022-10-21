package com.example.nytimes.data.remote.network.interceptor

import com.example.nytimes.data.remote.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val apiKey = API_KEY
        val request = chain.request().newBuilder();
        val originalHttpUrl = chain.request().url;
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api-key", apiKey).build();
        request.url(url);
        return chain.proceed(request.build());
    }
}