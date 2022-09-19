package co.condorlabs.emerald.emeraldTextField.page

import android.icu.util.Calendar
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import co.condorlabs.emerald.components.textfield.EmeraldDateTextField
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldState
import co.condorlabs.emerald.theme.EmeraldTheme
import co.condorlabs.emerald.uiteststubs.base.Page

class EmeraldDateTextFieldPage(private val composeRule: ComposeContentTestRule) : Page() {

    fun launchView(
        state: EmeraldTextFieldState,
        label: String,
    ) = apply {
        composeRule.setContent {
            EmeraldTheme {
                EmeraldDateTextField(
                    state = state,
                    onValueChange = {},
                    label = label,
                    onValueDateChange = { _, _, _ -> }
                )
            }
        }
    }

    fun launchViewWithDefaultDate(
        state: EmeraldTextFieldState,
        label: String,
    ) = apply {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_MONTH, 19)
        calendar.set(Calendar.MONTH, 8)
        calendar.set(Calendar.YEAR, 2022)

        composeRule.setContent {
            EmeraldTheme {
                EmeraldDateTextField(
                    state = state,
                    onValueChange = {},
                    date = calendar.time,
                    label = label,
                    onValueDateChange = { _, _, _ -> }
                )
            }
        }
    }

    fun validateIfValidLabelIsDisplayed() = apply {
        composeRule.onNodeWithText("Valid date").assertIsDisplayed()
    }

    fun validateIfInvalidLabelIsDisplayed() = apply {
        composeRule.onNodeWithText("Invalid date").assertIsDisplayed()
    }

    fun validateIfShowDatePickerLabelIsDisplayed() = apply {
        composeRule.onNodeWithText("Show date picker").assertIsDisplayed()
    }

    fun validateIfDateTextIsDisplayed() = apply {
        composeRule.onNodeWithText("09/20/2022").assertIsDisplayed()
    }

    fun validateIfInvalidDateIsDisplayed() = apply {
        composeRule.onNodeWithText("35/60/9999").assertIsDisplayed()
    }

    fun validateIfMessageErrorIsDisplayed() = apply {
        composeRule.onNodeWithText("Date is invalid").assertIsDisplayed()
    }

    fun onClickIconShowCalendar() = apply {
        composeRule.onNodeWithContentDescription("Show calendar").performClick()
    }

    fun validateIfDatePickerIsDisplayed() = apply {
        composeRule.onNodeWithText("OK")
    }
}