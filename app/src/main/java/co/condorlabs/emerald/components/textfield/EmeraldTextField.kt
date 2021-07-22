package co.condorlabs.emerald.components.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import co.condorlabs.emerald.EMPTY
import co.condorlabs.emerald.theme.EmeraldColors
import co.condorlabs.emerald.theme.EmeraldDimens
import co.condorlabs.emerald.theme.EmeraldTheme
import com.google.android.material.button.MaterialButton

@Preview(showBackground = true)
@Composable
fun PreviewEditText() {
    EmeraldTheme {
        val textStateEmpty = remember {
            mutableStateOf(
                EmeraldTextFieldState()
            )
        }

        val textStateCorrect = remember {
            mutableStateOf(
                EmeraldTextFieldState(
                    text = TextFieldValue("Correct data")
                )
            )
        }

        val textStateError = remember {
            mutableStateOf(
                EmeraldTextFieldState(
                    text = TextFieldValue("Wrong data"), error = "This is an error message"
                )
            )
        }

        val onValueChanged = { text: TextFieldValue ->
            textStateCorrect.value = textStateCorrect.value.copy(text = text)
            textStateCorrect.value = textStateCorrect.value.copy(error = "This is an error message")
        }

        Column {
            EmeraldTextField(state = textStateEmpty.value, onValueChange = onValueChanged, label = "Label")
            EmeraldTextField(state = textStateCorrect.value, onValueChange = onValueChanged, label = "Label")
            EmeraldTextField(state = textStateError.value, onValueChange = onValueChanged, label = "Label")
        }

    }
}


@Composable
fun EmeraldTextField(
    state: EmeraldTextFieldState,
    onValueChange: (TextFieldValue) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    placeholder: String = EMPTY,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = true,
    maxLines: Int = MAX_LINES_TEXT_FIELD_DEFAULT,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
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
            label = { Text(text = label, fontWeight = FontWeight.Light) },
            modifier = modifier,
            placeholder = { Text(text = placeholder) },
            enabled = enabled,
            readOnly = readOnly,
            singleLine = singleLine,
            maxLines = maxLines,
            textStyle = textStyle,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            isError = state.error != null,
            visualTransformation = visualTransformation,
            shape = shape,
            interactionSource = interactionSource,
            colors = colors
        )
        Text(
            modifier = Modifier.padding(start = EmeraldDimens.paddingErrorMessageTextField),
            text = state.error ?: EMPTY,
            style = MaterialTheme.typography.overline.copy(color = EmeraldColors.errorColor)
        )
    }
}

const val MAX_LINES_TEXT_FIELD_DEFAULT = 1


