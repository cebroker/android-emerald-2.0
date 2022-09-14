package co.condorlabs.emerald.emeraldTextField.page

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldPassword
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldState
import co.condorlabs.emerald.theme.EmeraldTheme
import co.condorlabs.emerald.uiteststubs.base.Page

class EmeraldTextFieldPasswordPage(private val composeRule: ComposeContentTestRule) : Page() {

    fun launchView(
        state: EmeraldTextFieldState,
        label: String
    ) = apply {
        composeRule.setContent {
            EmeraldTheme {
                EmeraldTextFieldPassword(
                    state = state,
                    onValueChange = {},
                    label = label
                )
            }
        }
    }

    fun validateIfShowPasswordLabelIsDisplayed() = apply {
        composeRule.onNodeWithText("Show password").assertIsDisplayed()
    }

    fun validateIfErrorPasswordLabelIsDisplayed() = apply {
        composeRule.onNodeWithText("Error password").assertIsDisplayed()
    }

    fun onClickIconVisibilityOn() = apply {
        composeRule.onNodeWithContentDescription("Show password").performClick()
    }

    fun validateIfPasswordIsDisplayed() = apply {
        composeRule.onNodeWithText("Password1234").assertIsDisplayed()
    }

    fun validateIfErrorPasswordIsDisplayed() = apply {
        composeRule.onNodeWithText("Password invalid").assertIsDisplayed()
    }
}