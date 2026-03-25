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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import com.itcm.reforaTec.ui.viewmodels.TreeState
import com.itcm.reforaTec.ui.viewmodels.TreeViewModel

@Composable
fun TreeScreen(
    viewModel: TreeViewModel = viewModel()
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = { TreeTopAppBar() },
        bottomBar = { TreeBottomAppBar() })
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(paddingValues = innerPadding)
                .verticalScroll(scrollState)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            viewModel.trees.forEach { tree ->
                val state = viewModel.getTreeState(tree)

                TreeCard(
                    tree = tree,
                    state = state,
                    setServicesCount = { viewModel.incrementServices(tree) },
                    setHistoryCount = { viewModel.incrementHistory(tree) },
                    onValueChange = { newValue ->
                        viewModel.updateCustomValue(
                            tree, newValue
                        ) },
                    onCommonNameChange = { newName ->
                        viewModel.updateCustomCommonName(
                            tree, newName
                        ) },
                )

                Text("Valor: ${state.customValue}")
                Text("Nombre común: ${state.customCommonName}")
                Text("Contador de servicios: ${state.servicesCount}")
                Text("Contador de historial: ${state.historyCount}")
            }
        }
    }
}

@Composable
fun TreeTopAppBar() {
    TopAppBar(title = { Text("Especie") })
}

@Composable
fun TreeBottomAppBar() {
    BottomAppBar(Modifier.padding(16.dp)) {
        Text("BottomAppBar de demostración.")
    }
}

@Composable
fun TreeCard(
    tree: Tree,
    modifier: Modifier = Modifier,
    state: TreeState,
    setServicesCount: () -> Unit,
    setHistoryCount: () -> Unit,
    onValueChange: (String) -> Unit,
    onCommonNameChange: (String) -> Unit
) {
    Card(modifier = modifier) {
        Column(Modifier.padding(16.dp)) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painterResource(id = tree.image),
                    contentDescription = "Imagen del árbol.",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(end = 16.dp),
                    contentScale = ContentScale.Crop
                )

                Column {
                    val currentValue = state.customValue ?: stringResource(tree.value)
                    val currentCommonName = state.customCommonName ?: stringResource(tree.commonName)

                    OutlinedTextField(
                        value = currentValue,
                        onValueChange = onValueChange,
                        label = { Text("Valor:") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = currentCommonName,
                        onValueChange = onCommonNameChange,
                        label = { Text("Nombre común:") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text("Nombre científico:")
                    Text(stringResource(id = tree.scientificName))
                    Spacer(modifier = Modifier.height(8.dp))
                }

            }

            TreeCounters(state.servicesCount, state.historyCount, setServicesCount, setHistoryCount)
        }
    }
}

@Composable
fun TreeCounters(
    servicesCount: Int, historyCount: Int, setServicesCount: () -> Unit, setHistoryCount: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = setServicesCount) { Text("Servicios") }
            // Text(servicesCount.toString())
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = setHistoryCount) { Text("Historial") }
            // Text(historyCount.toString())
        }

        Button({}) { Text("Más") }
    }
}