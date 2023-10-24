package com.project.login.presentation

sealed class LoginIntent {
    data class PerformLogin(val email: String, val password: String) : LoginIntent()
}
