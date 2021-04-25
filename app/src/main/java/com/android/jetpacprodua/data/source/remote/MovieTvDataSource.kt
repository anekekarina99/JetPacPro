package com.android.jetpacprodua.data.source.remote

import androidx.lifecycle.LiveData
import com.android.jetpacprodua.data.source.local.entity.MovieKorea
import com.android.jetpacprodua.data.source.local.entity.TvKorea

interface MovieTvDataSource {

    fun getMovieKoreaPopular(): LiveData<List<MovieKorea>>

    fun getMovieKoreaDetail(id: Int): LiveData<MovieKorea>

    fun getTvKoreaPopular(): LiveData<List<TvKorea>>

    fun getDetailTvKorea(id: Int): LiveData<TvKorea>
}