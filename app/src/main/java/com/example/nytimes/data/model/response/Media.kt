package com.example.nytimes.data.model.response

import com.google.gson.annotations.SerializedName

class Media(
    @SerializedName("media-metadata")
    val mediaMetadataList: List<MediaMetadata>
)