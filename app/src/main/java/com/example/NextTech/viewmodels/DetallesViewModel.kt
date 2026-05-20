package com.example.NextTech.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.NextTech.data.Ordenador
import com.example.NextTech.repository.OrdenadorRepository
import com.example.NextTech.uiState.DetallesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetallesViewModel(
    private val ordenadorId: String,
    private val repository: OrdenadorRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetallesUiState())
    val uiState: StateFlow<DetallesUiState> = _uiState.asStateFlow()


    init {
        cargarOrdenador()
    }

    private fun cargarOrdenador() {

        viewModelScope.launch {

            val ordenador = repository.obtenerOrdenadorPorId(ordenadorId)

            _uiState.update {
                it.copy(ordenador = ordenador)
            }
        }
    }
}

data class DetallesUiState(
    val ordenador: Ordenador? = null
)

class DetallesViewModelFactory(
    private val ordenadorId: String,
    private val repository: OrdenadorRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetallesViewModel(ordenadorId, repository) as T
    }
}