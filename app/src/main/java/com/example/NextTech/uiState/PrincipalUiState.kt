package com.example.NextTech.uiState

import com.example.NextTech.data.Ordenador

data class PrincipalUiState(
    val categorias: List<String> = listOf("Más Vendidos", "Populares", "Nuevos Lanzamientos"),
    val ordenadoresPorCategoria: Map<String, List<Ordenador>> = emptyMap(),
    val isLoading: Boolean = false
)
