package co.condorlabs.emerald.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.theme.EmeraldColors
import co.condorlabs.emerald.theme.EmeraldDimens

sealed class EmeraldButtonStyle(
    val backgroundColor: Color,
    val textColor: Color,
    val rippleColor: Color,
    val strokeColor: Color = backgroundColor,
    val strokeWidth: BorderStroke = BorderStroke(1.dp, backgroundColor),
    val highlightTextColor: Color = textColor,
    val defaultElevation: Dp = EmeraldDimens.DefaultElevation,
    val pressedElevation: Dp = EmeraldDimens.DefaultPressedElevation
) {

    object EmeraldDefaultButton: EmeraldButtonStyle(
        backgroundColor = Color.White,
        textColor = Color.Black,
        rippleColor = EmeraldColors.DefaultButtonBorderColor,
        strokeWidth = BorderStroke(1.dp, EmeraldColors.DefaultButtonBorderColor)
    )

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

    object EmeraldWarningButton: EmeraldButtonStyle(
        backgroundColor = EmeraldColors.WarningColor,
        textColor = Color.White,
        rippleColor = EmeraldColors.WarningRippleColor
    )

    object EmeraldOverlayButton: EmeraldButtonStyle(
        backgroundColor = Color.White,
        textColor = EmeraldColors.InfoColor,
        rippleColor = EmeraldColors.InfoColor,
        strokeWidth = BorderStroke(1.dp, EmeraldColors.InfoColor),
        highlightTextColor = Color.White
    )

    object EmeraldFlatPrimaryButton: EmeraldButtonStyle(
        backgroundColor = Color.White,
        textColor = EmeraldColors.InfoColor,
        rippleColor = Color.White,
    )

    object EmeraldShapeWhiteButton: EmeraldButtonStyle(
        backgroundColor = Color.Transparent,
        textColor = Color.White,
        rippleColor = Color.White,
        strokeWidth = BorderStroke(1.dp, Color.White),
        highlightTextColor = EmeraldColors.InfoColor,
        defaultElevation = 0.dp,
        pressedElevation = 0.dp
    )
}