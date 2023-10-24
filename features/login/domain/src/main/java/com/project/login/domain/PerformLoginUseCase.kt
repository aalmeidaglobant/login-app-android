package com.project.login.domain

import com.project.core.util.Result
import kotlinx.coroutines.delay

class PerformLoginUseCase {
    suspend operator fun invoke(email: String, password: String): Result<Boolean> {
        delay(1000)
        return Result.Success(true)
    }
}
