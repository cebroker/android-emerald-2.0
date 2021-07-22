package co.condorlabs.emerald.components.custombutton

sealed class ButtonState {

    object Loading: ButtonState()
    object Normal: ButtonState()
}
