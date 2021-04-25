package com.android.jetpacprodua.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.jetpacprodua.data.source.local.entity.MovieKorea
import com.android.jetpacprodua.data.source.local.entity.TvKorea
import com.android.jetpacprodua.data.source.remote.MovieTvDataSource
import com.android.jetpacprodua.data.source.remote.RemoteDataSource
import com.android.jetpacprodua.data.source.remote.response.MovieRemoteResponse
import com.android.jetpacprodua.data.source.remote.response.TvRemoteResponse


class AllRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieTvDataSource {

    companion object {
        @Volatile
        private var instance: AllRepository? = null

        fun getInstance(remoteData: RemoteDataSource): AllRepository =
            instance ?: synchronized(this) {
                instance ?: AllRepository(remoteData).apply { instance = this }
            }
    }

    override fun getMovieKoreaPopular(): LiveData<List<MovieKorea>> {
        val movieKoreaResult = MutableLiveData<List<MovieKorea>>()
        remoteDataSource.getMovieKoreaPopular(object : RemoteDataSource.MovieKoreaCallback {
            override fun getMovieKoreaAsync(movieKorea: List<MovieKorea>?) {
                val movieL = ArrayList<MovieKorea>()
                for (movieRes in movieL) {
                    val movie = movieRes.let {
                        MovieKorea(
                            it.id,
                            it.poster_path,
                            it.overview,
                            it.title,
                            it.vote_average
                        )
                    }
                    movieL.add(movie)
                }
                movieKoreaResult.postValue(movieL)
            }

        })
        return movieKoreaResult
    }

    override fun getMovieKoreaDetail(id: Int): LiveData<MovieKorea> {
        val movieKdetail = MutableLiveData<MovieKorea>()
        remoteDataSource.getMovieKoreaDetail(object : RemoteDataSource.MovieKoreaDetailCallback {
            override fun getMovieKoreaDetailAsync(movieDetail: MovieRemoteResponse?) {

                val detMov = movieDetail?.let {
                    MovieKorea(
                        it.id,
                        it.poster,
                        it.overview,
                        it.title,
                        it.vote_average
                    )
                }
                movieKdetail.postValue(detMov)
            }

        }, id)
        return movieKdetail
    }


    override fun getTvKoreaPopular(): LiveData<List<TvKorea>> {
        val tvKoreaResult = MutableLiveData<List<TvKorea>>()
        remoteDataSource.getTvKoreaPopular(object : RemoteDataSource.TvKoreaCallback {
            override fun getTvKoreaAsync(tvKorea: List<TvKorea>?) {
                val tvL = ArrayList<TvKorea>()
                for (tvRes in tvL) {
                    val tv = tvRes.let {
                        TvKorea(
                            it.id,
                            it.poster_path,
                            it.overview,
                            it.name,
                            it.vote_average
                        )
                    }
                    tvL.add(tv)
                }
                tvKoreaResult.postValue(tvL)
            }

        })
        return tvKoreaResult
    }

    override fun getDetailTvKorea(id: Int): LiveData<TvKorea> {
        val tvKdetail = MutableLiveData<TvKorea>()
        remoteDataSource.getTvKoreaDetail(object : RemoteDataSource.TvKoreaDetailCallback {
            override fun getTvKoreaDetailAsync(tvDetail: TvRemoteResponse?) {

                val detTv = tvDetail?.let {
                    TvKorea(
                        it.id,
                        it.poster,
                        it.overview,
                        it.name,
                        it.vote_average
                    )
                }
                tvKdetail.postValue(detTv)
            }

        }, id)
        return tvKdetail
    }

}