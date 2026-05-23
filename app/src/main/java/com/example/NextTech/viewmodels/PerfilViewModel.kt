package com.example.NextTech.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.NextTech.data.local.SessionManager
import com.example.NextTech.repository.AuthRepository
import com.example.NextTech.uiState.PerfilUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.first

class PerfilViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val sessionManager = SessionManager(application)


    private val authRepository = AuthRepository()
    private val _uiState = MutableStateFlow(PerfilUiState())

    val uiState: StateFlow<PerfilUiState> = _uiState.asStateFlow()

    init {

        viewModelScope.launch {

            sessionManager.userName.collect { name -> _uiState.update { it.copy(nombreUsuario = name) }
            }
        }

        viewModelScope.launch {

            sessionManager.userEmail.collect { email -> _uiState.update { it.copy(email = email)
                }
            }
        }
    }

    fun logout(
        onLogoutComplete: () -> Unit
    ) {

        viewModelScope.launch {

            sessionManager.logout()

            onLogoutComplete()
        }
    }

    fun updateUser(name: String, email: String, passwd: String, onSuccess: () -> Unit) {

        viewModelScope.launch {
            try {
                val userId = sessionManager.userId.first()
                val currentPassword = sessionManager.userPassword.first()
                val finalPassword = if (passwd.isBlank())
                        currentPassword
                    else
                        passwd
                authRepository.updateUser(id = userId, name = name, email = email, passwd = finalPassword
                )
                sessionManager.saveSession(id = userId, name = name, email = email, passwd = finalPassword
                )
                _uiState.update { it.copy(nombreUsuario = name, email = email)
                }
                onSuccess()
            }
            catch (e: Exception) {
                e.printStackTrace()
                println(e.message)
            }
        }
    }

}