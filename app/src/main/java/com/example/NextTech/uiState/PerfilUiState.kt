package com.example.NextTech.uiState

data class PerfilUiState(
    val nombreUsuario: String = "",
    val email: String = "",
    val avatarUrl: String? = null,
    val isLoading: Boolean = false
)
