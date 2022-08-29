package co.condorlabs.emerald.components.radiogroup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.text.EmeraldTextStyle
import co.condorlabs.emerald.theme.EmeraldColors

@Composable
fun EmeraldRadioButton(
    state: EmeraldRadioButtonState,
    modifier: Modifier = Modifier,
    textStyle: EmeraldTextStyle,
    enabled: Boolean,
    colors: RadioButtonColors,
    onClick: (() -> Unit),
) {
    Row(
        modifier = modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .border(BorderStroke(1.dp, color = if (state.value && enabled) {
                EmeraldColors.PrimaryRippleColor
            } else {
                EmeraldColors.LabelColor
            }
            ), shape = RoundedCornerShape(10.dp))
            .clickable(onClick = onClick, enabled = enabled),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = state.value,
            onClick = onClick,
            enabled = enabled,
            colors = colors
        )
        Text(
            text = AnnotatedString(state.text),
            style = textStyle.getTextStyle(),
            color = textStyle.getColorText(),
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}