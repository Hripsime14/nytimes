package com.example.nytimes.ui.feature.di

import com.example.nytimes.ui.feature.mostpopulararticles.MostPopularArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {

    viewModel {
        MostPopularArticlesViewModel(mostPopularArticlesRepo = get())
    }
}