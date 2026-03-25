package com.itcm.reforaTec.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tree(
    @StringRes val id: Int,
    @StringRes val value: Int,
    @StringRes val commonName: Int,
    @StringRes val scientificName: Int,

    @DrawableRes val image: Int,
)