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
import com.example.NextTech.myComponents.Registro
import com.example.NextTech.viewmodels.RegistroViewModel

/**
 * Función composable que representa la pantalla de registro de la aplicación.
 */
@Composable
fun RegistroPage(
    modifier: Modifier = Modifier,
    viewModel: RegistroViewModel = viewModel(), // Cambiado al estándar sin Hilt
    onNavigateToLogin: () -> Unit = {},
    onRegisterSuccess: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()

    // Observamos el estado de éxito para navegar automáticamente
    LaunchedEffect(uiState.registroExitoso) {
        if (uiState.registroExitoso) {
            onRegisterSuccess()
        }
    }

    Scaffold { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Registro(
                onRegisterClicked = { usuario ->
                    viewModel.registrar() 
                },
                onNavigateToLogin = onNavigateToLogin
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistroPagePreview() {
    RegistroPage()
}
