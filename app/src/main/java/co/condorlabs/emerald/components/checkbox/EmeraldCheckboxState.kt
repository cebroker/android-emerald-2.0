package co.condorlabs.emerald.components.checkbox

import co.condorlabs.emerald.components.utils.Empty

data class EmeraldCheckboxState(
    val id: Int,
    val value: Boolean = false,
    val text: String = Empty
)
