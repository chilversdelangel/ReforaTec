package com.itcm.reforaTec.data

import com.itcm.reforaTec.model.Tree

class DataSource {

    fun loadTrees(): List<Tree> {
        return listOf(
            Tree(
                id = 1,
                imageUri = "https://caraghnurseries.ie/wp-content/uploads/2024/08/Pinus-strobus-Fastigiata-2-scaled.jpg",
                commonName = "Pino Blanco",
                scientificName = "Pinus strobus",
                value = "Honestidad"
            ),
            Tree(
                id = 2,
                imageUri = "https://caraghnurseries.ie/wp-content/uploads/2017/10/quercus-robur.jpg",
                commonName = "Roble Común",
                scientificName = "Quercus robur",
                value = "Perseverancia"
            ),
            Tree(
                id = 3,
                imageUri = "https://ecosdelbosque.com/sites/default/files/2023-11/Cedrela_odorata_01.jpg",
                commonName = "Cedro Rojo",
                scientificName = "Cedrela odorata",
                value = "Respeto"
            )
        )
    }
}