package com.android.jetpacprodua.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.jetpacprodua.R
import com.android.jetpacprodua.data.source.local.entity.MovieKorea
import com.android.jetpacprodua.databinding.ItemListBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var movieK = ArrayList<MovieKorea>()

    fun setMovie(courses: List<MovieKorea>) {
        if (movieK.isNullOrEmpty()) return
        this.movieK.clear()
        this.movieK.addAll(courses)
    }

    private var onItemClickCallback: OnItemClickCallback? = null


    interface OnItemClickCallback {
        fun onItemClicked(data: MovieKorea)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MovieViewHolder(mView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieK[position])
    }

    override fun getItemCount() = movieK.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback

    }


    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListBinding.bind(itemView)
        fun bind(movie: MovieKorea) {
            itemView.setOnClickListener {
                binding.judulItem.text = movie.title
                binding.populerItem.text = movie.vote_average.toString()
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500"+movie.poster_path)
                    .apply(RequestOptions().override(600, 200))
                    .into(binding.imgItem)
                onItemClickCallback?.onItemClicked(movie)

            }
        }
    }
}