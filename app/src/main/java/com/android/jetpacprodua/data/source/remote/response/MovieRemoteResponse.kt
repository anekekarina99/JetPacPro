package com.android.jetpacprodua.data.source.remote.response

import android.os.Parcelable
import com.android.jetpacprodua.data.source.local.entity.MovieKorea
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieRemoteResponse(

    @SerializedName("results")
    val hasil: List<MovieKorea>,

    @SerializedName("page")
    val hal: Int,

    @SerializedName("id")
    var id: Int,

    @SerializedName("poster_path")
    var poster: String,

    @SerializedName("overview")
    var overview: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("vote_average")
    var vote_average : Double,



    ) : Parcelable
