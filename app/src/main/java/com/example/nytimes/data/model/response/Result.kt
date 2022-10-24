package com.example.nytimes.data.model.response

import com.google.gson.annotations.SerializedName

class Result(
    @SerializedName("id")
    val id: Long,
    @SerializedName("byline")
    val byline: String,
    @SerializedName("media")
    val media: List<Media>,
    @SerializedName("published_date")
    val published_date: String,
    @SerializedName("title")
    val title: String
)