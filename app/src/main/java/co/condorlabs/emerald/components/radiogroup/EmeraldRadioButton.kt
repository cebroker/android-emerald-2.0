package co.condorlabs.emerald.components.radiogroup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.button.EmeraldButtonStyle
import co.condorlabs.emerald.components.text.EmeraldTextStyle
import co.condorlabs.emerald.theme.EmeraldDimens

@Composable
fun EmeraldRadioButton(
    state: EmeraldRadioButtonState,
    selection: EmeraldRadioButtonState,
    modifier: Modifier = Modifier,
    textStyle: EmeraldTextStyle,
    emeraldButtonStyle: EmeraldButtonStyle = EmeraldButtonStyle.EmeraldOverlayButton,
    enabled: Boolean,
    colors: RadioButtonColors,
    onClick: (() -> Unit),
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Button(
        border = getButtonBorder(
            enabled = enabled,
            selected = selection.id == state.id && selection.value,
            emeraldButtonStyle = emeraldButtonStyle),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = getBackgroundColor(isPressed, emeraldButtonStyle)
        ),
        onClick = onClick) {
        Row(modifier = modifier
            .padding(horizontal = 5.dp, vertical = 10.dp)) {
            RadioButton(
                selected = selection.id == state.id && selection.value,
                onClick = onClick,
                enabled = enabled,
                colors = colors
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = AnnotatedString(state.text),
                style = textStyle.getTextStyle(),
                color = textStyle.getColorText(),
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

@Composable
private fun getButtonBorder(
    enabled: Boolean,
    selected: Boolean,
    emeraldButtonStyle: EmeraldButtonStyle
) = if (enabled && selected) emeraldButtonStyle.strokeWidth else BorderStroke(
    EmeraldDimens.DefaultWidthToBorderStroke,
    Color.DarkGray.copy(alpha = DefaultAlphaDisable)
)

private fun getBackgroundColor(
    isPressed: Boolean,
    emeraldButtonStyle: EmeraldButtonStyle
) = if (isPressed) emeraldButtonStyle.rippleColor else emeraldButtonStyle.backgroundColor

private const val DefaultAlphaDisable = 0.12f