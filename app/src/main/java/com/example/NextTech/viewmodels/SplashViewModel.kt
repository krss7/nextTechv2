package com.example.NextTech.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.NextTech.data.local.SessionManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val sessionManager =
        SessionManager(application)

    private val _isLoggedIn =
        MutableStateFlow(false)

    val isLoggedIn: StateFlow<Boolean> =
        _isLoggedIn.asStateFlow()

    init {

        viewModelScope.launch {

            sessionManager.isLoggedIn.collect {

                _isLoggedIn.value = it
            }
        }
    }
}