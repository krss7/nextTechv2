package com.example.NextTech.myComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Un Composable que muestra una barra de búsqueda.
 *
 * @param query El texto actual de la búsqueda.
 * @param onQueryChange Acción a ejecutar cuando el texto cambia.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Buscador(
    query: String = "",
    onQueryChange: (String) -> Unit = {}
){
    var internalQuery by remember { mutableStateOf(query) }
    // Sincronizamos si cambia desde fuera (opcional, pero útil para resetear)
    val displayQuery = if (query.isEmpty() && internalQuery.isNotEmpty()) internalQuery else query

    var expanded by remember { mutableStateOf(false) }

    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = query,
                onQueryChange = onQueryChange,
                onSearch = { expanded = false },
                expanded = expanded,
                onExpandedChange = { expanded = it },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                trailingIcon = {
                    if (query.isNotEmpty()) {
                        IconButton(onClick = { onQueryChange("") }) {
                            Icon(Icons.Default.Close, contentDescription = "Clear search")
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        },
        expanded = expanded,
        onExpandedChange = { expanded = it },
        modifier = Modifier.fillMaxWidth()
    ) {
        if (query.isNotEmpty()) {
            Text("Buscando: $query", modifier = Modifier.padding(16.dp))
        }
    }
}

@Preview
@Composable
fun BuscadorPreview(){
    Buscador()
}
