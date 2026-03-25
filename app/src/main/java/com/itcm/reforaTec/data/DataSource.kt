package com.itcm.reforaTec.data

import com.itcm.reforaTec.R
import com.itcm.reforaTec.model.Tree

class DataSource {

    fun loadTrees(): List<Tree> {
        return listOf(
            Tree(
                id = R.string.first_tree_id,
                value = R.string.first_tree_value,
                commonName = R.string.first_tree_common_name,
                scientificName = R.string.first_tree_scientific_name,
                image = R.drawable.first_tree_image
            ),

            Tree(
                id = R.string.second_tree_id,
                value = R.string.second_tree_value,
                commonName = R.string.second_tree_common_name,
                scientificName = R.string.second_tree_scientific_name,
                image = R.drawable.second_tree_image
            ),

            Tree(
                id = R.string.third_tree_id,
                value = R.string.third_tree_value,
                commonName = R.string.third_tree_common_name,
                scientificName = R.string.third_tree_scientific_name,
                image = R.drawable.first_tree_image
            ),

            Tree(
                id = R.string.fourth_tree_id,
                value = R.string.fourth_tree_value,
                commonName = R.string.fourth_tree_common_name,
                scientificName = R.string.fourth_tree_scientific_name,
                image = R.drawable.second_tree_image
            ),

            Tree(
                id = R.string.fifth_tree_id,
                value = R.string.fifth_tree_value,
                commonName = R.string.fifth_tree_common_name,
                scientificName = R.string.fifth_tree_scientific_name,
                image = R.drawable.first_tree_image
            )
        )
    }
}