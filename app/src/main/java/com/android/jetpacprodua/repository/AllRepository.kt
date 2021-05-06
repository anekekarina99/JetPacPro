package com.android.jetpacprodua.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.jetpacprodua.data.source.local.entity.MovieKorea
import com.android.jetpacprodua.data.source.local.entity.MovieKoreaDetail
import com.android.jetpacprodua.data.source.local.entity.TvKorea
import com.android.jetpacprodua.data.source.local.entity.TvKoreaDetail
import com.android.jetpacprodua.data.source.remote.MovieTvDataSource
import com.android.jetpacprodua.data.source.remote.RemoteDataSource
import com.android.jetpacprodua.data.source.remote.response.M
import com.android.jetpacprodua.data.source.remote.response.MovieDetailResponse
import com.android.jetpacprodua.data.source.remote.response.T
import com.android.jetpacprodua.data.source.remote.response.TvDetailResponse


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
        remoteDataSource.getMovieKoreaPopular(callback = object : RemoteDataSource.MovieKoreaCallback {
            override fun getMovieKoreaAsync(movieKorea: List<M>?) {
                val movieL = ArrayList<MovieKorea>()
                if (movieKorea != null) {
                    for (movieRes in movieKorea) {
                        val movie = movieRes.let {
                            MovieKorea(
                                it.id,
                                it.title,
                                it.overview,
                                it.popularity,
                                it.posterPath,
                                it.voteAverage,
                                it.voteCount,
                            )
                        }
                        movieL.add(movie)
                    }
                }
                movieKoreaResult.postValue(movieL)
            }

        })
        return movieKoreaResult
    }

    override fun getMovieKoreaDetail(id: Int): LiveData<MovieKoreaDetail> {
        val movieKdetail = MutableLiveData<MovieKoreaDetail>()
        remoteDataSource.getMovieKoreaDetail(object : RemoteDataSource.MovieKoreaDetailCallback {
            override fun getMovieKoreaDetailAsync(movieDetail: MovieDetailResponse) {

                val detMov = movieDetail.let {
                    MovieKoreaDetail(
                        it.id,
                        it.overview,
                        it.popularity,
                        it.posterPath,
                        it.releaseDate,
                        it.title,
                        it.rating
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
            override fun getTvKoreaAsync(tvKorea: List<T>?) {
                val tvL = ArrayList<TvKorea>()
                if (tvKorea != null) {
                    for (tvRes in tvKorea) {
                        val tv = tvRes.let {
                            TvKorea(
                                it.id,
                                it.name,
                                it.overview,
                                it.popularity,
                                it.posterPath,
                                it.voteCount
                            )
                        }
                        tvL.add(tv)
                    }
                    tvKoreaResult.postValue(tvL)
                }
            }

        })
        return tvKoreaResult
    }

    override fun getDetailTvKorea(id: Int): LiveData<TvKoreaDetail> {
        val tvKdetail = MutableLiveData<TvKoreaDetail>()
        remoteDataSource.getTvKoreaDetail(object : RemoteDataSource.TvKoreaDetailCallback {
            override fun getTvKoreaDetailAsync(tvDetail: TvDetailResponse) {

                val detTv = tvDetail.let {
                    TvKoreaDetail(
                        it.id,
                        it.name,
                        it.overview,
                        it.popularity,
                        it.posterPath,
                        it.voteCount,
                    )
                }
                tvKdetail.postValue(detTv)
            }

        }, id)
        return tvKdetail
    }

}