package com.android.jetpacprodua.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class T (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_count")
    val voteCount: Int,
)