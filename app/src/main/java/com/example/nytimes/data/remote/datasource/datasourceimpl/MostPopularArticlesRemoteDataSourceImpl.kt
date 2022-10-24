package com.example.nytimes.data.remote.datasource.datasourceimpl

import com.example.nytimes.data.model.response.MostPopularArticlesResponse
import com.example.nytimes.data.remote.datasource.MostPopularArticlesRemoteDataSource
import com.example.nytimes.data.remote.network.ApiClients
import retrofit2.Response

class MostPopularArticlesRemoteDataSourceImpl(
    private val apiClients: ApiClients
    ): MostPopularArticlesRemoteDataSource {
    override suspend fun getMostPopularArticles(): Response<MostPopularArticlesResponse> {
        return apiClients.getMostPopularArticles()
    }
}