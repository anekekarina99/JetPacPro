package com.android.jetpacprodua.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.jetpacprodua.R
import com.android.jetpacprodua.data.source.local.entity.MovieKorea
import com.android.jetpacprodua.databinding.ItemListBinding
import com.android.jetpacprodua.ui.detail.DetailActivity
import com.android.jetpacprodua.utils.Constant.Companion.POSTER_BASE_URL
import com.bumptech.glide.Glide


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var movieK = ArrayList<MovieKorea>()

    fun setMovie(courses: List<MovieKorea>) {
        if (courses.isNotEmpty()) return
            movieK.clear()
            movieK.addAll(courses)
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


    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListBinding.bind(itemView)
        fun bind(movie: MovieKorea) {
            binding.judulItem.text = movie.originalTitle
            binding.populerItem.text = movie.voteAverage.toString()
            Glide.with(itemView.context)
                .load(POSTER_BASE_URL + movie.posterPath)
                .into(binding.imgItem)
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, movie.id)
                itemView.context.startActivity(intent)


            }
        }
    }
}