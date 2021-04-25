package com.android.jetpacprodua.data.source.remote.response

import android.os.Parcelable
import com.android.jetpacprodua.data.source.local.entity.TvKorea
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvRemoteResponse(
    @SerializedName("results")
    val hasil: List<TvKorea>,

    @SerializedName("page")
    val hal: Int,

    @SerializedName("id")
    var id: Int,

    @SerializedName("poster_path")
    var poster: String,

    @SerializedName("overview")
    var overview: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("vote_average")
    var vote_average : Double,


    ) : Parcelable