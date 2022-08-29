package co.condorlabs.emerald.components.checkbox

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import co.condorlabs.emerald.components.text.EmeraldTextStyle

@Composable
fun EmeraldCheckbox(
    modifier: Modifier,
    state: EmeraldCheckboxState,
    onClick: () -> Unit,
    textStyle: EmeraldTextStyle,
    enabled: Boolean,
    colors: CheckboxColors,
) {
    Row(modifier = modifier
        .clickable(onClick = onClick, enabled = enabled),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = state.value,
            onCheckedChange = { onClick() },
            enabled = enabled,
            colors = colors
        )
        Text(
            text = AnnotatedString(state.text),
            style = textStyle.getTextStyle(),
            color = textStyle.getColorText()
        )
    }
}