package com.npmt.group1w4.json_model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class date_general(
    val maximun : String,
    val minimum : String
): Parcelable