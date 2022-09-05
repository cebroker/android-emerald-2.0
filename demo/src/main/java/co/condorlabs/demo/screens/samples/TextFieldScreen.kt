package co.condorlabs.demo.screens.samples

import android.util.Patterns
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.textfield.EmeraldEmailTextField
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

    val textStateEmail = remember {
        mutableStateOf(EmeraldTextFieldState())
    }

    val textStateError = remember {
        mutableStateOf(EmeraldTextFieldState())
    }

    val onValueChangedEmpty = { text: String ->
        textStateEmpty.value = textStateEmpty.value.copy(text = text)
    }

    val onValueChangedCorrect = { text: String ->
        textStateCorrect.value = textStateCorrect.value.copy(text = text)
    }

    val onValueChangedEmail = { text: String ->
        if (!text.validateEmail()) {
            textStateEmail.value = textStateEmail.value.copy(text = text, error = "Email is invalid")
        } else {
            textStateEmail.value = textStateEmail.value.copy(text = text, error = null)
        }
    }

    val onValueChangedError = { text: String ->
        textStateError.value = EmeraldTextFieldState(text = text)
        if (text.length > 5) {
            textStateError.value = textStateError.value.copy(text = text, error = "This is an error message")
        }
    }

    Column(modifier = Modifier.padding(10.dp)) {
        EmeraldTextField(
            state = textStateEmpty.value,
            onValueChange = onValueChangedEmpty,
            label = "Normal",
            modifier = Modifier.padding(top = 10.dp)
        )
        EmeraldTextField(
            state = textStateCorrect.value,
            onValueChange = onValueChangedCorrect,
            label = "With placeholder",
            placeholder = "With placeholder",
            modifier = Modifier.padding(top = 10.dp)
        )
        EmeraldEmailTextField(
            state = textStateEmail.value,
            onValueChange = onValueChangedEmail,
            label = "Email",
            placeholder = "With email",
            modifier = Modifier.padding(top = 10.dp)
        )
        EmeraldTextField(
            state = textStateError.value,
            onValueChange = onValueChangedError,
            label = "With error message",
            helperTextStart = "With max length",
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

private fun String.validateEmail() : Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()