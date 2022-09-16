package co.condorlabs.demo.screens.samples

import android.util.Patterns
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.datetextfield.EmeraldDateTextField
import co.condorlabs.demo.R
import co.condorlabs.emerald.components.textfield.EmeraldTextField
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldPassword
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldState
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun TextFieldScreenSample() {
    val textStateEmpty = remember {
        mutableStateOf(EmeraldTextFieldState())
    }

    val textStateCorrect = remember {
        mutableStateOf(EmeraldTextFieldState())
    }

    val textStatePassword = remember {
        mutableStateOf(EmeraldTextFieldState())
    }

    val textStateDate = remember {
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

    val onValueChangedPassword = { text: String ->
        textStatePassword.value = textStatePassword.value.copy(text = text)
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
            textStateError.value =
                textStateError.value.copy(text = text, error = "This is an error message")
        }
    }

    val onValueChangedDate = { text: String ->
        textStateDate.value = EmeraldTextFieldState(text = text)
    }

    val min = Calendar.getInstance()
    min.set(Calendar.YEAR, 2020)
    min.set(Calendar.MONTH, 1)
    min.set(Calendar.DAY_OF_MONTH, 1)

    val max = Calendar.getInstance()
    max.set(Calendar.YEAR, 2022)
    max.set(Calendar.MONTH, 11)
    max.set(Calendar.DAY_OF_MONTH, 31)

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
        EmeraldTextField(
            state = textStateEmail.value,
            onValueChange = onValueChangedEmail,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
        EmeraldTextFieldPassword(
            state = textStatePassword.value,
            onValueChange = onValueChangedPassword,
            label = stringResource(id = R.string.password),
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.paddig_top_text_field))
        )

        EmeraldDateTextField(
            state = textStateDate.value,
            onValueChange = onValueChangedDate,
            minDate = min.time,
            maxDate = max.time,
            label = "DatePicker",
            onValueDateChange = { year, month, day ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, day)

                val format = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
                onValueChangedDate(format.format(calendar.time))
            }
        )
    }
}

private fun String.validateEmail() : Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()