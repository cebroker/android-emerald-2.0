package co.condorlabs.emerald.components.textfield

import androidx.compose.ui.text.input.TextFieldValue

data class EmeraldTextFieldState(
    val text: TextFieldValue = TextFieldValue(),
    val error: String? = null
)