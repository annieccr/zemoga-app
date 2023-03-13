package com.example.zemoga_app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = MainGreen,
    primaryVariant = ActivateStart,
    secondary = DesactivateStart
)

private val LightColorPalette = lightColors(
    primary = MainGreen,
    primaryVariant = ActivateStart,
    secondary = DesactivateStart
)

@Composable
fun ZemogaappTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}