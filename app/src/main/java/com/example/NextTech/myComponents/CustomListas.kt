package com.example.NextTech.myComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.NextTech.data.Ordenador
import com.example.NextTech.data.ordenadores

/**
 * Un composable que muestra una lista vertical de productos (ordenadores).
 *
 * @param searchQuery Filtro de búsqueda.
 * @param onItemClick Acción al pulsar un ordenador (devuelve su ID).
 */
@Composable
fun ListVertical(
    searchQuery: String = "",
    onItemClick: (Int) -> Unit = {}
) {
    val productos = ordenadores

    val productosFiltrados = remember(searchQuery, productos) {
        if (searchQuery.isBlank()) {
            productos
        } else {
            productos.filter {
                it.nombre.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally){
        items(productosFiltrados) { producto ->
            TarjetaHorizontal(
                ordenador = producto, 
                onClick = { onItemClick(producto.id.toInt()) }
            )
        }
    }
}

/**
 * Un composable que muestra una lista horizontal de elementos.
 *
 * @param titulo Título de la sección.
 * @param ordenadores Lista de ordenadores a mostrar.
 * @param onItemClick Acción al pulsar un ordenador (devuelve su ID).
 */
@Composable
fun ListHorizontal(
    titulo: String,
    ordenadores: List<Ordenador> = emptyList(),
    onItemClick: (Int) -> Unit = {}
) {
   Column(modifier = Modifier.padding(10.dp)) {
         Text(text = titulo)
         LazyRow {
              items(ordenadores) { ordenador ->
                  TarjetaVertical(
                      ordenador = ordenador, 
                      onClick = { onItemClick(ordenador.id.toInt()) }
                  )
              }
         }
    }
}

@Preview
@Composable
fun PreviewListVertical() {
    ListVertical()
}
