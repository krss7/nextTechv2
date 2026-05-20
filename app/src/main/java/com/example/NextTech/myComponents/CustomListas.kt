package com.example.NextTech.myComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.NextTech.data.Ordenador

/**
 * Un composable que muestra una lista vertical de productos (ordenadores).
 *
 */
@Composable
fun ListaVertical(
    ordenadores: List<Ordenador>,
    onItemClick: (String) -> Unit
) {

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(ordenadores) { producto ->
            TarjetaHorizontal(
                ordenador = producto,
                onClick = { onItemClick(producto.id) }
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
fun ListaHorizontal(
    titulo: String,
    ordenadores: List<Ordenador>,
    onItemClick: (String) -> Unit = {}
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = titulo)
            LazyRow {
                items(ordenadores) { ordenador ->
                    TarjetaVertical(
                        ordenador = ordenador,
                        onClick = { onItemClick(ordenador.id) }
                    )
                }
            }
        }
}


@Preview(showBackground = true)
@Composable
fun PreviewListaVertical() {
    //ListaVertical()
}


