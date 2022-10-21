package com.example.nytimes.data.model.response

import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("approved_for_syndication")
    val approvedForSyndication: Int,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("subtype")
    val subtype: String,
    @SerializedName("type")
    val type: String
)