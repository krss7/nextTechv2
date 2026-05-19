package com.example.NextTech.pages

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.NextTech.data.Ordenador
import com.example.NextTech.myComponents.ButtomAppBarNav
import com.example.NextTech.myComponents.ListHorizontal
import com.example.NextTech.myComponents.TopAppTitle
import com.example.NextTech.viewmodels.PrincipalViewModel

@Composable
fun PrincipalPage(
    modifier: Modifier = Modifier,
    viewModel: PrincipalViewModel = viewModel(), // Cambiado a estándar
    onNavigateToDetails: (Int) -> Unit = {},
    onNavigateToSearch: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppTitle(title = "NextTech")
        },
        bottomBar = {
            ButtomAppBarNav(
                onHomeClick = {  },
                onSearchClick = onNavigateToSearch,
                onProfileClick = onNavigateToProfile,
            )
        }
    ) { innerPadding ->
        LazyColumn(modifier = modifier.padding(innerPadding)) {
            items(uiState.categorias) { categoria ->
                val listaDeOrdenadores: List<Ordenador> = uiState.ordenadoresPorCategoria[categoria] ?: emptyList()
                ListHorizontal(
                    titulo = categoria,
                    ordenadores = listaDeOrdenadores,
                    onItemClick = onNavigateToDetails
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomePage() {
    PrincipalPage()
}
