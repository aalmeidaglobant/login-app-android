package com.project.design_system.tokens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable


object DesignSystemTokens {
    val colors: ColorTokens
        @Composable
        @ReadOnlyComposable
        get() = LocalColorTokens.current
    val spacing: SpacingTokens
        @Composable
        @ReadOnlyComposable
        get() = LocalSpacingTokens.current
}