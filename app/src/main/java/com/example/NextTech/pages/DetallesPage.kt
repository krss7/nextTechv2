package com.example.NextTech.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.NextTech.myComponents.Detalles
import com.example.NextTech.repository.OrdenadorRepository
import com.example.NextTech.viewmodels.DetallesViewModel
import com.example.NextTech.viewmodels.DetallesViewModelFactory

@Composable
fun DetallesPage(
    modifier: Modifier = Modifier,
    ordenadorId: String,
    viewModel: DetallesViewModel = viewModel(
        factory = DetallesViewModelFactory(
            ordenadorId = ordenadorId,
            repository = OrdenadorRepository()
        )
    ),
    onNavigateBack: () -> Unit = {}
) {

    val uiState by viewModel.uiState.collectAsState()

    Scaffold { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            uiState.ordenador?.let { ordenador ->
                Detalles(
                    ordenador = ordenador
                )
            }
        }
    }
}

@Preview
@Composable
fun DetallesPagePreview() {

}
