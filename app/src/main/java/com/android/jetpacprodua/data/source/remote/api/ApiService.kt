package com.android.jetpacprodua.data.source.remote.api


import com.android.jetpacprodua.data.source.remote.response.MovieDetailResponse
import com.android.jetpacprodua.data.source.remote.response.MovieRemoteResponse
import com.android.jetpacprodua.data.source.remote.response.TvDetailResponse
import com.android.jetpacprodua.data.source.remote.response.TvRemoteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getMoviePopular(
        @Query("api_key") apiKey: String,
    ): Call<MovieRemoteResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String
    ): Call<MovieDetailResponse>

    @GET("tv/{tv_id}")
     fun getTvDetails(@Path("tv_id") id: Int, @Query("api_key") apiKey: String): Call<TvDetailResponse>

    @GET("tv/popular")
    fun getTvList(
        @Query("api_key") apiKey: String
    ): Call<TvRemoteResponse>

}