package co.condorlabs.emerald.components.radiogroup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.RadioButtonColors
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.text.EmeraldText
import co.condorlabs.emerald.components.text.EmeraldTextStyle
import co.condorlabs.emerald.components.utils.Empty
import co.condorlabs.emerald.theme.EmeraldColors

@Composable
fun EmeraldRadioGroup(
    modifier: Modifier,
    title: String = Empty,
    error: String = Empty,
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
        if (title.isNotEmpty()) {
            EmeraldText(text = title, style = EmeraldTextStyle.SectionBody, modifier = Modifier.padding(bottom = 5.dp))
        }

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

        if (error.isNotEmpty()) {
            EmeraldText(text = error, style = EmeraldTextStyle.Danger, modifier = Modifier.padding(bottom = 5.dp))
        }
    }
}