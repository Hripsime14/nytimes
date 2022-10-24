package com.example.nytimes.data.model.response

import com.google.gson.annotations.SerializedName

class MostPopularArticlesResponse(
    @SerializedName("copyright")
    val copyright: String? = null,
    @SerializedName("num_results")
    val num_results: Int? = null,
    @SerializedName("results")
    val results: List<Result>? = null,
    @SerializedName("status")
    val status: String? = null
)