package co.condorlabs.emerald.emeraldTextField.page

import android.icu.util.Calendar
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import co.condorlabs.emerald.components.textfield.EmeraldMonthYearTextField
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldState
import co.condorlabs.emerald.theme.EmeraldTheme
import co.condorlabs.emerald.uiteststubs.base.Page

class EmeraldMonthYearTextFieldPage(private val composeRule: ComposeContentTestRule) : Page() {

    fun launchView(
        state: EmeraldTextFieldState,
        label: String,
    ) = apply {
        composeRule.setContent {
            EmeraldTheme {
                EmeraldMonthYearTextField(
                    state = state,
                    dialogLabel = "Test Dialog",
                    onValueChange = {},
                    label = label,
                    onValueDateChange = { _, _-> }
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
        calendar.set(Calendar.MONTH, 9)
        calendar.set(Calendar.YEAR, 2022)

        composeRule.setContent {
            EmeraldTheme {
                EmeraldMonthYearTextField(
                    state = state,
                    dialogLabel = "Test Dialog",
                    onValueChange = {},
                    date = calendar.time,
                    label = label,
                    onValueDateChange = { _, _ -> }
                )
            }
        }
    }

    fun validateIfValidLabelIsDisplayed() = apply {
        composeRule.onNodeWithText("Valid month year").assertIsDisplayed()
    }

    fun validateIfInvalidLabelIsDisplayed() = apply {
        composeRule.onNodeWithText("Invalid month year").assertIsDisplayed()
    }

    fun validateIfShowMonthYearPickerLabelIsDisplayed() = apply {
        composeRule.onNodeWithText("Show month year picker").assertIsDisplayed()
    }

    fun validateIfMonthYearTextIsDisplayed() = apply {
        composeRule.onNodeWithText("10/2022").assertIsDisplayed()
    }

    fun validateIfInvalidMonthYearIsDisplayed() = apply {
        composeRule.onNodeWithText("35/9999").assertIsDisplayed()
    }

    fun validateIfMessageErrorIsDisplayed() = apply {
        composeRule.onNodeWithText("Month year is invalid").assertIsDisplayed()
    }

    fun onClickIconShowCalendar() = apply {
        composeRule.onNodeWithContentDescription("Show calendar").performClick()
    }

    fun validateIfMonthYearPickerIsDisplayed() = apply {
        composeRule.onNodeWithText("OK")
    }
}