package co.condorlabs.emerald.components.spinner

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.R
import co.condorlabs.emerald.components.text.EmeraldText
import co.condorlabs.emerald.components.text.EmeraldTextStyle
import co.condorlabs.emerald.components.utils.Empty
import co.condorlabs.emerald.theme.EmeraldColors

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EmeraldSpinner(
    modifier: Modifier,
    items: List<EmeraldSpinnerState>,
    itemSelected: EmeraldSpinnerState = items.first(),
    label: String,
    enabled: Boolean = true,
    error: String = Empty,
    textStyle: EmeraldTextStyle = EmeraldTextStyle.SectionBody,
    onSelectedClick: (emerald: EmeraldSpinnerState) -> Unit,
    colors: TextFieldColors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
        focusedBorderColor = EmeraldColors.PrimaryRippleColor,
        errorBorderColor = EmeraldColors.DangerColor,
        focusedLabelColor = EmeraldColors.PrimaryRippleColor
    ),
) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxWidth()) {
        ExposedDropdownMenuBox(
            modifier = modifier.fillMaxWidth(),
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }) {

            OutlinedTextField(
                modifier = modifier.fillMaxWidth(),
                readOnly = true,
                enabled = enabled,
                isError = error.isNotEmpty(),
                value = itemSelected.text,
                onValueChange = { },
                label = { Text(label) },
                trailingIcon = {
                    val iconId = when {
                        error.isNotEmpty() -> {
                            R.drawable.ic_error
                        }
                        !enabled -> {
                            R.drawable.ic_gray_down_arrow
                        }
                        else -> {
                            R.drawable.ic_down_arrow
                        }
                    }
                    Image(painter = painterResource(id = iconId), contentDescription = null)
                },
                colors = colors
            )
            ExposedDropdownMenu(
                modifier = modifier.fillMaxWidth(),
                expanded = expanded && enabled,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                items.forEachIndexed { index, selectionOption ->
                    DropdownMenuItem(
                        enabled = enabled,
                        onClick = {
                            onSelectedClick(selectionOption)
                            expanded = false
                        }
                    ) {
                        Text(
                            text = selectionOption.text,
                            style = textStyle.getTextStyle(),
                            color = if (index == 0) {
                                EmeraldColors.LabelColor
                            } else {
                                EmeraldColors.TextColor
                            }
                        )
                    }
                }
            }
        }

        if (error.isNotEmpty()) {
            EmeraldText(text = error, style = EmeraldTextStyle.Danger, modifier = modifier.padding(horizontal = 10.dp))
        }
    }
}