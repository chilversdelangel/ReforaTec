package com.itcm.reforaTec.ui.viewmodels

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import com.itcm.reforaTec.data.DataSource
import com.itcm.reforaTec.model.Tree

data class TreeState(
    val servicesCount: Int = 0,
    val historyCount: Int = 0,
    val customValue: String? = null,
    val customCommonName: String? = null
)

class TreeViewModel : ViewModel() {
    val dataSource = DataSource()
    val trees: List<Tree> = dataSource.loadTrees()

    private val treeStates = mutableStateMapOf<Tree, TreeState>()

    fun incrementServices(tree: Tree) {
        val currentState = getTreeState(tree)
        treeStates[tree] = currentState.copy(servicesCount = currentState.servicesCount + 1)
    }

    fun incrementHistory(tree: Tree) {
        val currentState = getTreeState(tree)
        treeStates[tree] = currentState.copy(historyCount = currentState.historyCount + 1)
    }

    fun updateCustomValue(tree: Tree, newValue: String) {
        val currentState = getTreeState(tree)
        treeStates[tree] = currentState.copy(customValue = newValue)
    }

    fun updateCustomCommonName(tree: Tree, name: String){
        val currentState = getTreeState(tree)
        treeStates[tree] = currentState.copy(customCommonName = name)
    }

    fun getTreeState(tree: Tree): TreeState {
        return treeStates.getOrPut(tree) { TreeState() }
    }
}