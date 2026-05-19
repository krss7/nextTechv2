package com.example.NextTech.myComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.NextTech.data.Ordenador
import com.example.NextTech.R

@Composable
fun TarjetaVertical(ordenador: Ordenador, onClick: () -> Unit) {
    var clicado by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .width(130.dp)
            .padding(8.dp)
            .clickable(enabled = clicado) { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = ordenador.imagenPrincipal),
            contentDescription = ordenador.nombre,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Fit
        )
        Text(
            text = ordenador.nombre,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun TarjetaHorizontal(ordenador: Ordenador, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .width(320.dp)
            .padding(8.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = ordenador.imagenPrincipal),
            contentDescription = ordenador.nombre,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Fit
        )
        Text(
            text = ordenador.nombre,
            fontSize = 14.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TarjetaVerticalPreview() {
    TarjetaVertical(
        ordenador = Ordenador(
            id = 1,
            imagenPrincipal = R.drawable.macbook_air_m2,
            nombre = "Apple MacBook Air 13\" (M2)",
            especificaciones = emptyList()
        ),
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
fun TarjetaHorizontalPreview() {
    TarjetaHorizontal(
        ordenador = Ordenador(
            id = 1,
            imagenPrincipal = R.drawable.macbook_air_m2,
            nombre = "Apple MacBook Air 13\" (M2)",
            especificaciones = emptyList()
        ),
        onClick = { }
    )
}
