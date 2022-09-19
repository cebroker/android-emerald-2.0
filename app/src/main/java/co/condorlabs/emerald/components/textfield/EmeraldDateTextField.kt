package co.condorlabs.emerald.components.textfield

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import co.condorlabs.emerald.R
import co.condorlabs.emerald.components.utils.Empty
import java.util.Calendar
import java.util.Date

@Composable
fun EmeraldDateTextField(
    state: EmeraldTextFieldState,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    onValueDateChange: (Int, Int, Int) -> Unit,
    date: Date = Date(),
    minDate: Date? = null,
    maxDate: Date? = null,
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
    // Fetching the Local Context
    val mContext = LocalContext.current

    // Declaring integer values
    // for year, month and day
    val mYear: Int
    val mMonth: Int
    val mDay: Int

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()
    mCalendar.time = date

    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)


    // Declaring DatePickerDialog and setting
    // initial values as current values (present year, month and day)

    val dateDialog= DatePickerDialog(
        mContext,
        { _: DatePicker, year: Int, month: Int, day: Int ->
            onValueDateChange(year, month, day)
        }, mYear, mMonth, mDay
    )

    if (minDate != null) {
        dateDialog.datePicker.minDate = minDate.time
    }

    if (maxDate != null) {
        dateDialog.datePicker.maxDate = maxDate.time
    }

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
                    dateDialog.show()
                }
            ) {
                Image(painter = painterResource(id = R.drawable.ic_date),
                    contentDescription = stringResource(id = R.string.show_calendar))
            }
        },
        visualTransformation = MaskVisualTransformation("##/##/####"),
        interactionSource = interactionSource,
        shape = shape,
        colors = colors,
    )
}