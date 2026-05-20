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
import com.example.NextTech.myComponents.ListaHorizontal
import com.example.NextTech.myComponents.TopAppTitle
import com.example.NextTech.viewmodels.PrincipalViewModel

@Composable
fun PrincipalPage(
    modifier: Modifier = Modifier,
    viewModel: PrincipalViewModel = viewModel(),
    onNavigateToDetails: (String) -> Unit = {},
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
            items(uiState.ordenadoresPorCategoria.keys.toList()) { categoria ->
                val listaDeOrdenadores: List<Ordenador> = uiState.ordenadoresPorCategoria[categoria] ?: emptyList()
                ListaHorizontal(
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
