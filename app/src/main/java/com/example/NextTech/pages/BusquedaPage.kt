package com.example.NextTech.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.NextTech.myComponents.Buscador
import com.example.NextTech.myComponents.ButtomAppBarNav
import com.example.NextTech.myComponents.ListaVertical
import com.example.NextTech.viewmodels.BusquedaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusquedaPage(
    modifier: Modifier = Modifier,
    viewModel: BusquedaViewModel = viewModel(),
    onNavigateToDetails: (String) -> Unit = {},
    onNavigateToHome: () -> Unit = {},
    onNavigateToSearch: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold (
        bottomBar = {
            ButtomAppBarNav(
                onHomeClick = onNavigateToHome,
                onSearchClick = onNavigateToSearch,
                onProfileClick = onNavigateToProfile,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Buscador(
                query = uiState.searchText,
                onQueryChange = { viewModel.onSearchTextChange(it) }
            )
            ListaVertical(
                ordenadores = uiState.ordenadoresFiltrados,
                onItemClick = onNavigateToDetails
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchPage() {
    BusquedaPage()
}
