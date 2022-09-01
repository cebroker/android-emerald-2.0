package co.condorlabs.emerald.spinner

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import co.condorlabs.emerald.components.spinner.EmeraldSpinner
import co.condorlabs.emerald.components.spinner.EmeraldSpinnerState
import co.condorlabs.emerald.theme.EmeraldTheme
import co.condorlabs.emerald.uiteststubs.base.Page

class EmeraldSpinnerPage(private val composeRule: ComposeContentTestRule) : Page() {

    fun launchView(
        items: List<EmeraldSpinnerState>,
        selected: EmeraldSpinnerState,
        label: String = "",
        error: String = "",
        enabled: Boolean = true,
    ) = apply {
        composeRule.setContent {
            EmeraldTheme {
                EmeraldSpinner(
                    modifier = Modifier.fillMaxWidth(),
                    items = items,
                    itemSelected = selected,
                    label = label,
                    enabled = enabled,
                    error = error,
                    onSelectedClick = {}
                )
            }
        }
    }

    fun validIfSelectItemIsDisplayed() = apply {
        composeRule.onNodeWithText("Select").assertIsDisplayed()
    }

    fun showItems() = apply {
        composeRule.onNodeWithText("Select").performClick()
    }

    fun validIfTestIsDisplayed() = apply {
        composeRule.onNodeWithText("Test").assertIsDisplayed()
    }

    fun validIfSelectItemIsNotEnabled() = apply {
        composeRule.onNodeWithText("Select").assertIsNotEnabled()
    }

    fun validIfErrorMessageIsDisplayed() = apply {
        composeRule.onNodeWithText("Required").assertIsDisplayed()
    }
}