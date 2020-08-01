package com.example.rxjava3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rxjava3.model.NaverMovieResponse
import kotlinx.android.synthetic.main.item_naver_movie.view.*
class NaverMovieSearchAdapter : ListAdapter<NaverMovieResponse.Item, NaverMovieSearchAdapter.ViewHolder>(object:
DiffUtil.ItemCallback<NaverMovieResponse.Item>() {
    override fun areContentsTheSame(
        oldItem: NaverMovieResponse.Item,
        newItem: NaverMovieResponse.Item
    ): Boolean {
        return oldItem.title == oldItem.title
    }

    override fun areItemsTheSame(
        oldItem: NaverMovieResponse.Item,
        newItem: NaverMovieResponse.Item
    ): Boolean {
        return newItem == oldItem
    }
}){


    /*private var items = mutableListOf<NaverMovieResponse.Item>()*/

/*    fun resetAll(old: List<NaverMovieResponse.Item>) {
        items.clear()
        items.addAll(old)
        notifyDataSetChanged()
    }*/



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent)


    override fun onBindViewHolder(holder: ViewHolder, position: Int)  =
        holder.bind(getItem(position))

    class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_naver_movie, parent, false)
    ) {

        private val ivPoster = itemView.iv_poster
        private val tvTitle = itemView.tv_title
        private val tvSubtitle = itemView.tv_subtitle
        private val tvPubDate = itemView.tv_pub_date
        private val tvActor = itemView.tv_actor

        fun bind(item: NaverMovieResponse.Item) {
            Glide.with(ivPoster)
                .load(item.image)
                .into(ivPoster)

            tvTitle.text = item.title
            tvSubtitle.text = item.subtitle
            tvPubDate.text = item.pubDate
            tvActor.text = item.actor
        }
    }

}