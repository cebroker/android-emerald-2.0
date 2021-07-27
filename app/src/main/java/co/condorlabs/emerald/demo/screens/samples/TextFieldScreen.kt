package co.condorlabs.emerald.demo.screens.samples

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import co.condorlabs.emerald.components.textfield.EmeraldTextField
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldState

@Composable
fun TextFieldScreenSample() {
    val textStateEmpty = remember {
        mutableStateOf(EmeraldTextFieldState())
    }

    val textStateCorrect = remember {
        mutableStateOf(EmeraldTextFieldState())
    }

    val textStateError = remember {
        mutableStateOf(EmeraldTextFieldState())
    }

    val onValueChangedEmpty = { text: TextFieldValue ->
        textStateEmpty.value = textStateEmpty.value.copy(text = text)
    }

    val onValueChangedCorrect = { text: TextFieldValue ->
        textStateCorrect.value = textStateCorrect.value.copy(text = text)
    }

    val onValueChangedError = { text: TextFieldValue ->
        textStateError.value = EmeraldTextFieldState(text = text)
        if (text.text.length > 5) {
            textStateError.value = textStateError.value.copy(text = text, error = "This is an error message")
        }
    }

    Column {
        EmeraldTextField(
            state = textStateEmpty.value,
            onValueChange = onValueChangedEmpty,
            label = "Normal",
        )
        EmeraldTextField(
            state = textStateCorrect.value,
            onValueChange = onValueChangedCorrect,
            label = "With placeholder",
            placeholder = "With placeholder",
        )
        EmeraldTextField(
            state = textStateError.value,
            onValueChange = onValueChangedError,
            label = "With error message",
            maxLength = 10,
            helperText = "With max length"
        )
    }
}