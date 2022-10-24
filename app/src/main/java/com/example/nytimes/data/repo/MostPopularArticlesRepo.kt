package com.example.nytimes.data.repo

import com.example.nytimes.data.model.data.MostPopularArticleData
import kotlinx.coroutines.flow.Flow

interface MostPopularArticlesRepo {
    fun getMostPopularArticles(): Flow<Resource<MostPopularArticleData>>
}