package com.android.jetpacprodua.data.source.remote.api


import com.android.jetpacprodua.data.source.remote.response.MovieRemoteResponse
import com.android.jetpacprodua.data.source.remote.response.TvRemoteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("3/movie/popular")
    fun getMovieKoreaPopular(
        @Query("api_key") apiKey : String = "5829da11901d652c0ebdcb4c5bfa7015",
        @Query("language") language: String = "en-UK",
        @Query("page") page : Int = 1,
        @Query("region") region : String = "KR"
    ): Call<MovieRemoteResponse>

    @GET("3/movie/{id}")
    fun getMovieKoreaDetail(
        @Path("id") id: Int,
        @Query("api_key") apiKey : String = "5829da11901d652c0ebdcb4c5bfa7015",
        @Query("language") language: String = "en-UK"
    ): Call<MovieRemoteResponse>

    @GET("3/tv/popular")
    fun getTvKoreaPopular(
        @Query("api_key") apiKey : String = "5829da11901d652c0ebdcb4c5bfa7015",
        @Query("language") language: String = "en-UK",
        @Query("page") page : Int = 1,
        @Query("region") region : String = "KR"
    ): Call<TvRemoteResponse>

    @GET("3/tv/{id}")
    fun getTvKoreaDetail(
        @Path("id") id: Int,
        @Query("api_key") apiKey : String = "5829da11901d652c0ebdcb4c5bfa7015",
        @Query("language") language: String = "en-UK"
    ): Call<TvRemoteResponse>
}