package com.android.jetpacprodua.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class TvRemoteResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("results")
    val results: List<T>,
    @SerializedName("total_results")
    val totalResults: Int
)