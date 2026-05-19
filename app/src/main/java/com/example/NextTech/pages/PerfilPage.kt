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
import com.example.NextTech.myComponents.ButtomAppBarNav
import com.example.NextTech.myComponents.Perfil
import com.example.NextTech.viewmodels.PerfilViewModel

/**
 * Un Composable que representa la pantalla del perfil de usuario.
 *
 * @param modifier El modificador que se aplicará al diseño.
 * @param viewModel El [PerfilViewModel] que proporciona el estado del perfil.
 * @param onNavigateToHome Acción para navegar al inicio.
 * @param onNavigateToSearch Acción para navegar a la búsqueda.
 * @param onLogout Acción para cerrar sesión y volver al inicio.
 */
@Composable
fun PerfilPage(
    modifier: Modifier = Modifier,
    viewModel: PerfilViewModel = viewModel(),
    onNavigateToHome: () -> Unit = {},
    onNavigateToSearch: () -> Unit = {},
    onLogout: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        bottomBar = {
            ButtomAppBarNav(
                onHomeClick = onNavigateToHome,
                onSearchClick = onNavigateToSearch,
                onProfileClick = { /* Ya estamos en Perfil */ },
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Perfil(
                nombreUsuarioInicial = uiState.nombreUsuario,
                correoInicial = uiState.email
            )
        }
    }
}

@Preview
@Composable
fun PerfilPagePreview() {
    PerfilPage()
}
