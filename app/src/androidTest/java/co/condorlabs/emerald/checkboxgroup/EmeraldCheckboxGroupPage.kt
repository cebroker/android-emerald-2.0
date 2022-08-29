package co.condorlabs.emerald.checkboxgroup

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import co.condorlabs.emerald.components.checkbox.EmeraldCheckboxGroup
import co.condorlabs.emerald.components.checkbox.EmeraldCheckboxState
import co.condorlabs.emerald.theme.EmeraldTheme
import co.condorlabs.emerald.uiteststubs.base.Page
import org.junit.Assert

class EmeraldCheckboxGroupPage(private val composeRule: ComposeContentTestRule) : Page() {

    fun launchViewOnClick(
        items: MutableList<EmeraldCheckboxState>,
        title: String = "",
        messageError: String = "",
    ) = apply {
        launchView(items, title, messageError) { clickedItem ->
            items.forEachIndexed { index, emeraldCheckboxState ->
                if (emeraldCheckboxState.id == clickedItem.id) {
                    items[index] = clickedItem.copy(value = !clickedItem.value)
                }
            }
        }
    }

    fun launchView(
        items: List<EmeraldCheckboxState>,
        title: String = "",
        messageError: String = "",
        enabled: Boolean = true,
        onClick: (state: EmeraldCheckboxState) -> Unit = {},
    ) = apply {
        composeRule.setContent {
            EmeraldTheme {
                EmeraldCheckboxGroup(
                    modifier = Modifier.fillMaxWidth(),
                    items = items,
                    title = title,
                    enabled = enabled,
                    error = messageError,
                    onClick = onClick
                )
            }
        }
    }

    fun validIfTitleIsDisplayed() = apply {
        composeRule.onNodeWithText("This is example checkbox").assertIsDisplayed()
    }

    fun validIfMessageErrorIsDisplayed() = apply {
        composeRule.onNodeWithText("Required").assertIsDisplayed()
    }

    fun validIfTextCheckboxIsDisplayed(text: String) = apply {
        composeRule.onNodeWithText(text).assertIsDisplayed()
    }

    fun onClickCheckboxOne() = apply {
        composeRule.onNodeWithText("Checkbox 1").performClick()
    }

    fun onClickCheckboxTwo() = apply {
        composeRule.onNodeWithText("Checkbox 2").performClick()
    }

    fun onValidChangeItem(expected: Boolean, value: Boolean) = apply {
        Assert.assertEquals(expected, value)
    }
}