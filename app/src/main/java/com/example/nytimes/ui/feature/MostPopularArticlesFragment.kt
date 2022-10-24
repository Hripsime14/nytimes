package com.example.nytimes.ui.feature

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimes.R
import com.example.nytimes.data.repo.Resource
import com.example.nytimes.ui.common.BaseFragment
import com.example.nytimes.ui.extension.hide
import com.example.nytimes.ui.extension.show
import com.example.nytimes.ui.feature.adapter.MostPopularArticlesListAdapter
import com.example.nytimes.ui.feature.mostpopulararticles.MostPopularArticlesViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MostPopularArticlesFragment : BaseFragment(R.layout.fragment_most_popular_articles){
    override val  viewModel: MostPopularArticlesViewModel by viewModel()
    private var recyclerView: RecyclerView? = null
    private var articlesAdapter = MostPopularArticlesListAdapter()
    private var progressBar: ProgressBar? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initRv()
        collectMostWatchedArticleData()
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.rv)
        progressBar = view.findViewById(R.id.registerProgressBar)
    }

    private fun initRv() {
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            hasFixedSize()
            adapter = articlesAdapter
        }
    }

    private fun collectMostWatchedArticleData() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.articleStateFlow.collect {
                    when(it) {
                        is Resource.Success -> {
                            progressBar?.hide()
                            articlesAdapter.submitList(it.data.results)
                        }
                        is Resource.Loading -> {
                            progressBar?.show()
                        }
                        is Resource.Error -> {
                            progressBar?.hide()
                            //showErrorMsg
                        }
                    }
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MostPopularArticlesFragment()

    }
}