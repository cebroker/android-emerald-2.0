package co.condorlabs.emerald.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.theme.EmeraldColors

sealed class EmeraldButtonStyle(
    val backgroundColor: Color,
    val textColor: Color,
    val rippleColor: Color,
    val strokeColor: Color = backgroundColor,
    val strokeWidth: BorderStroke = BorderStroke(1.dp, backgroundColor),
    val highlightTextColor: Color = textColor
) {
    object EmeraldPrimaryButton: EmeraldButtonStyle(
        backgroundColor = EmeraldColors.primaryColor,
        textColor = Color.White,
        rippleColor = EmeraldColors.primaryRippleColor
    )

    object EmeraldSuccessButton: EmeraldButtonStyle(
        backgroundColor = EmeraldColors.successColor,
        textColor = Color.White,
        rippleColor = EmeraldColors.successRippleColor
    )

    object EmeraldDangerButton: EmeraldButtonStyle(
        backgroundColor = EmeraldColors.dangerColor,
        textColor = Color.White,
        rippleColor = EmeraldColors.dangerRippleColor
    )
}