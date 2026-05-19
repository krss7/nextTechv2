package com.example.NextTech.uiState

data class RegistroUiState(
    val nombre: String = "",
    val email: String = "",
    val contrasenha: String = "",
    val repetirContrasenha: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val registroExitoso: Boolean = false
)
