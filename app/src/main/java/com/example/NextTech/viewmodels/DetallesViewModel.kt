package com.example.NextTech.viewmodels

import androidx.lifecycle.ViewModel
import com.example.NextTech.repository.OrdenadorRepository
import com.example.NextTech.uiState.DetallesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetallesViewModel : ViewModel() {

    private val repository = OrdenadorRepository()

    private val _uiState = MutableStateFlow(DetallesUiState())
    val uiState: StateFlow<DetallesUiState> = _uiState.asStateFlow()

    fun cargarOrdenador(id: Int) {
        _uiState.value = _uiState.value.copy(
            ordenador = repository.obtenerOrdenadorPorId(id)
        )
    }
}
