package co.condorlabs.emerald.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.utils.RippleColorTheme
import co.condorlabs.emerald.numberToDp
import co.condorlabs.emerald.theme.ButtonTextStyle

@Composable
fun EmeraldButton(
    text: String,
    emeraldButtonStyle: EmeraldButtonStyle,
    modifier: Modifier = Modifier,
    emeraldButtonState: EmeraldButtonState = EmeraldButtonState.Normal,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.small,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    textStyle: TextStyle = ButtonTextStyle.TextStyle,
    clickAction: () -> Unit
) {
    val buttonSize = remember {
        mutableStateOf(0)
    }
    Box {
        val interactionSource = remember { MutableInteractionSource() }
        val isPressed by interactionSource.collectIsPressedAsState()

        CompositionLocalProvider(LocalRippleTheme provides RippleColorTheme(emeraldButtonStyle.rippleColor)) {
            Button(
                onClick = clickAction,
                border = getButtonBorder(enabled, emeraldButtonStyle),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = getBackgroundColor(isPressed, emeraldButtonStyle)
                ),
                modifier = modifier
                    .onGloballyPositioned {
                        buttonSize.value = it.size.height
                    },
                enabled = enabled,
                interactionSource = interactionSource,
                elevation = ButtonDefaults.elevation(
                    defaultElevation = emeraldButtonStyle.defaultElevation,
                    pressedElevation = emeraldButtonStyle.pressedElevation
                ),
                shape = shape,
                contentPadding = contentPadding,
            ) {
                if (emeraldButtonState is EmeraldButtonState.Normal) {
                    Text(
                        text = text,
                        color = getTextColor(isPressed, emeraldButtonStyle),
                        style = textStyle
                    )
                }
            }

            if (emeraldButtonState is EmeraldButtonState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(buttonSize.value.numberToDp() - DEFAULT_REDUCE_PADDING.dp),
                    color = emeraldButtonStyle.textColor,
                    strokeWidth = DEFAULT_PROGRESS_STROKE_WIDTH.numberToDp()
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
    1.dp,
    Color.DarkGray.copy(alpha = 0.12f)
)

private const val DEFAULT_REDUCE_PADDING = 10
private const val DEFAULT_PROGRESS_STROKE_WIDTH = 8


