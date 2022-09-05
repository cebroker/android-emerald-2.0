package co.condorlabs.emerald.emeraldTextField

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithText
import co.condorlabs.emerald.components.textfield.EmeraldEmailTextField
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldState
import co.condorlabs.emerald.theme.EmeraldTheme
import co.condorlabs.emerald.uiteststubs.base.Page

class EmeraldEmailTextFieldPage(private val composeRule: ComposeContentTestRule) : Page() {

    fun launchView(
        state: EmeraldTextFieldState,
        label: String
    ) = apply {
        composeRule.setContent {
            EmeraldTheme {
                EmeraldEmailTextField(
                    state = state,
                    onValueChange = {},
                    label = label)
            }
        }
    }

    fun validIfLabelEmailInvalidIsDisplayed() = apply {
        composeRule.onNodeWithText("Email invalid").assertIsDisplayed()
    }

    fun validIfLabelEmailValidIsDisplayed() = apply {
        composeRule.onNodeWithText("Email valid").assertIsDisplayed()
    }

    fun validIfInvalidEmailIsDisplayed() = apply {
        composeRule.onNodeWithText("email@.").assertIsDisplayed()
    }

    fun validIfValidEmailIsDisplayed() = apply {
        composeRule.onNodeWithText("email@ec.com").assertIsDisplayed()
    }

    fun validIfMessageErrorIsDisplayed() = apply {
        composeRule.onNodeWithText("Email is invalid").assertIsDisplayed()
    }
}