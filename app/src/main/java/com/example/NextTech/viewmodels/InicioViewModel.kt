package com.example.NextTech.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.NextTech.repository.OrdenadorRepository
import com.example.NextTech.uiState.InicioUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class InicioViewModel : ViewModel() {

    private val ordenadorRepository = OrdenadorRepository()

    private val _uiState = MutableStateFlow(InicioUiState())
    val uiState: StateFlow<InicioUiState> = _uiState.asStateFlow()

    init {
        cargarOrdenadores()
    }

    private fun cargarOrdenadores() {
        viewModelScope.launch {
            val lista = ordenadorRepository.obtenerOrdenadores()
            _uiState.update {
                it.copy(
                    ordenadores = lista
                )
            }
        }
    }

    fun login(email: String, pass: String, onSuccess: () -> Unit) {
        if (email.isBlank() || pass.isBlank()) {
            _uiState.update { it.copy(error = "Introduce email y contraseña") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            _uiState.update { it.copy(isLoading = false) }
            onSuccess()
        }
    }
}
