package com.example.nytimes.data.repo.repoimpl

import com.example.nytimes.data.model.data.MostPopularArticleData
import com.example.nytimes.data.remote.OK
import com.example.nytimes.data.remote.datasource.MostPopularArticlesRemoteDataSource
import com.example.nytimes.data.remote.mapper.RESPONSE_TO_DATA_MAPPER
import com.example.nytimes.data.repo.MostPopularArticlesRepo
import com.example.nytimes.data.repo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MostPopularArticlesRepoImpl(
    private val mostPopularArticlesRemoteDataSource: MostPopularArticlesRemoteDataSource
    ): MostPopularArticlesRepo {
        override fun getMostPopularArticles(): Flow<Resource<MostPopularArticleData>> = flow {
            emit(Resource.Loading(null))
            val resource = try {
                val response = mostPopularArticlesRemoteDataSource.getMostPopularArticles()
                if (response.isSuccessful && response.body()?.status == OK) {
                    Resource.Success(
                        response.body()?.let { RESPONSE_TO_DATA_MAPPER.map(it) } ?: MostPopularArticleData()
                    )
                } else {
                    Resource.Error(
                        message = response.message(),
                        code = response.code()
                    )
                }
            } catch (t: Throwable) {
                Resource.Error(message = t.message)
            }
            emit(resource)
        }
}