package co.condorlabs.demo.screens.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.radiogroup.EmeraldRadioButtonState
import co.condorlabs.emerald.components.radiogroup.EmeraldRadioGroup

@Preview
@Composable
fun RadioGroupScreenSample() {
    val selectables = mutableListOf(EmeraldRadioButtonState(0, true, "Yes"),
        EmeraldRadioButtonState(1, false, "No"))

    val selectable = remember { selectables.toMutableStateList() }


    Column{
        EmeraldRadioGroup(
            title = "Any exclusions?",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            items = selectable,
            onItemClick = { clickedItem ->
                selectables.forEachIndexed { index, emeraldRadioButtonState ->
                    selectable[index] = emeraldRadioButtonState.copy(value = clickedItem.id == emeraldRadioButtonState.id)
                }
            }
        )

        EmeraldRadioGroup(
            title = "Message Error",
            error = "Invalid",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            items = selectable,
            onItemClick = { clickedItem ->
                val newState = clickedItem.copy(value = !clickedItem.value)
                val index = selectable.indexOfFirst { it.id == clickedItem.id }
                selectable[index] = newState
            }
        )

        EmeraldRadioGroup(
            title = "Disable Error",
            error = "Disabled",
            enabled = false,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            items = selectable,
            onItemClick = { clickedItem ->
                val newState = clickedItem.copy(value = !clickedItem.value)
                val index = selectable.indexOfFirst { it.id == clickedItem.id }
                selectable[index] = newState
            }
        )
    }
}