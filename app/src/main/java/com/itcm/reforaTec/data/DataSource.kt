package com.itcm.reforaTec.data

import com.itcm.reforaTec.R
import com.itcm.reforaTec.model.Tree

class DataSource {

    fun loadTrees(): List<Tree> {
        return listOf(
            Tree(
                value = R.string.first_tree_value,
                commonName = R.string.first_tree_common_name,
                scientificName = R.string.first_tree_scientific_name,
                image = R.drawable.first_tree_image
            ),

            Tree(
                value = R.string.second_tree_value,
                commonName = R.string.second_tree_common_name,
                scientificName = R.string.second_tree_scientific_name,
                image = R.drawable.second_tree_image
            )
        )
    }
}