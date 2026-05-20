package com.example.NextTech.myComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.NextTech.data.Ordenador


/**
 * Composable que muestra la pantalla de detalles de un ordenador específico.
 * Busca el ordenador por su ID en una lista predefinida y muestra su imagen,
 * nombre y una tabla con sus especificaciones. Si el ordenador no se encuentra,
 * muestra un mensaje indicándolo.
 *
 * @param ordenadorId El ID del ordenador del cual se mostrarán los detalles.
 */
@Composable
fun Detalles(
    ordenador: Ordenador
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = ordenador.imagenPrincipal),
            contentDescription = ordenador.nombre,

            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = ordenador.nombre,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        TablaEspecificaciones(
            especificaciones = ordenador.especificaciones
        )
    }
}


@Preview
@Composable
fun DetallesPreview() {
   // Detalles(ordenadorId = "1")
}
