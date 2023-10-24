package com.project.login.presentation

sealed class LoginViewState {
    data object Idle : LoginViewState()
    data object Loading : LoginViewState()
    data object Success : LoginViewState()
    data class Error(val error: Throwable) : LoginViewState()
}