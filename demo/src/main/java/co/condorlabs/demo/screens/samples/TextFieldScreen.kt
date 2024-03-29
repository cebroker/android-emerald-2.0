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
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import co.condorlabs.demo.R
import co.condorlabs.emerald.components.textfield.EmeraldMonthYearTextField
import co.condorlabs.emerald.components.textfield.EmeraldDateTextField
import co.condorlabs.emerald.components.textfield.EmeraldPasswordTextField
import co.condorlabs.emerald.components.textfield.EmeraldPhoneTextField
import co.condorlabs.emerald.components.textfield.EmeraldTextField
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldState
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldValueState
import java.math.BigDecimal
import java.text.NumberFormat
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

    val textStateMonthYear = remember {
        mutableStateOf(EmeraldTextFieldState())
    }

    val textStateEmail = remember {
        mutableStateOf(EmeraldTextFieldState())
    }

    val textStateCurrency = remember {
        mutableStateOf(EmeraldTextFieldValueState())
    }

    val textStatePhone = remember {
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

    val onValueChangedPhone = { text: String ->
        if (text.matches("^\\d{0,$MAX_PHONE_LENGTH}\$".toRegex())) {
            textStatePhone.value = textStatePhone.value.copy(text = text)
        }
    }

    val onValueChangeCurrency = { textFieldValue: TextFieldValue ->
        val numberFormat = NumberFormat.getCurrencyInstance()
        textFieldValue.text.replace("""[$,.]""".toRegex(), "").let {
            with(textStateCurrency.value) {
                val newText = if (!isAllowedAmount(it)) numberFormat.format((maxAmount.toDouble() / ONE_HUNDRED)) else numberFormat.format((it.toDouble() / ONE_HUNDRED))
                textStateCurrency.value = this.copy(
                    textFieldValue = this.textFieldValue.copy(
                        text = newText,
                        selection = TextRange(newText.length, newText.length)
                    )
                )
            }
        }
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
        if (text.matches("^\\d{0,$MAX_DATE_LENGTH}\$".toRegex())) {
            if (text.length == MAX_DATE_LENGTH && text != textStateDate.value.text) {
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.MONTH, text.substring(0, 2).toInt() - 1)
                calendar.set(Calendar.DAY_OF_MONTH, text.substring(2, 4).toInt())
                calendar.set(Calendar.YEAR, text.substring(4, 8).toInt())

                val format = SimpleDateFormat("MMddyyyy", Locale.getDefault())
                textStateDate.value = EmeraldTextFieldState(text = format.format(calendar.time))
            } else {
                textStateDate.value = EmeraldTextFieldState(text = text)
            }
        }
    }

    val onValueChangedMonthYear = { text: String ->
        if (text.matches("^\\d{0,$MAX_MONTH_YEAR_LENGTH}\$".toRegex())) {
            if (text.length == MAX_MONTH_YEAR_LENGTH && text != textStateMonthYear.value.text) {
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.MONTH, text.substring(0, 2).toInt() - 1)
                calendar.set(Calendar.YEAR, text.substring(2, 6).toInt())

                val format = SimpleDateFormat("MMyyyy", Locale.getDefault())
                textStateMonthYear.value = EmeraldTextFieldState(text = format.format(calendar.time))
            } else {
                textStateMonthYear.value = EmeraldTextFieldState(text = text)
            }
        }
     }

    val min = Calendar.getInstance()
    min.set(Calendar.YEAR, 2020)
    min.set(Calendar.MONTH, 1)
    min.set(Calendar.DAY_OF_MONTH, 1)

    val max = Calendar.getInstance()
    max.set(Calendar.YEAR, 2022)
    max.set(Calendar.MONTH, 11)
    max.set(Calendar.DAY_OF_MONTH, 31)

    Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_all_text_field_screen))) {
        EmeraldTextField(
            state = textStateEmpty.value,
            onValueChange = onValueChangedEmpty,
            label = "Normal",
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_top_text_field))
        )
        EmeraldTextField(
            state = textStateCorrect.value,
            onValueChange = onValueChangedCorrect,
            label = "With placeholder",
            placeholder = "With placeholder",
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_top_text_field))
        )
        EmeraldTextField(
            state = textStateEmail.value,
            onValueChange = onValueChangedEmail,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = "Email",
            placeholder = "With email",
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_top_text_field))
        )
        EmeraldPhoneTextField(
            state = textStatePhone.value,
            onValueChange = onValueChangedPhone,
            label = "Phone number",
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_top_text_field))
        )
        EmeraldTextField(
            label = "Currency",
            placeholder = "With currency",
            state = textStateCurrency.value,
            onValueChange = { onValueChangeCurrency(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_top_text_field))
        )
        EmeraldTextField(
            state = textStateError.value,
            onValueChange = onValueChangedError,
            label = "With error message",
            helperTextStart = "With max length",
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_top_text_field))
        )
        EmeraldPasswordTextField(
            state = textStatePassword.value,
            onValueChange = onValueChangedPassword,
            label = stringResource(id = R.string.password),
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_top_text_field))
        )
        EmeraldMonthYearTextField(
            state = textStateMonthYear.value,
            onValueChange = onValueChangedMonthYear,
            label = stringResource(id = R.string.month_year_picker),
            date = Date(),
            minYear = min.get(Calendar.YEAR),
            maxYear = max.get(Calendar.YEAR),
            onValueDateChange = { month, year ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month - 1)

                val format = SimpleDateFormat("MMyyyy", Locale.getDefault())
                onValueChangedMonthYear(format.format(calendar.time))
            })
        EmeraldDateTextField(
            state = textStateDate.value,
            onValueChange = onValueChangedDate,
            minDate = min.time,
            maxDate = max.time,
            label = "DatePicker",
            onValueDateChange = { year, month, day ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month - 1)
                calendar.set(Calendar.DAY_OF_MONTH, day)

                val format = SimpleDateFormat("MMddyyyy", Locale.getDefault())
                onValueChangedDate(format.format(calendar.time))
            }
        )
    }
}

fun BigDecimal.lessThan(value: BigDecimal): Boolean {
    return compareTo(value) == -1
}

fun BigDecimal.equalThan(value: BigDecimal): Boolean {
    return compareTo(value) == 0
}

private fun isAllowedAmount(currentAmount: String): Boolean {
    return currentAmount.toDouble().toBigDecimal().let {
        it.lessThan(maxAmount) || it.equalThan(maxAmount)
    }
}

private fun String.validateEmail() : Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()
private const val ONE_HUNDRED = 100
private const val MAX_DATE_LENGTH = 8
private const val MAX_PHONE_LENGTH = 10
private const val MAX_MONTH_YEAR_LENGTH = 6
private const val MONEY_MAX_AMOUNT = 100000000000000
private val maxAmount = MONEY_MAX_AMOUNT.toBigDecimal()
