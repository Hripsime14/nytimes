package com.example.nytimes.di

import com.example.nytimes.data.remote.BASE_URL
import com.example.nytimes.data.remote.di.remoteModule
import com.example.nytimes.data.repo.di.repositoryModule
import com.example.nytimes.ui.feature.di.featureModule

val diModule = listOf(
    remoteModule(baseUrl = BASE_URL),
    repositoryModule,
    featureModule
)