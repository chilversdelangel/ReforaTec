package com.itcm.reforaTec.ui

data class TreeState(
    val id: String,
    val imageUri: String,
    val commonName: String,
    val scientificName: String,
    val value: String,
    val servicesCount: Int = 0,
    val historyCount: Int = 0,
)

data class TreesUiState(
    val treeStates: List<TreeState> = emptyList()
)