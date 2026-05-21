package com.example.NextTech.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.NextTech.repository.OrdenadorRepository
import com.example.NextTech.uiState.InicioUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.example.NextTech.repository.AuthRepository
import com.example.NextTech.data.local.SessionManager

class InicioViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val sessionManager = SessionManager(application)
    private val ordenadorRepository = OrdenadorRepository()
    private val authRepository = AuthRepository()

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

    fun login(
        name: String,
        pass: String,
        onSuccess: () -> Unit
    ) {
        if (name.isBlank() || pass.isBlank()) {
            _uiState.update {
                it.copy(
                    error = "Introduce nombre y contraseña")
            }
            return
        }
        viewModelScope.launch {
            try {
                _uiState.update {
                    it.copy(
                        isLoading = true, error = null)
                }
               val response = authRepository.login(
                    name = name, passwd = pass
                )
                sessionManager.saveSession(
                    id = response.id,
                    name = response.name,
                    email = response.email
                )

                _uiState.update {
                    it.copy(isLoading = false)
                }
                onSuccess()

            } catch (e: Exception) {
                e.printStackTrace()
                println(e.message)

                _uiState.update {
                    it.copy(
                        isLoading = false, error = e.message)
                }
            }
        }
    }
}
