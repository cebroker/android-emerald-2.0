package co.condorlabs.demo.screens.samples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.radiogroup.EmeraldRadioButtonState
import co.condorlabs.emerald.components.radiogroup.EmeraldRadioGroup

@Preview
@Composable
fun RadioGroupScreenSample() {
    val selectable = mutableListOf(EmeraldRadioButtonState(0, false, "Yes"),
        EmeraldRadioButtonState(1, false, "No"))

    val currentSelection = remember { mutableStateOf(selectable.first()) }

    Column {
        EmeraldRadioGroup(
            title = "Any exclusions?",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            items = selectable,
            selection = currentSelection.value,
            onItemClick = { clickedItem ->
                val newState = clickedItem.copy(value = !clickedItem.value)
                val index = selectable.indexOfFirst { it.id == clickedItem.id }
                selectable[index] = newState
                currentSelection.value = newState
            }
        )

        EmeraldRadioGroup(
            title = "Message Error",
            error = "Invalid",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            items = selectable,
            selection = currentSelection.value,
            onItemClick = { clickedItem ->
                val newState = clickedItem.copy(value = !clickedItem.value)
                val index = selectable.indexOfFirst { it.id == clickedItem.id }
                selectable[index] = newState
                currentSelection.value = newState
            }
        )

        EmeraldRadioGroup(
            title = "Message Error",
            error = "Disabled",
            enabled = false,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            items = selectable,
            selection = currentSelection.value,
            onItemClick = { clickedItem ->
                val newState = clickedItem.copy(value = !clickedItem.value)
                val index = selectable.indexOfFirst { it.id == clickedItem.id }
                selectable[index] = newState
                currentSelection.value = newState
            }
        )
    }
}