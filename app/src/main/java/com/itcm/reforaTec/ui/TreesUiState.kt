package com.itcm.reforaTec.ui

data class TreeState(
    val id: Int,
    val imageUri: String,
    val commonName: String,
    val scientificName: String,
    val value: String,
    val servicesCount: Int = 0,
)

data class TreesUiState(
    val treeStates: List<TreeState> = emptyList()
)