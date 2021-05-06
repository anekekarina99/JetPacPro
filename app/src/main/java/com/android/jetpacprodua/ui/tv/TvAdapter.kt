package com.android.jetpacprodua.ui.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.jetpacprodua.R
import com.android.jetpacprodua.data.source.local.entity.TvKorea
import com.android.jetpacprodua.databinding.ItemListBinding
import com.android.jetpacprodua.ui.detail.DetailTvActivity
import com.android.jetpacprodua.utils.Constant
import com.bumptech.glide.Glide

class TvAdapter : RecyclerView.Adapter<TvAdapter.TvViewHolder>() {
    private var tvK = ArrayList<TvKorea>()

   fun setTv(courses: List<TvKorea>) {
     if (courses.isNotEmpty()) return
      tvK.clear()
     tvK.addAll(courses)

   }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val mView : View =
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
            binding.judulItem.text = tv.name
            binding.populerItem.text = tv.voteCount.toString()
            Glide.with(itemView.context)
                .load(Constant.POSTER_BASE_URL +tv.posterPath)
                .into(binding.imgItem)
            itemView.setOnClickListener {


                val intent = Intent(itemView.context, DetailTvActivity::class.java)
                intent.putExtra(DetailTvActivity.EXTRA_DATA, tv.id)
                itemView.context.startActivity(intent)

            }
        }
    }
}