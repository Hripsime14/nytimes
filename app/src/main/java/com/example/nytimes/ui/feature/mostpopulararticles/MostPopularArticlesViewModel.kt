package com.example.nytimes.ui.feature.mostpopulararticles

import androidx.lifecycle.viewModelScope
import com.example.nytimes.data.model.data.MostPopularArticleData
import com.example.nytimes.data.repo.MostPopularArticlesRepo
import com.example.nytimes.data.repo.Resource
import com.example.nytimes.ui.common.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MostPopularArticlesViewModel(
        private val mostPopularArticlesRepo: MostPopularArticlesRepo
    ): BaseViewModel() {

    private val _articleStateFlow = MutableStateFlow<Resource<MostPopularArticleData>?>(null)
    val articleStateFlow: StateFlow<Resource<MostPopularArticleData>?> = _articleStateFlow

    init {
        getMostPopularArticles()
    }

    private fun getMostPopularArticles() {
        viewModelScope.launch(Dispatchers.IO) {
            mostPopularArticlesRepo.getMostPopularArticles().collect{
                _articleStateFlow.emit(it)
            }
        }
    }
}