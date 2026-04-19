package com.itcm.reforaTec.ui

import androidx.lifecycle.ViewModel
import com.itcm.reforaTec.data.DataSource
import com.itcm.reforaTec.model.Tree
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TreesViewModel(
    private val dataSource: DataSource = DataSource()
) : ViewModel() {
    private val _treesUiState = MutableStateFlow(TreesUiState())
    val treesUiState: StateFlow<TreesUiState> = _treesUiState.asStateFlow()

    init {
        fetchInitialData()
    }

    private fun fetchInitialData() {
        val trees: List<Tree> = dataSource.loadTrees()

        val treesWithState = trees.map { tree ->
            TreeState(
                id = tree.id,
                imageUri = tree.imageUri,
                commonName = tree.commonName,
                scientificName = tree.scientificName,
                value = tree.value,
                servicesCount = 0,
                historyCount = 0
            )
        }

        _treesUiState.value = TreesUiState(treeStates = treesWithState)
    }
}