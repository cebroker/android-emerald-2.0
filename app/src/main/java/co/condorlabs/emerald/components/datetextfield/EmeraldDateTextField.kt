package co.condorlabs.emerald.components.datetextfield

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextFieldColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.CalendarViewDay
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import co.condorlabs.emerald.components.textfield.EmeraldTextField
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldState
import co.condorlabs.emerald.components.textfield.MaxLinesTextFieldDefault
import co.condorlabs.emerald.components.textfield.emeraldTextFieldColors
import co.condorlabs.emerald.components.utils.Empty
import java.util.Calendar
import java.util.Date

@Composable
fun EmeraldDateTextField(
    date: Date,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
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

    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = date

    // Declaring a string value to
    // store date in string format
    val mDate = remember { mutableStateOf(EmeraldTextFieldState()) }

    // Declaring DatePickerDialog and setting
    // initial values as current values (present year, month and day)

    EmeraldTextField(
        state = mDate.value,
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
                    DatePickerDialog(
                        mContext,
                        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                            mDate.value = mDate.value.copy(text = "$mDayOfMonth/${mMonth + 1}/$mYear")
                        }, mYear, mMonth, mDay
                    ).show()
                },
                modifier = modifier.testTag("ShowCalendar")
            ) {
                Icon(imageVector = Icons.Filled.CalendarViewDay, "Show calendar")
            }
        },
        visualTransformation = VisualTransformation.None,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors,
    )

}