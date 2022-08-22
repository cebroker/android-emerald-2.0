package co.condorlabs.emerald.components.radiogroup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.RadioButtonColors
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.text.EmeraldTextStyle
import co.condorlabs.emerald.theme.EmeraldColors

@Composable
fun EmeraldRadioGroup(
    modifier: Modifier,
    items: List<EmeraldRadioButtonState>,
    selection: EmeraldRadioButtonState,
    onItemClick: ((EmeraldRadioButtonState) -> Unit),
    enabled: Boolean = true,
    textStyle: EmeraldTextStyle = EmeraldTextStyle.SectionBody,
    colors: RadioButtonColors = RadioButtonDefaults.colors(
        selectedColor = EmeraldColors.InfoColor,
        disabledColor = EmeraldColors.LabelColor
    ),
) {
    Column(modifier = modifier) {
        items.forEach { item ->
            EmeraldRadioButton(
                state = item,
                selection = selection,
                modifier = Modifier.fillMaxWidth(),
                textStyle = textStyle,
                enabled = enabled,
                colors = colors,
                onClick = {
                    onItemClick(item)
                },
            )
            Spacer(modifier = Modifier.size(10.dp))
        }
        /*Box(modifier = Modifier.fillMaxWidth()) {
            if ((state.error != null) or helperTextStart.isNotBlank()) {
                TextFieldHelperText(alignment = Alignment.TopStart, text = helperTextStart, error = state.error)
            }
            if (helperTextEnd.isNotBlank()) {
                TextFieldHelperText(alignment = Alignment.TopEnd, text = helperTextStart, error = state.error)
            }
        }*/
    }
}