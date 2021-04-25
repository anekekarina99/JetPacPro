package com.android.jetpacprodua.data.source.remote

import android.util.Log
import com.android.jetpacprodua.data.source.local.entity.MovieKorea
import com.android.jetpacprodua.data.source.local.entity.TvKorea
import com.android.jetpacprodua.data.source.remote.api.NetworkConfig
import com.android.jetpacprodua.data.source.remote.response.MovieRemoteResponse
import com.android.jetpacprodua.data.source.remote.response.TvRemoteResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {
        @Volatile
        private var inst: RemoteDataSource? = null

        fun getInst(): RemoteDataSource =
            inst ?: synchronized(this) {
                inst ?: RemoteDataSource()
            }
    }


    fun getMovieKoreaPopular(callback: MovieKoreaCallback) {
        //espreso
        NetworkConfig.getApiService().getMovieKoreaPopular()
            .enqueue(object : Callback<MovieRemoteResponse> {
                override fun onResponse(
                    call: Call<MovieRemoteResponse>,
                    response: Response<MovieRemoteResponse>
                ) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Korea Berhasil")
                    callback.getMovieKoreaAsync(response.body()?.hasil)
                    //espreso
                }

                override fun onFailure(call: Call<MovieRemoteResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Korea GAGAL : ${t.message}")
                    //espreso
                }

            })
    }

    fun getTvKoreaPopular(callbackTv: TvKoreaCallback) {
        //espreso
        NetworkConfig.getApiService().getTvKoreaPopular()
            .enqueue(object : Callback<TvRemoteResponse> {
                override fun onResponse(
                    call: Call<TvRemoteResponse>,
                    response: Response<TvRemoteResponse?>
                ) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Korea Berhasil")
                    callbackTv.getTvKoreaAsync(response.body()?.hasil)
                    //espreso
                }

                override fun onFailure(call: Call<TvRemoteResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Korea GAGAL : ${t.message}")
                    //espreso
                }

            })
    }

    fun getMovieKoreaDetail(callbackMovieDetail: MovieKoreaDetailCallback, id: Int) {
        NetworkConfig.getApiService().getMovieKoreaDetail(id)
            .enqueue(object : Callback<MovieRemoteResponse> {
                override fun onResponse(
                    call: Call<MovieRemoteResponse>,
                    response: Response<MovieRemoteResponse>
                ) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Detail Korea Berhasil")
                    response.body()?.let { callbackMovieDetail.getMovieKoreaDetailAsync(it) }
                    //espreso
                }

                override fun onFailure(call: Call<MovieRemoteResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Korea GAGAL : ${t.message}")
                    //espreso
                }


            })
    }

    fun getTvKoreaDetail(callbackTvDetail: TvKoreaDetailCallback, id: Int) {
        NetworkConfig.getApiService().getTvKoreaDetail(id)
            .enqueue(object : Callback<TvRemoteResponse> {
                override fun onResponse(
                    call: Call<TvRemoteResponse>,
                    response: Response<TvRemoteResponse>
                ) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Detail Korea Berhasil")
                    response.body()?.let { callbackTvDetail.getTvKoreaDetailAsync(it) }
                    //espreso
                }

                override fun onFailure(call: Call<TvRemoteResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Korea GAGAL : ${t.message}")
                    //espreso
                }


            })
    }

    interface MovieKoreaCallback {

        fun getMovieKoreaAsync(movieKorea: List<MovieKorea>?)
    }

    interface MovieKoreaDetailCallback {
        fun getMovieKoreaDetailAsync(movieDetail: MovieRemoteResponse?) {

        }
    }

    interface TvKoreaCallback {
        fun getTvKoreaAsync(tvKorea: List<TvKorea>?) {

        }

    }

    interface TvKoreaDetailCallback {
        fun getTvKoreaDetailAsync(tvDetail: TvRemoteResponse?) {

        }

    }


}






