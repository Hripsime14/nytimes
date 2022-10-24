package com.example.nytimes.ui.feature.adapter

import com.example.nytimes.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.nytimes.data.model.response.Result
import com.example.nytimes.ui.extension.hide
import com.example.nytimes.ui.extension.show
import kotlinx.coroutines.FlowPreview

class MostPopularArticlesListAdapter: ListAdapter<Result, MostPopularArticlesListAdapter.ViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.article_single_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentArticle = currentList[position]
        holder.bind(currentArticle)
    }

    @FlowPreview
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var title: TextView? = null
        private var date: TextView? = null
        private var author: TextView? = null
        private var image: ImageView? = null

        init {
            initViews()
            handleItemClick()
        }

        private fun initViews() {
            title = itemView.findViewById(R.id.title)
            date = itemView.findViewById(R.id.date)
            author = itemView.findViewById(R.id.author)
            image = itemView.findViewById(R.id.image)
        }

        private fun handleItemClick() {
            itemView.setOnClickListener {
                if (author?.visibility != View.VISIBLE) {
                    author?.show()
                    date?.show()
                } else {
                    author?.hide()
                    date?.hide()
                }
            }
        }

        fun bind(currentArticle: Result)  {
            title?.text = currentArticle.title
            date?.text = currentArticle.published_date
            author?.text = currentArticle.byline
            val options: RequestOptions = RequestOptions()
                .circleCrop()
                .placeholder(R.mipmap.ic_launcher_round)

            image?.let { Glide.with(it).load(currentArticle.media[0].mediaMetadataList[0].url).apply(options).into(image!!) }
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean =
            oldItem.hashCode() == newItem.hashCode()
    }
}