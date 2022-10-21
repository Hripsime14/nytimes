package com.example.nytimes.di

import com.example.nytimes.data.remote.BASE_URL
import com.example.nytimes.data.remote.di.remoteModule

val diModule = listOf(
    remoteModule(baseUrl = BASE_URL)
)