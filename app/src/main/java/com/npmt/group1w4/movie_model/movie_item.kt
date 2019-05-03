package com.npmt.group1w4.movie_model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class movie_item (
    var pic : String = "",
    var title : String = "",
    var overview : String = "",
    var releaseDay : String = "",
    var rating : Float = 0.0f,
    var video : Boolean = false
):Parcelable