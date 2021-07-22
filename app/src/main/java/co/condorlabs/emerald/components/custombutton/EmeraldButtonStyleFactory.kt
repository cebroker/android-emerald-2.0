package co.condorlabs.emerald.components.custombutton

class EmeraldButtonStyleFactory {

    fun getEmeraldButtonStyle(emeraldTypeButton: String): EmeraldButtonStyle {
        return when (emeraldTypeButton) {
            BUTTON_PRIMARY_TYPE -> EmeraldButtonStyle.EmeraldPrimaryButton
            BUTTON_SUCCESS_TYPE -> EmeraldButtonStyle.EmeraldSuccessButton
            BUTTON_DANGER_TYPE -> EmeraldButtonStyle.EmeraldDangerButton
            else -> EmeraldButtonStyle.EmeraldPrimaryButton
        }
    }
}