package com.example.nytimes.data.repo.di

import com.example.nytimes.data.repo.MostPopularArticlesRepo
import com.example.nytimes.data.repo.repoimpl.MostPopularArticlesRepoImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<MostPopularArticlesRepo> {
        MostPopularArticlesRepoImpl(
            mostPopularArticlesRemoteDataSource = get()
        )
    }
}