package co.condorlabs.emerald.components.textfield

import androidx.compose.ui.text.input.TextFieldValue
import co.condorlabs.emerald.components.utils.Empty

data class EmeraldTextFieldState(
    val text: String = Empty,
    val error: String? = null
)
data class EmeraldTextFieldValueState(
    val error: String? = null,
    val textFieldValue: TextFieldValue = TextFieldValue(text = Empty),
)