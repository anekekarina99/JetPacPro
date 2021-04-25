package com.android.jetpacprodua.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.jetpacprodua.data.source.local.entity.MovieKorea
import com.android.jetpacprodua.data.source.local.entity.TvKorea
import com.android.jetpacprodua.repository.AllRepository

class DetailViewModel(private val allRepository: AllRepository) : ViewModel() {
    private var id: Int? = 0

    fun selectId(id: Int) {
        this.id = id
    }

    fun getMovieKoreaDetail(): LiveData<MovieKorea>? = id?.let {
        allRepository.getMovieKoreaDetail(
            it
        )
    }

    fun getTvKoreaDetail(): LiveData<TvKorea>? = id?.let {
        allRepository.getDetailTvKorea(
            it
        )
    }
}