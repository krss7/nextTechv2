package com.example.NextTech.uiState

data class PerfilUiState(
    val nombreUsuario: String = "Usuario Demo",
    val email: String = "usuario@demo.com",
    val avatarUrl: String? = null,
    val isLoading: Boolean = false
)
