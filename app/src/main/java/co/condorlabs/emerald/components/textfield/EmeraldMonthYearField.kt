package co.condorlabs.emerald.components.textfield

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import co.condorlabs.emerald.R
import co.condorlabs.emerald.components.monthyearpicker.EmeraldMonthYearPicker
import co.condorlabs.emerald.components.utils.Empty
import java.util.Calendar
import java.util.Date

@Composable
fun EmeraldMonthYearTextField(
    state: EmeraldTextFieldState,
    onValueChange: (String) -> Unit,
    label: String,
    dialogLabel: String = Empty,
    modifier: Modifier = Modifier,
    onValueDateChange: (Int, Int) -> Unit,
    date: Date = Date(),
    minYear: Int = integerResource(id = R.integer.min_year),
    maxYear: Int = integerResource(id = R.integer.max_year),
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
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = MaterialTheme.shapes.small,
    colors: TextFieldColors = emeraldTextFieldColors()
) {
    val showDialog = remember { mutableStateOf(false)}

    val mCalendar = Calendar.getInstance()
    mCalendar.time = date

    val mYear = mCalendar.get(Calendar.YEAR)
    val mMonth = mCalendar.get(Calendar.MONTH)

    EmeraldMonthYearPicker(
        showDialog = showDialog.value,
        minYear = minYear,
        maxYear = maxYear,
        label = dialogLabel,
        monthSelected = mMonth,
        yearSelected = mYear,
        onConfirmButton = { year, month ->
            onValueDateChange(year, month)
            showDialog.value = false
        },
        onDismissButton = {
            showDialog.value = false
        }
    )

    EmeraldTextField(
        state = state,
        onValueChange = onValueChange,
        label = label,
        modifier = modifier,
        placeholder = placeholder,
        helperTextStart = helperTextStart,
        helperTextEnd = helperTextEnd,
        enabled = enabled,
        readOnly = readOnly,
        singleLine = singleLine,
        maxLines = maxLines,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        keyboardActions = keyboardActions,
        textStyle = textStyle,
        leadingIcon = leadingIcon,
        trailingIcon = {
            IconButton(
                onClick = {
                    showDialog.value = true
                }
            ) {
                Image(painter = painterResource(id = R.drawable.ic_date),
                    contentDescription = stringResource(id = R.string.show_calendar))
            }
        },
        visualTransformation = MaskVisualTransformation("##/####"),
        interactionSource = interactionSource,
        shape = shape,
        colors = colors,
    )
}