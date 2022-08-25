package co.condorlabs.emerald.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    primary = EmeraldColors.ColorPrimary,
    primaryVariant = EmeraldColors.ColorPrimaryDark,
    secondary = EmeraldColors.ColorAccent,
    background = Color.White
)

@Composable
fun EmeraldTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = EmeraldTypography.TextTypography,
        content = content
    )
}