package com.android.jetpacprodua.data.source.remote

import android.util.Log
import com.android.jetpacprodua.data.source.remote.api.NetworkConfig
import com.android.jetpacprodua.data.source.remote.response.*
import com.android.jetpacprodua.utils.Constant.Companion.API_KEY
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


    fun getMovieKoreaPopular(callback: MovieKoreaCallback) =//espreso
        NetworkConfig.getApiService().getMoviePopular(API_KEY)
            .enqueue(object : Callback<MovieRemoteResponse> {
                override fun onResponse(
                    call: Call<MovieRemoteResponse>,
                    response: Response<MovieRemoteResponse>
                ) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Korea Berhasil")
                    callback.getMovieKoreaAsync(response.body()?.results)
                    //espreso
                }

                override fun onFailure(call: Call<MovieRemoteResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Korea GAGAL : ${t.message}")
                    //espreso
                }

            })

    fun getTvKoreaPopular(callback: TvKoreaCallback) {
        //espreso
        NetworkConfig.getApiService().getTvList(API_KEY)
            .enqueue(object : Callback<TvRemoteResponse> {
                override fun onResponse(
                    call: Call<TvRemoteResponse>,
                    response: Response<TvRemoteResponse?>
                ) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Korea Berhasil")
                    callback.getTvKoreaAsync(response.body()?.results)
                    //espreso
                }

                override fun onFailure(call: Call<TvRemoteResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Korea GAGAL : ${t.message}")
                    //espreso
                }

            })
    }

    fun getMovieKoreaDetail(callback: MovieKoreaDetailCallback, id: Int) {
        NetworkConfig.getApiService().getMovieDetails(id,API_KEY)
            .enqueue(object : Callback<MovieDetailResponse> {
                override fun onResponse(
                    call: Call<MovieDetailResponse>,
                    response: Response<MovieDetailResponse>
                ) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Detail Korea Berhasil")
                    response.body()?.let { callback.getMovieKoreaDetailAsync(it) }
                    //espreso
                }

                override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Korea GAGAL : ${t.message}")
                    //espreso
                }


            })
    }

   fun getTvKoreaDetail(callback: TvKoreaDetailCallback, id: Int) {
        NetworkConfig.getApiService().getTvDetails(id, API_KEY)
            .enqueue(object : Callback<TvDetailResponse> {
                override fun onResponse(
                    call: Call<TvDetailResponse>,
                    response: Response<TvDetailResponse>
                ) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Detail Korea Berhasil")
                    response.body()?.let { callback.getTvKoreaDetailAsync(it) }
                    //espreso
                }

                override fun onFailure(call: Call<TvDetailResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Korea GAGAL : ${t.message}")
                    //espreso
                }


            })
    }

    interface MovieKoreaCallback {

        fun getMovieKoreaAsync(movieKorea: List<M>?)
    }

    interface MovieKoreaDetailCallback {
        fun getMovieKoreaDetailAsync(movieDetail: MovieDetailResponse) {

        }
    }

    interface TvKoreaCallback {
        fun getTvKoreaAsync(tvKorea: List<T>?) {

        }

    }

    interface TvKoreaDetailCallback {
        fun getTvKoreaDetailAsync(tvDetail: TvDetailResponse) {

        }

    }


}






