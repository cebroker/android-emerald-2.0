package co.condorlabs.emerald.components.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import co.condorlabs.emerald.components.utils.Empty
import co.condorlabs.emerald.theme.EmeraldColors
import co.condorlabs.emerald.theme.EmeraldDimens

@Composable
fun EmeraldEmailTextField(
    state: EmeraldTextFieldState,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    placeholder: String = Empty,
    helperTextStart: String = Empty,
    helperTextEnd: String = Empty,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = true,
    maxLines: Int = MaxLinesTextFieldDefault,
    keyboardActions: KeyboardActions = KeyboardActions(),
    textStyle: TextStyle = LocalTextStyle.current.copy(fontWeight = FontWeight.Normal),
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = MaterialTheme.shapes.small,
    colors: TextFieldColors = emeraldTextFieldColors()
) {
    Column {
        OutlinedTextField(
            value = state.text,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            label = { Text(text = label, fontWeight = FontWeight.Light) },
            placeholder = { Text(text = placeholder) },
            enabled = enabled,
            readOnly = readOnly,
            singleLine = singleLine,
            maxLines = maxLines,
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            keyboardActions = keyboardActions,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            isError = state.error != null,
            visualTransformation = visualTransformation,
            shape = shape,
            interactionSource = interactionSource,
            colors = colors
        )
        Box(modifier = Modifier.fillMaxWidth()) {
            if ((state.error != null) or helperTextStart.isNotBlank()) {
                TextFieldHelperText(alignment = Alignment.TopStart, text = helperTextStart, error = state.error)
            }
            if (helperTextEnd.isNotBlank()) {
                TextFieldHelperText(alignment = Alignment.TopEnd, text = helperTextStart, error = state.error)
            }
        }

    }
}

@Composable
private fun BoxScope.TextFieldHelperText(
    alignment: Alignment,
    text: String,
    error: String?,
) {
    Text(
        modifier = Modifier
            .padding(start = EmeraldDimens.PaddingErrorMessageTextField)
            .align(alignment),
        text = error ?: text,
        style = MaterialTheme.typography.overline.copy(
            color = getColorByErrorState(error)
        )
    )
}

private fun getColorByErrorState(error: String?): Color {
    return if (error != null) {
        EmeraldColors.DangerColor
    } else {
        EmeraldColors.TextColor
    }
}