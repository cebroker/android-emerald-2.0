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
        backgroundColor = EmeraldColors.InfoColor,
        textColor = Color.White,
        rippleColor = EmeraldColors.PrimaryRippleColor
    )

    object EmeraldSuccessButton: EmeraldButtonStyle(
        backgroundColor = EmeraldColors.SuccessColor,
        textColor = Color.White,
        rippleColor = EmeraldColors.SuccessRippleColor
    )

    object EmeraldDangerButton: EmeraldButtonStyle(
        backgroundColor = EmeraldColors.DangerColor,
        textColor = Color.White,
        rippleColor = EmeraldColors.DangerRippleColor
    )
}