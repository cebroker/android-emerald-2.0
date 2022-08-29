package co.condorlabs.demo.screens.samples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.checkbox.EmeraldCheckboxGroup
import co.condorlabs.emerald.components.checkbox.EmeraldCheckboxState

@Preview
@Composable
fun CheckboxScreenSample() {
    val selectables = mutableListOf(EmeraldCheckboxState(0, true, "Unlimited limits"),
        EmeraldCheckboxState(1, false, "Unlimited limits"))
    val selectable = remember { selectables.toMutableStateList() }

    val selectables2 = mutableListOf(EmeraldCheckboxState(0, false, "Hello"),
        EmeraldCheckboxState(1, false, "Bye"))

    val selectable2 = remember { selectables2.toMutableStateList() }

    val selectables3 = mutableListOf(EmeraldCheckboxState(0, false, "Test"),
        EmeraldCheckboxState(1, true, "Test2"))

    val selectable3 = remember { selectables3.toMutableStateList() }

    Column {
        EmeraldCheckboxGroup(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            items = selectable,
            onClick = { clickedItem ->
                selectables.forEachIndexed { index, emeraldRadioButtonState ->
                    if (emeraldRadioButtonState.id == clickedItem.id) {
                        selectable[index] = clickedItem.copy(value = !clickedItem.value)
                    }
                }
            })

        EmeraldCheckboxGroup(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            items = selectable2,
            title = "Message Error",
            error = "Invalid",
            onClick = { clickedItem ->
                selectables2.forEachIndexed { index, emeraldRadioButtonState ->
                    if (emeraldRadioButtonState.id == clickedItem.id) {
                        selectable[index] = clickedItem.copy(value = !clickedItem.value)
                    }
                }
            })

        EmeraldCheckboxGroup(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            items = selectable3,
            title = "Disabled Items",
            error = "Disabled",
            enabled = false,
            onClick = {})
    }
}