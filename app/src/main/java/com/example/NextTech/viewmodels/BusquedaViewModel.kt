package com.example.NextTech.viewmodels

import androidx.lifecycle.ViewModel
import com.example.NextTech.repository.OrdenadorRepository
import com.example.NextTech.uiState.BusquedaUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BusquedaViewModel : ViewModel() {

    private val ordenadorRepository = OrdenadorRepository()
    private val todosLosOrdenadores = ordenadorRepository.obtenerOrdenadores()

    private val _uiState = MutableStateFlow(BusquedaUiState(
        ordenadoresFiltrados = todosLosOrdenadores
    ))
    val uiState: StateFlow<BusquedaUiState> = _uiState.asStateFlow()

    fun onSearchTextChange(text: String) {
        _uiState.update { it.copy(searchText = text) }
        filtrarOrdenadores(text)
    }

    private fun filtrarOrdenadores(query: String) {
        val filtrados = if (query.isEmpty()) {
            todosLosOrdenadores
        } else {
            todosLosOrdenadores.filter {
                it.nombre.contains(query, ignoreCase = true)
            }
        }
        _uiState.update { it.copy(ordenadoresFiltrados = filtrados) }
    }
}
