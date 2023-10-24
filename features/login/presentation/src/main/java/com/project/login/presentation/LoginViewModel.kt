package com.project.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.login.domain.PerformLoginUseCase
import com.project.core.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val performLogin: PerformLoginUseCase
) : ViewModel() {
    private val _viewState = MutableStateFlow<LoginViewState>(LoginViewState.Idle)
    val viewState = _viewState

    private val intentChannel = Channel<LoginIntent>(Channel.BUFFERED)

    init {
        handleIntents()
    }

    private fun handleIntents() {
        viewModelScope.launch {
            intentChannel.receiveAsFlow().collect { intent ->
                when (intent) {
                    is LoginIntent.PerformLogin -> {
                        _viewState.value = LoginViewState.Loading
                        when (val result = performLogin(intent.email, intent.password)) {
                            is Result.Success -> {
                                _viewState.value = LoginViewState.Success
                            }
                            is Result.Error -> {
                                _viewState.value = LoginViewState.Error(result.exception)
                            }
                            Result.Loading -> Unit
                        }
                    }
                }
            }
        }
    }

    fun processIntent(intent: LoginIntent) {
        viewModelScope.launch {
            intentChannel.send(intent)
        }
    }
}
