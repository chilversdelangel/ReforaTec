@file:OptIn(ExperimentalMaterial3Api::class)

package com.itcm.reforaTec.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.itcm.reforaTec.R

@Composable
fun TreesScreen(
    treesViewModel: TreesViewModel = viewModel()
) {
    val uiState by treesViewModel.treesUiState.collectAsState()

    Scaffold(
        topBar = { TreesTopAppBar() },
        bottomBar = { TreesBottomAppBar() }
    ) { innerPadding ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(paddingValues = innerPadding)
                .padding(16.dp)
        ) {
            items(uiState.treeStates) { treeState ->
                TreeCard(state = treeState)
            }
        }
    }
}

@Composable
fun TreesTopAppBar() {
    TopAppBar(
        title = { Text("Especie") })
}

@Composable
fun TreesBottomAppBar() {
    BottomAppBar(
        Modifier.padding(16.dp)
    ) {
        Text("BottomAppBar de demostración.")
    }
}

@Composable
fun TreeCard(state: TreeState) {
    Card(
        Modifier.fillMaxWidth()
    ) {
        Column(Modifier.padding(16.dp)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TreeCardImage(state.imageUri)

                    TreeCardDetails(
                        commonName = state.commonName,
                        value = state.value,
                        scientificName = state.scientificName
                    )
                }
                Text(
                    text = "ID: ${state.id}",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.align(Alignment.TopEnd)
                )
            }
        }
        TreeCardButtons()
    }
}

@Composable
fun TreeCardButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Button(onClick = {}) { Text("Servicio") }
        Button(onClick = {}) { Text("Historial") }
        Button(onClick = {}) { Text("Más") }
    }
}

@Composable
fun TreeCardImage(
    uri: String
) {
    AsyncImage(
        model = uri,
        contentDescription = "Imagen del árbol.",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(100.dp)
            .padding(end = 16.dp),
        error = painterResource(id = R.drawable.first_tree_image)
    )
}

@Composable
fun TreeCardDetails(
    commonName: String,
    value: String,
    scientificName: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            commonName,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(value)
        Spacer(modifier = Modifier.height(8.dp))

        Text(scientificName)
        Spacer(modifier = Modifier.height(8.dp))
    }
}