package co.condorlabs.emerald.components.radiogroup

import co.condorlabs.emerald.components.utils.Empty

data class EmeraldRadioButtonState(
    val id: Int,
    val value: Boolean = false,
    val text: String = Empty
)