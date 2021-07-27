package co.condorlabs.emerald.demo.screens.samples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.button.EmeraldButton
import co.condorlabs.emerald.components.button.EmeraldButtonState
import co.condorlabs.emerald.components.button.EmeraldButtonStyle

@Composable
fun ButtonScreenSample() {
    val currentButtonState: MutableState<EmeraldButtonState> = remember { mutableStateOf(EmeraldButtonState.Normal) }

    Column {
        EmeraldButton(
            text = "Primary Button",
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth(),
            emeraldButtonStyle = EmeraldButtonStyle.EmeraldPrimaryButton,
            emeraldButtonState = currentButtonState.value,
        ) {
            if (currentButtonState.value is EmeraldButtonState.Normal) {
                currentButtonState.value = EmeraldButtonState.Loading
            } else {
                currentButtonState.value = EmeraldButtonState.Normal
            }
        }
        EmeraldButton(
            text = "Success Button",
            emeraldButtonStyle = EmeraldButtonStyle.EmeraldSuccessButton,
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
        ) {}

        EmeraldButton(
            text = "Danger Button",
            emeraldButtonStyle = EmeraldButtonStyle.EmeraldDangerButton,
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
        ) {}
    }

}