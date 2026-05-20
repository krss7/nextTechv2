package com.example.NextTech.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.NextTech.myComponents.Detalles
import com.example.NextTech.viewmodels.DetallesViewModel

@Composable
fun DetallesPage(
    modifier: Modifier = Modifier,
    ordenadorId: Int,
    viewModel: DetallesViewModel = viewModel(),
    onNavigateBack: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(ordenadorId) {
        viewModel.cargarOrdenador(ordenadorId)
    }

    Scaffold { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Detalles(ordenadorId = ordenadorId)
        }
    }
}

@Preview
@Composable
fun DetallesPagePreview() {
    DetallesPage(ordenadorId = 20)
}
