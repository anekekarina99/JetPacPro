package com.android.jetpacprodua.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.jetpacprodua.data.source.local.entity.MovieKoreaDetail
import com.android.jetpacprodua.data.source.local.entity.TvKoreaDetail
import com.android.jetpacprodua.repository.AllRepository

class DetailViewModel(private val allRepository: AllRepository) : ViewModel() {
    private var id: Int? = 0

    fun selectId(id: Int) {
        this.id = id
    }

    fun getMovieKoreaDetail(): LiveData<MovieKoreaDetail>? = id?.let {
        allRepository.getMovieKoreaDetail(
            it
        )
    }

    fun getTvKoreaDetail(): LiveData<TvKoreaDetail>? = id?.let {
        allRepository.getDetailTvKorea(
            it
        )
    }
}