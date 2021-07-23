package co.condorlabs.emerald.components.textfield

import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import co.condorlabs.emerald.theme.EmeraldColors

@Composable
fun emeraldTextFieldColors(): TextFieldColors {
    return TextFieldDefaults.outlinedTextFieldColors(
        errorBorderColor = EmeraldColors.DangerColor,
        errorLabelColor = EmeraldColors.DangerColor,
        focusedLabelColor = EmeraldColors.InfoColor,
        focusedBorderColor = EmeraldColors.InfoColor,
        cursorColor = EmeraldColors.InfoColor,
        unfocusedLabelColor = EmeraldColors.LabelColor,
        unfocusedBorderColor = EmeraldColors.LabelColor,
    )
}
