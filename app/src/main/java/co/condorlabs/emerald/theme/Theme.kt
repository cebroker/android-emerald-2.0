package co.condorlabs.emerald.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = EmeraldColors.ColorPrimary,
    primaryVariant = EmeraldColors.ColorPrimaryDark,
    secondary = EmeraldColors.ColorAccent,
    background = Color.White
)

private val LightColorPalette = lightColors(
    primary = EmeraldColors.ColorPrimary,
    primaryVariant = EmeraldColors.ColorPrimaryDark,
    secondary = EmeraldColors.ColorAccent,
    background = Color.White
)

@Composable
fun EmeraldTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors,
        typography = EmeraldTypography.TextTypography,
        content = content
    )
}