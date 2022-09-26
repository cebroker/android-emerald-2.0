package co.condorlabs.demo.screens.samples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.button.EmeraldButton
import co.condorlabs.emerald.components.button.EmeraldButtonState
import co.condorlabs.emerald.components.button.EmeraldButtonStyle
import co.condorlabs.emerald.components.monthyearpicker.EmeraldMonthYearPicker

@Composable
fun ButtonScreenSample() {
    Column(modifier = Modifier.padding(10.dp)) {
        val currentButtonState: MutableState<EmeraldButtonState> = remember { mutableStateOf(EmeraldButtonState.Normal) }
        val isShowDialog = remember { mutableStateOf(false) }

        EmeraldButton(
            text = "Primary Button",
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth(),
            emeraldButtonStyle = EmeraldButtonStyle.EmeraldPrimaryButton,
            emeraldButtonState = currentButtonState.value
        ) {
            if (currentButtonState.value is EmeraldButtonState.Normal) {
                currentButtonState.value = EmeraldButtonState.Loading
            } else {
                currentButtonState.value = EmeraldButtonState.Normal
            }
        }

        EmeraldButton(
            text = "Primary Button Disabled",
            emeraldButtonStyle = EmeraldButtonStyle.EmeraldSuccessButton,
            modifier = Modifier
                .padding(top = 10.dp)
                .height(40.dp)
                .fillMaxWidth(),
            enabled = false,
        ) {}

        EmeraldButton(
            text = "Success Button",
            emeraldButtonStyle = EmeraldButtonStyle.EmeraldSuccessButton,
            modifier = Modifier
                .padding(top = 10.dp)
                .height(40.dp)
                .fillMaxWidth()
        ) {}

        EmeraldButton(
            text = "Danger Button",
            emeraldButtonStyle = EmeraldButtonStyle.EmeraldDangerButton,
            modifier = Modifier
                .padding(top = 10.dp)
                .height(40.dp)
                .fillMaxWidth()
        ) {}

        EmeraldButton(
            text = "Warning Button",
            emeraldButtonStyle = EmeraldButtonStyle.EmeraldWarningButton,
            modifier = Modifier
                .padding(top = 10.dp)
                .height(40.dp)
                .fillMaxWidth()
        ) {}

        EmeraldButton(
            text = "Overlay Button",
            emeraldButtonStyle = EmeraldButtonStyle.EmeraldOverlayButton,
            modifier = Modifier
                .padding(top = 10.dp)
                .height(40.dp)
                .fillMaxWidth()
        ) {}

        EmeraldButton(
            text = "Default Button",
            emeraldButtonStyle = EmeraldButtonStyle.EmeraldDefaultButton,
            modifier = Modifier
                .padding(top = 10.dp)
                .height(40.dp)
                .fillMaxWidth()
        ) {}

        EmeraldButton(
            text = "Flat Button",
            emeraldButtonStyle = EmeraldButtonStyle.EmeraldFlatPrimaryButton,
            modifier = Modifier
                .padding(top = 10.dp)
                .height(40.dp)
                .fillMaxWidth()
        ) {}

        EmeraldButton(
            text = "Shape white Button",
            emeraldButtonStyle = EmeraldButtonStyle.EmeraldShapeWhiteButton,
            modifier = Modifier
                .padding(bottom = 10.dp)
                .height(40.dp)
                .fillMaxWidth()
        ) {}

        EmeraldButton(
            text = "Open month year dialog",
            emeraldButtonStyle = EmeraldButtonStyle.EmeraldPrimaryButton,
            modifier = Modifier
                .padding(bottom = 10.dp)
                .height(40.dp)
                .fillMaxWidth()
        ) {
            isShowDialog.value = true
        }

        EmeraldMonthYearPicker(
            isShowDialog = isShowDialog.value,
            onConfirmButton = { month, year ->
                isShowDialog.value = false
            },
            onDismissButton = {
                isShowDialog.value = false
            }
        )
    }

}