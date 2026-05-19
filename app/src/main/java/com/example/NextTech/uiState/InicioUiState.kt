package com.example.NextTech.uiState

import com.example.NextTech.data.Ordenador

data class InicioUiState(
    val ordenadores: List<Ordenador> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
