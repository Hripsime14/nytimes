package com.example.nytimes.data.remote.mapper

import com.example.nytimes.data.model.data.MostPopularArticleData
import com.example.nytimes.data.model.response.MostPopularArticlesResponse

val RESPONSE_TO_DATA_MAPPER = object : Mapper<MostPopularArticlesResponse, MostPopularArticleData> {
    override fun map(source: MostPopularArticlesResponse): MostPopularArticleData = source.run {
        MostPopularArticleData(
            copyright.orEmpty(),
            num_results ?: 0,
            results.orEmpty()
        )
    }
}