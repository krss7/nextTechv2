package com.example.NextTech.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.NextTech.data.Ordenador
import com.example.NextTech.repository.OrdenadorRepository
import com.example.NextTech.uiState.BusquedaUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BusquedaViewModel : ViewModel() {

    private val ordenadorRepository = OrdenadorRepository()
    private var todosLosOrdenadores: List<Ordenador> = emptyList()

    private val _uiState = MutableStateFlow(
        BusquedaUiState()
    )

    val uiState: StateFlow<BusquedaUiState> = _uiState.asStateFlow()

    init {
        cargarOrdenadores()
    }

    private fun cargarOrdenadores() {

        viewModelScope.launch {

            todosLosOrdenadores =
                ordenadorRepository.obtenerOrdenadores()

            filtrarOrdenadores(_uiState.value.searchText)
        }
    }

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
