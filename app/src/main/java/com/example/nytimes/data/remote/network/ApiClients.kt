package com.example.nytimes.data.remote.network

import com.example.nytimes.data.model.response.MostPopularArticlesResponse
import com.example.nytimes.data.remote.MOST_POPULAR
import retrofit2.Response
import retrofit2.http.GET

interface ApiClients {

    @GET(MOST_POPULAR)
    suspend fun getMostPopularArticles(): Response<MostPopularArticlesResponse>

}