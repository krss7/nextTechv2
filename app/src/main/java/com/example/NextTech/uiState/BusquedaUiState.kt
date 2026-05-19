package com.example.NextTech.uiState

import com.example.NextTech.data.Ordenador

data class BusquedaUiState(
    val searchText: String = "",
    val ordenadoresFiltrados: List<Ordenador> = emptyList(),
    val isLoading: Boolean = false
)
