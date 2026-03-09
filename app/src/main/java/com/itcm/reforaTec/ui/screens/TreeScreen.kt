@file:OptIn(ExperimentalMaterial3Api::class)

package com.itcm.reforaTec.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.itcm.reforaTec.model.Tree

@Composable
fun TreeScreen(
    tree: Tree
) {
    var servicesCount by remember { mutableIntStateOf(value = 0) }
    var historyCount by remember { mutableIntStateOf(value = 0) }

    Scaffold(topBar = { TreeTopAppBar() }, bottomBar = { TreeBottomAppBar() }) { innerPadding ->
        Column(
            modifier = Modifier.padding(paddingValues = innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TreeTypeCard(
                tree = tree,
                modifier = Modifier.padding(16.dp),
                servicesCount = servicesCount,
                historyCount = historyCount,
                setServicesCount = { servicesCount++ },
                setHistoryCount = { historyCount++ })
        }
    }
}

@Composable
fun TreeTopAppBar() {
    TopAppBar(
        title = { Text("Especie") })
}

@Composable
fun TreeBottomAppBar() {
    BottomAppBar(
        Modifier.padding(16.dp)
    ) {
        Text("BottomAppBar de demostración.")
    }
}

@Composable
fun TreeTypeCard(
    tree: Tree,
    modifier: Modifier = Modifier,
    servicesCount: Int,
    historyCount: Int,
    setServicesCount: () -> Unit,
    setHistoryCount: () -> Unit
) {
    Card(
        modifier = modifier
    ) {
        Column(
            Modifier.padding(16.dp)
        ) {
            Text(
                "Nombre común: ${tree.commonName}",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text("Nombre científico: ${tree.scientificName}")
            Spacer(modifier = Modifier.height(8.dp))

            Text("Descripción: ${tree.description}")
            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painterResource(id = tree.image),
                contentDescription = "Imagen del árbol.",
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = setServicesCount) {
                        Text("Servicios")
                    }
                    Text(servicesCount.toString())
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = setHistoryCount) {
                        Text("Historial")
                    }
                    Text(historyCount.toString())
                }
            }
        }
    }
}