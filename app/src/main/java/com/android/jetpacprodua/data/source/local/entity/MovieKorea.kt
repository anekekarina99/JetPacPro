package com.android.jetpacprodua.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieKorea(
    var id: Int,
    var poster_path: String,
    var overview: String,
    var title: String,
    var vote_average: Double,
): Parcelable