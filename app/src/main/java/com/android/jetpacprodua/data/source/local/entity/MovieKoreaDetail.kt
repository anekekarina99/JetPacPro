package com.android.jetpacprodua.data.source.local.entity

import com.google.gson.annotations.SerializedName

data class MovieKoreaDetail(
    val id: Int,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    @SerializedName("vote_average")
    val rating: Double
)