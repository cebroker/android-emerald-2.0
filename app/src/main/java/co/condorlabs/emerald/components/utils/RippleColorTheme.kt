package co.condorlabs.emerald.components.utils

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class RippleColorTheme(
    val rippleColor: Color
) : RippleTheme {

    @Composable
    override fun defaultColor(): Color {
        return RippleTheme.defaultRippleColor(
            rippleColor,
            lightTheme = true
        )
    }

    @Composable
    override fun rippleAlpha(): RippleAlpha {
        return RippleTheme.defaultRippleAlpha(
            rippleColor,
            lightTheme = true
        )
    }
}
