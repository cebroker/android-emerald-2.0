package co.condorlabs.emerald.components.button

sealed class EmeraldButtonState {

    object Loading: EmeraldButtonState()
    object Normal: EmeraldButtonState()
}
