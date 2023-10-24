package com.project.design_system.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color


@Immutable
data class ColorTokens(
    val success: Color = Color(0xFF148F47),
    val error: Color = Color(0xFFCD1D32),
)

val LocalColorTokens = compositionLocalOf { ColorTokens() }

