package com.example.NextTech.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.NextTech.uiState.RegistroUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegistroViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(RegistroUiState())
    val uiState: StateFlow<RegistroUiState> = _uiState.asStateFlow()

    fun onNombreChange(nombre: String) {
        _uiState.update { it.copy(nombre = nombre) }
    }

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun onContrasenhaChange(contrasenha: String) {
        _uiState.update { it.copy(contrasenha = contrasenha) }
    }

    fun onRepetirContrasenhaChange(repetir: String) {
        _uiState.update { it.copy(repetirContrasenha = repetir) }
    }

    fun registrar() {
        val state = _uiState.value
        
        if (state.nombre.isBlank() || state.email.isBlank() || state.contrasenha.isBlank()) {
            _uiState.update { it.copy(error = "Todos los campos son obligatorios") }
            return
        }

        if (state.contrasenha != state.repetirContrasenha) {
            _uiState.update { it.copy(error = "Las contraseñas no coinciden") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            

            _uiState.update { it.copy(isLoading = false, registroExitoso = true) }
        }
    }
}
