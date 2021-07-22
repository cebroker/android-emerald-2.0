package co.condorlabs.emerald.components.textfield

import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import co.condorlabs.emerald.theme.EmeraldColors

@Composable
fun emeraldTextFieldColors(): TextFieldColors {
    return TextFieldDefaults.outlinedTextFieldColors(
        errorBorderColor = EmeraldColors.errorColor,
        errorLabelColor = EmeraldColors.errorColor,
        focusedLabelColor = EmeraldColors.primaryColor,
        focusedBorderColor = EmeraldColors.primaryColor,
        cursorColor = EmeraldColors.primaryColor,
        unfocusedLabelColor = EmeraldColors.labelColor,
        unfocusedBorderColor = EmeraldColors.labelColor,
    )
}
