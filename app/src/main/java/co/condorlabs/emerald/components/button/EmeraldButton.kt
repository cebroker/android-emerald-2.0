package co.condorlabs.emerald.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import co.condorlabs.emerald.components.utils.RippleColorTheme
import co.condorlabs.emerald.theme.ButtonTextStyle
import co.condorlabs.emerald.theme.EmeraldDimens
import co.condorlabs.emerald.theme.EmeraldDimens.DefaultSizeCircularProgress

@Composable
fun EmeraldButton(
    text: String,
    emeraldButtonStyle: EmeraldButtonStyle,
    modifier: Modifier = Modifier,
    emeraldButtonState: EmeraldButtonState = EmeraldButtonState.Normal,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.small,
    textStyle: TextStyle = ButtonTextStyle.TextStyle,
    clickAction: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    CompositionLocalProvider(LocalRippleTheme provides RippleColorTheme(emeraldButtonStyle.rippleColor)) {
        Button(
            onClick = clickAction,
            border = getButtonBorder(enabled, emeraldButtonStyle),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = getBackgroundColor(isPressed, emeraldButtonStyle)
            ),
            modifier = modifier,
            enabled = enabled,
            interactionSource = interactionSource,
            elevation = ButtonDefaults.elevation(
                defaultElevation = emeraldButtonStyle.defaultElevation,
                pressedElevation = emeraldButtonStyle.pressedElevation
            ),
            shape = shape,
        ) {
            if (emeraldButtonState is EmeraldButtonState.Normal) {
                Text(
                    text = text,
                    color = getTextColor(isPressed, emeraldButtonStyle),
                    style = textStyle
                )
            } else {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(DefaultSizeCircularProgress),
                    color = emeraldButtonStyle.textColor,
                    strokeWidth = EmeraldDimens.DefaultProgressStrokeWidth
                )
            }
        }
    }
}

@Composable
private fun getBackgroundColor(
    isPressed: Boolean,
    emeraldButtonStyle: EmeraldButtonStyle
) = if (isPressed) emeraldButtonStyle.rippleColor else emeraldButtonStyle.backgroundColor

@Composable
private fun getTextColor(
    isPressed: Boolean,
    emeraldButtonStyle: EmeraldButtonStyle
) = if (isPressed) emeraldButtonStyle.highlightTextColor else emeraldButtonStyle.textColor

@Composable
private fun getButtonBorder(
    enabled: Boolean,
    emeraldButtonStyle: EmeraldButtonStyle
) = if (enabled) emeraldButtonStyle.strokeWidth else BorderStroke(
    EmeraldDimens.DefaultWidthToBorderStroke,
    Color.DarkGray.copy(alpha = DefaultAlphaDisable)
)

private const val DefaultAlphaDisable = 0.12f


