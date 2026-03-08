package com.itcm.reforaTec.model

import androidx.annotation.DrawableRes

data class TreeType(
    var commonName: String,
    val scientificName: String,
    val description: String,

    @DrawableRes val image: Int,
)