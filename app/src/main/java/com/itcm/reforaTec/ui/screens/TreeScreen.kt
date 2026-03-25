@file:OptIn(ExperimentalMaterial3Api::class)

package com.itcm.reforaTec.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itcm.reforaTec.model.Tree
import com.itcm.reforaTec.ui.viewmodels.TreeViewModel

@Composable
fun TreeScreen(viewModel: TreeViewModel = viewModel()) {
    Scaffold(
        topBar = { TreeTopAppBar() },
        bottomBar = { TreeBottomAppBar() }
    ) { innerPadding ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(paddingValues = innerPadding)
                .padding(16.dp)
        ) {
            items(viewModel.trees) { tree ->
                TreeCard(tree)
            }
        }
    }
}

@Composable
fun TreeTopAppBar() {
    TopAppBar(
        title = { Text("Especie") }
    )
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
fun TreeCard(tree: Tree) {

    Card(Modifier.fillMaxWidth()) {

        Column {

            Column(Modifier.padding(16.dp)) {

                Box(modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painterResource(id = tree.image),
                            contentDescription = "Imagen del árbol.",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(100.dp)
                                .padding(end = 16.dp)
                        )

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                stringResource(id = tree.commonName),
                                style = MaterialTheme.typography.titleLarge
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            Text(stringResource(id = tree.value))
                            Spacer(modifier = Modifier.height(8.dp))

                            Text(stringResource(id = tree.scientificName))
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }

                    Text(
                        stringResource(id = tree.id),
                        modifier = Modifier.align(Alignment.TopEnd)
                    )
                }
            }

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
    }
}