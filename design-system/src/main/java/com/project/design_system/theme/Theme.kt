package com.project.design_system.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.project.design_system.tokens.ColorTokens
import com.project.design_system.tokens.LocalColorTokens
import com.project.design_system.tokens.LocalSpacingTokens
import com.project.design_system.tokens.SpacingTokens

val BrightGreen = Color(0xFF00C713)
val DarkGreen = Color(0xFF00790C)
val Orange = Color(0xFFFFAA00)
val LightGray = Color(0xFF808080)
val MediumGray = Color(0xFF404040)
val DarkGray = Color(0xFF202020)
val TextWhite = Color(0xFFEEEEEE)

val MaterialShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp),
)

private val DarkColorScheme = darkColorScheme(
    primary = BrightGreen,
    secondary = Orange,
    background = MediumGray,
    onBackground = TextWhite,
    surface = LightGray,
    onSurface = TextWhite,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

private val LightColorScheme = lightColorScheme(
    primary = BrightGreen,
    secondary = Orange,
    background = Color.White,
    onBackground = DarkGray,
    surface = Color.White,
    onSurface = DarkGray,
    onPrimary = Color.White,
    onSecondary = Color.White,
)
val MaterialTypography = Typography()

@Composable
fun ApplicationTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val materialColorScheme = if(darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    CompositionLocalProvider(
        LocalColorTokens provides ColorTokens(),
        LocalSpacingTokens provides SpacingTokens(),
    ) {
        MaterialTheme(
            colorScheme = materialColorScheme,
            typography = MaterialTypography,
            shapes = MaterialShapes,
            content = content
        )
    }
}