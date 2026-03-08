package com.itcm.reforaTec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.itcm.reforaTec.model.TreeType
import com.itcm.reforaTec.ui.screens.TreeScreen
import com.itcm.reforaTec.ui.theme.ArbolTypeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val treeType = TreeType(
                commonName = "miArbolito",
                scientificName = "Roble",
                description = "Mi arbolito es bonito.",
                image = R.drawable.tree
            )

            ArbolTypeTheme {
                TreeScreen(treeType)
            }
        }
    }
}