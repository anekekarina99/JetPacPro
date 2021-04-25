package com.android.jetpacprodua.ui.tv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.jetpacprodua.R
import com.android.jetpacprodua.data.source.local.entity.TvKorea
import com.android.jetpacprodua.databinding.ItemListBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TvAdapter : RecyclerView.Adapter<TvAdapter.TvViewHolder>() {
    private var tvK = ArrayList<TvKorea>()

    fun setTv(courses: List<TvKorea>) {
        if (tvK.isNullOrEmpty()) return
        this.tvK.clear()
        this.tvK.addAll(courses)
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TvKorea)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return TvViewHolder(mView)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        holder.bind(tvK[position])
    }

    override fun getItemCount() = tvK.size

    inner class TvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListBinding.bind(itemView)
        fun bind(tv: TvKorea) {
            itemView.setOnClickListener {
                binding.judulItem.text = tv.name
                binding.populerItem.text = tv.vote_average.toString()
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500"+tv.poster_path)
                    .apply(RequestOptions())
                    .into(binding.imgItem)

                onItemClickCallback?.onItemClicked(tv)

            }
        }
    }
}