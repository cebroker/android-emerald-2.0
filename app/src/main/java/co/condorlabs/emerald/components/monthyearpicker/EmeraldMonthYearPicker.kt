package co.condorlabs.emerald.components.monthyearpicker

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import co.condorlabs.emerald.R
import co.condorlabs.emerald.components.utils.Empty
import co.condorlabs.emerald.theme.EmeraldColors
import com.chargemap.compose.numberpicker.ListItemPicker
import com.chargemap.compose.numberpicker.NumberPicker
import java.util.Calendar

@Composable
fun EmeraldMonthYearPicker(
    modifier: Modifier = Modifier,
    showDialog: Boolean = false,
    minYear: Int = integerResource(id = R.integer.min_year),
    maxYear: Int = integerResource(id = R.integer.max_year),
    monthSelected: Int = Calendar.getInstance().get(Calendar.MONTH),
    yearSelected: Int = Calendar.getInstance().get(Calendar.YEAR),
    label: String = Empty,
    confirmText: String = stringResource(id = R.string.ok),
    dismissText: String = stringResource(id = R.string.cancel),
    onDismissButton: () -> Unit,
    onConfirmButton: (Int, Int) -> Unit,
) {

    val months = stringArrayResource(id = R.array.months)
    var state by remember { mutableStateOf(months[monthSelected]) }
    var pickerValue by remember { mutableStateOf(yearSelected) }

    if (showDialog) {
        AlertDialog(onDismissRequest = onDismissButton,
            title = { Text(text = label, fontWeight = FontWeight.Light) },
            text = {
                Row(modifier = modifier.fillMaxWidth()) {
                    ListItemPicker(
                        label = { it },
                        value = state,
                        onValueChange = {
                            state = it
                        },
                        list = months.toList(),
                        modifier = modifier
                            .fillMaxWidth(.5f)
                            .padding(end = dimensionResource(id = R.dimen.padding_end_month)),
                        dividersColor = EmeraldColors.InfoColor
                    )

                    NumberPicker(
                        value = pickerValue,
                        range = minYear..maxYear,
                        onValueChange = {
                            pickerValue = it
                        },
                        modifier = modifier.fillMaxWidth(),
                        dividersColor = EmeraldColors.InfoColor
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    onConfirmButton(months.indexOfFirst { it == state }, pickerValue)
                }) {
                    Text(
                        text = confirmText,
                        color = EmeraldColors.InfoColor
                    )
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    onDismissButton()
                }) {
                    Text(
                        text = dismissText,
                        color = EmeraldColors.InfoColor
                    )
                }
            }
        )
    }
}