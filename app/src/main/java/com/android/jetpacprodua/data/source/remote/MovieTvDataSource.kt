package com.android.jetpacprodua.data.source.remote

import androidx.lifecycle.LiveData
import com.android.jetpacprodua.data.source.local.entity.MovieKorea
import com.android.jetpacprodua.data.source.local.entity.MovieKoreaDetail
import com.android.jetpacprodua.data.source.local.entity.TvKorea
import com.android.jetpacprodua.data.source.local.entity.TvKoreaDetail

interface MovieTvDataSource {

     fun getMovieKoreaPopular(): LiveData<List<MovieKorea>>

    fun getMovieKoreaDetail(id: Int): LiveData<MovieKoreaDetail>

    fun getTvKoreaPopular(): LiveData<List<TvKorea>>

    fun getDetailTvKorea(id: Int): LiveData<TvKoreaDetail>
}