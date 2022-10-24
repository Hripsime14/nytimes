package com.example.nytimes.data.remote.datasource

import com.example.nytimes.data.model.response.MostPopularArticlesResponse
import retrofit2.Response

interface MostPopularArticlesRemoteDataSource {
    suspend fun getMostPopularArticles(): Response<MostPopularArticlesResponse>
}