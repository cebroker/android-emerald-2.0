package co.condorlabs.emerald.emeraldmonthyeardialog

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import co.condorlabs.emerald.components.monthyearpicker.EmeraldMonthYearPicker
import co.condorlabs.emerald.theme.EmeraldTheme
import co.condorlabs.emerald.uiteststubs.base.Page
import java.util.Calendar

class EmeraldMonthYearDialogPage(private val composeRule: ComposeContentTestRule) : Page() {

    fun launchView(
        isShowDialog : Boolean = true,
        monthSelected: Int = Calendar.getInstance().get(Calendar.MONTH),
        yearSelected: Int = Calendar.getInstance().get(Calendar.YEAR),
        onDismissButton: () -> Unit = {},
        onConfirmButton: (Int, Int) -> Unit = { _, _ ->},
    ) = apply {
        composeRule.setContent {
            EmeraldTheme {
                EmeraldMonthYearPicker(
                    label = "Month year",
                    isShowDialog = isShowDialog,
                    monthSelected = monthSelected,
                    yearSelected = yearSelected,
                    onDismissButton = onDismissButton,
                    onConfirmButton = onConfirmButton,
                )
            }
        }
    }

    fun validateIfIsVisibleDialog() = apply {
        composeRule.onNodeWithText("Month year").assertIsDisplayed()
    }

    fun validateIfMonthTextIsDisplayed() = apply {
        composeRule.onNodeWithText("January").assertIsDisplayed()
    }

    fun validateIfYearTextIsDisplayed() = apply {
        composeRule.onNodeWithText("2020").assertIsDisplayed()
    }

    fun onClickOkButton() = apply {
        composeRule.onNodeWithText("OK").performClick()
    }
}