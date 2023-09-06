package com.farhan.myonepieceapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Crew(
    var name: String,
    var role: String,
    var description: String,
    var photo: String
) : Parcelable