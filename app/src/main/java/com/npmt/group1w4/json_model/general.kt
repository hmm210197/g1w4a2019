package com.npmt.group1w4.json_model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class general(
    val dates : date_general,
    val page : Int,
    val results : List<movies_info>,
    val total_pages : Int,
    val total_results : Int
):Parcelable