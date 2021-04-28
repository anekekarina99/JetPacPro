package com.android.jetpacprodua.data.source.remote.api


import com.android.jetpacprodua.data.source.remote.response.MovieRemoteResponse
import com.android.jetpacprodua.data.source.remote.response.TvRemoteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular?api_key=5829da11901d652c0ebdcb4c5bfa7015&language=en-UK&page=1&region=KR")
    fun getMovieKoreaPopular(
    ): Call<MovieRemoteResponse>

    @GET("movie/{id}?api_key=5829da11901d652c0ebdcb4c5bfa7015&language=en-UK")
    fun getMovieKoreaDetail(
        @Path("id") id: Int,
    ): Call<MovieRemoteResponse>

    @GET("tv/popular?api_key=5829da11901d652c0ebdcb4c5bfa7015&language=en-UK&page=1&region=KR")
    fun getTvKoreaPopular(
    ): Call<TvRemoteResponse>

    @GET("tv/{id}?api_key=5829da11901d652c0ebdcb4c5bfa7015&language=en-UK")
    fun getTvKoreaDetail(
        @Path("id") id: Int,
    ): Call<TvRemoteResponse>
}