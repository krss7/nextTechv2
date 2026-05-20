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
import com.example.NextTech.myComponents.InicioSesion
import com.example.NextTech.viewmodels.InicioViewModel

@Composable
fun InicioPage(
    modifier: Modifier = Modifier,
    viewModel: InicioViewModel = viewModel(),
    onNavigateToRegister: () -> Unit = {},
    onLoginSuccess: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InicioSesion(
                onLoginClicked = { email, pass -> 
                    viewModel.login(email, pass, onLoginSuccess) 
                },
                onNavigateToRegister = onNavigateToRegister
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InicioPagePreview() {
    InicioPage()
}
