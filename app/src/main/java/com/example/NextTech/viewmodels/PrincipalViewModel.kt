package com.example.NextTech.viewmodels

import androidx.lifecycle.ViewModel
import com.example.NextTech.data.Ordenador
import com.example.NextTech.repository.OrdenadorRepository
import com.example.NextTech.uiState.PrincipalUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PrincipalViewModel : ViewModel() {

    private val ordenadorRepository = OrdenadorRepository()

    private val _uiState = MutableStateFlow(PrincipalUiState())
    val uiState: StateFlow<PrincipalUiState> = _uiState.asStateFlow()

    init {
        cargarDatos()
    }

    private fun cargarDatos() {
        val todos = ordenadorRepository.obtenerOrdenadores()
        
        val categorizados: Map<String, List<Ordenador>> = mapOf(
            "Más Vendidos" to todos.take(5),
            "Populares" to todos.shuffled().take(5),
            "Nuevos Lanzamientos" to todos.takeLast(5)
        )

        _uiState.update { it.copy(
            ordenadoresPorCategoria = categorizados
        ) }
    }
}
