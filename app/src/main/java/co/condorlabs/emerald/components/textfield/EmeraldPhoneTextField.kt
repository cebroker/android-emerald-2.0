package co.condorlabs.emerald.components.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import co.condorlabs.emerald.components.utils.Empty

@Composable
fun EmeraldPhoneTextField(
    modifier: Modifier = Modifier,
    label: String,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = true,
    placeholder: String = Empty,
    state: EmeraldTextFieldState,
    helperTextEnd: String = Empty,
    helperTextStart: String = Empty,
    onValueChange: (String) -> Unit,
    maxLines: Int = MaxLinesTextFieldDefault,
    shape: Shape = MaterialTheme.shapes.small,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    colors: TextFieldColors = emeraldTextFieldColors(),
    keyboardActions: KeyboardActions = KeyboardActions(),
    textStyle: TextStyle = LocalTextStyle.current.copy(fontWeight = FontWeight.Normal),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    EmeraldTextField(
        state = state,
        label = label,
        shape = shape,
        colors = colors,
        enabled = enabled,
        readOnly = readOnly,
        maxLines = maxLines,
        modifier = modifier,
        textStyle = textStyle,
        singleLine = singleLine,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        helperTextEnd = helperTextEnd,
        onValueChange = onValueChange,
        helperTextStart = helperTextStart,
        keyboardActions = keyboardActions,
        interactionSource = interactionSource,
        visualTransformation = MaskVisualTransformation(PHONE_MASK),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}
private const val PHONE_MASK = "(###) ### ####"