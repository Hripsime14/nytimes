package com.example.nytimes.data.model.data

import com.example.nytimes.data.model.response.Result

data class MostPopularArticleData (
    val copyright: String = "",
    val num_results: Int = 0,
    val results: List<Result> = emptyList()
)