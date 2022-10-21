package com.example.nytimes.data.model.response

data class MostPopularResponse(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)