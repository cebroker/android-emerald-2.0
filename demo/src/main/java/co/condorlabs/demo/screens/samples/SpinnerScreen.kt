package co.condorlabs.demo.screens.samples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.spinner.EmeraldSpinner
import co.condorlabs.emerald.components.spinner.EmeraldSpinnerState
import co.condorlabs.emerald.theme.EmeraldColors

@Preview
@Composable
fun SpinnerScreenSample() {

    val options =
        mutableListOf(EmeraldSpinnerState("0","Select"),
            EmeraldSpinnerState("1","Alabama"),
            EmeraldSpinnerState("2","Alaska"),
            EmeraldSpinnerState("3","Arizona"))
    val optionsR = remember { options }

    var selectedOptionText by remember { mutableStateOf(EmeraldSpinnerState("0","Select")) }

    var error = ""
    val errors = remember { mutableStateOf(error) }

    Column {
        EmeraldSpinner(
            Modifier
                .padding(horizontal = 10.dp).fillMaxWidth(),
            optionsR,
            selectedOptionText,
            enabled = true,
            error = errors.value,
            label = "Select State",
            onSelectedClick = {
                selectedOptionText = it
                if (it.text == "Select") {
                    error = "Requerido"
                    errors.value = error
                }
                else {
                    errors.value = ""
                }
            }
        )

        EmeraldSpinner(
            Modifier
                .padding(horizontal = 10.dp).fillMaxWidth(),
            optionsR,
            selectedOptionText,
            enabled = false,
            error = errors.value,
            label = "Disabled",
            onSelectedClick = {}
        )
    }
}
