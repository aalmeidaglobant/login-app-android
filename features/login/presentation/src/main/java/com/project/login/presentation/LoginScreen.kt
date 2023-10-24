package com.project.login.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.design_system.theme.ApplicationTheme
import com.project.design_system.tokens.DesignSystemTokens
import kotlinx.coroutines.delay

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val viewState by viewModel.viewState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(DesignSystemTokens.spacing.medium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(DesignSystemTokens.spacing.medium))

        when (viewState) {
            is LoginViewState.Loading -> {
                CircularProgressIndicator()
            }

            is LoginViewState.Success -> {
                LaunchedEffect(key1 = true) {
                    delay(500)
                    onLoginSuccess()
                }
                Text(
                    text = "Login Successful",
                    color = DesignSystemTokens.colors.success,
                )
            }

            is LoginViewState.Error -> {
                Text(
                    text = "Error: ${(viewState as LoginViewState.Error).error.message}",
                    color = DesignSystemTokens.colors.error,
                )
            }

            else -> {
                val focusManager = LocalFocusManager.current
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(DesignSystemTokens.spacing.small)
                )
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Password") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            viewModel.processIntent(LoginIntent.PerformLogin(email, password))
                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(DesignSystemTokens.spacing.small)
                )
                Button(
                    onClick = {
                        viewModel.processIntent(LoginIntent.PerformLogin(email, password))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(DesignSystemTokens.spacing.small)
                ) {
                    Text(text = "Login")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ApplicationTheme {
        LoginScreen(onLoginSuccess = {})
    }
}
