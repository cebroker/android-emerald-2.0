package co.condorlabs.emerald.emeraldTextField.page

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithText
import co.condorlabs.emerald.components.textfield.EmeraldPhoneTextField
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldState
import co.condorlabs.emerald.theme.EmeraldTheme
import co.condorlabs.emerald.uiteststubs.base.Page

class EmeraldPhoneTextFieldPage(private val composeRule: ComposeContentTestRule) : Page() {

    fun launchView(
        label: String,
        state: EmeraldTextFieldState,
    ) = apply {
        composeRule.setContent {
            EmeraldTheme {
                EmeraldPhoneTextField(
                    state = state,
                    label = label,
                    onValueChange = {},
                )
            }
        }
    }

    fun validateIfTextIsDisplayed(text: String) = apply {
        composeRule.onNodeWithText(text).assertIsDisplayed()
    }

    fun validateIfLabelIsDisplayed(label: String) = apply {
        composeRule.onNodeWithText(label).assertIsDisplayed()
    }

    fun validateIfErrorIsDisplayed(error: String) = apply {
        composeRule.onNodeWithText(error).assertIsDisplayed()
    }
}