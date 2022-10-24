package com.example.nytimes.data.model.response

import com.google.gson.annotations.SerializedName

class MediaMetadata(
    @SerializedName("url")
    val url: String
)