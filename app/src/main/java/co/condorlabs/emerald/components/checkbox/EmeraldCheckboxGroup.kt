package co.condorlabs.emerald.components.checkbox

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CheckboxColors
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.text.EmeraldText
import co.condorlabs.emerald.components.text.EmeraldTextStyle
import co.condorlabs.emerald.components.utils.Empty
import co.condorlabs.emerald.theme.EmeraldColors

@Composable
fun EmeraldCheckboxGroup(
    modifier: Modifier,
    title: String = Empty,
    error: String = Empty,
    items: List<EmeraldCheckboxState>,
    onClick: ((EmeraldCheckboxState) -> Unit),
    enabled: Boolean = true,
    textStyle: EmeraldTextStyle = EmeraldTextStyle.SectionBody,
    colors: CheckboxColors = CheckboxDefaults.colors(
        checkedColor = EmeraldColors.InfoColor,
        disabledColor = EmeraldColors.LabelColor
    )
) {

    Column(modifier = modifier) {
        if (title.isNotEmpty()) {
            EmeraldText(text = title, style = EmeraldTextStyle.SectionBody, modifier = Modifier.padding(bottom = 5.dp))
        }

        items.forEach { item ->
            EmeraldCheckbox(
                state = item,
                modifier = Modifier.fillMaxWidth().height(70.dp),
                textStyle = textStyle,
                enabled = enabled,
                colors = colors,
                onClick = {
                    onClick(item)
                }
            )
        }

        if (error.isNotEmpty()) {
            EmeraldText(text = error, style = EmeraldTextStyle.Danger, modifier = Modifier.padding(bottom = 5.dp))
        }
    }
}