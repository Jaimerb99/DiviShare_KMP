package com.jrb.divishare.ui

import androidx.compose.ui.graphics.Color

object AppTheme {
    val colors = AppColors(
        primary = Color(0xFF52C7A4),
        primaryVariant = Color(0xFF52C7A4).copy(alpha = 0.6f),
        secondary = Color(0xFFDADADA),
        background = Color(0xFFFFFFFF),
        surface = Color(0xFFFFFFFF),
        onPrimary = Color(0xFFFFFFFF),
        onSecondary = Color(0xFF000000),
        onBackground = Color(0xFF000000),
        onSurface = Color(0xFF000000),
        placeholder = Color(0xFFA6A8B5)
    )
}


data class AppColors(
    val primary: Color,
    val primaryVariant: Color,
    val secondary: Color,
    val background: Color,
    val surface: Color,
    val onPrimary: Color,
    val onSecondary: Color,
    val onBackground: Color,
    val onSurface: Color,
    val placeholder: Color
)
