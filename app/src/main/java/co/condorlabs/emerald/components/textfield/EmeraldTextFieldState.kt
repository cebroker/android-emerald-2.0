package co.condorlabs.emerald.components.textfield

import co.condorlabs.emerald.components.utils.Empty

data class EmeraldTextFieldState(
    val text: String = Empty,
    val error: String? = null
)