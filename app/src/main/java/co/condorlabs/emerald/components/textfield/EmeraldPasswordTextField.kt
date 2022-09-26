package co.condorlabs.emerald.components.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextFieldColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import co.condorlabs.emerald.R
import co.condorlabs.emerald.components.utils.Empty

@Composable
fun EmeraldPasswordTextField(
    modifier: Modifier = Modifier,
    label: String,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = true,
    placeholder: String = Empty,
    state: EmeraldTextFieldState,
    helperTextEnd: String = Empty,
    onValueChange: (String) -> Unit,
    helperTextStart: String = Empty,
    maxLines: Int = MaxLinesTextFieldDefault,
    shape: Shape = MaterialTheme.shapes.small,
    leadingIcon: @Composable (() -> Unit)? = null,
    colors: TextFieldColors = emeraldTextFieldColors(),
    keyboardActions: KeyboardActions = KeyboardActions(),
    textStyle: TextStyle = LocalTextStyle.current.copy(fontWeight = FontWeight.Normal),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val passwordVisible = rememberSaveable { mutableStateOf(false) }
    EmeraldTextField(
        state = state,
        label = label,
        shape = shape,
        colors = colors,
        enabled = enabled,
        readOnly = readOnly,
        modifier = modifier,
        maxLines = maxLines,
        textStyle = textStyle,
        singleLine = singleLine,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        onValueChange = onValueChange,
        helperTextEnd = helperTextEnd,
        helperTextStart = helperTextStart,
        keyboardActions = keyboardActions,
        interactionSource = interactionSource,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordVisible.value = !passwordVisible.value
                }
            ) {
                Icon(
                    imageVector = if (passwordVisible.value) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = if(passwordVisible.value) stringResource(id = R.string.hide_password) else stringResource(id = R.string.show_password)
                )
            }
        }
    )
}