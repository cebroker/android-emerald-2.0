package co.condorlabs.emerald.emeraldgroup

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import co.condorlabs.emerald.components.radiogroup.EmeraldRadioButtonState
import co.condorlabs.emerald.components.radiogroup.EmeraldRadioGroup
import co.condorlabs.emerald.theme.EmeraldTheme
import co.condorlabs.emerald.uiteststubs.base.Page
import org.junit.Assert

class EmeraldGroupButtonPage(private val composeRule: ComposeContentTestRule) : Page() {

    fun launchViewOnClick(
        items: MutableList<EmeraldRadioButtonState>,
        title: String = "",
        messageError: String = "",
    ) = apply {
        launchView(items, title, messageError) { clickedItem ->
            items.forEachIndexed { index, emeraldRadioButtonState ->
                items[index] =
                    emeraldRadioButtonState.copy(value = clickedItem.id == emeraldRadioButtonState.id)
            }
        }
    }


    fun launchView(
        items: List<EmeraldRadioButtonState>,
        title: String = "",
        messageError: String = "",
        enabled: Boolean = true,
        onClick: (state: EmeraldRadioButtonState) -> Unit = {},
    ) = apply {
        composeRule.setContent {
            EmeraldTheme {
                EmeraldRadioGroup(
                    modifier = Modifier.fillMaxWidth(),
                    items = items,
                    title = title,
                    enabled = enabled,
                    error = messageError,
                    onItemClick = {
                        onClick(it)
                    }
                )
            }
        }
    }

    fun validIfTitleIsDisplayed() = apply {
        composeRule.onNodeWithText("This is example radio Group").assertIsDisplayed()
    }

    fun validIfMessageErrorIsDisplayed() = apply {
        composeRule.onNodeWithText("Required").assertIsDisplayed()
    }

    fun validIfTextRadioButtonIsDisplayed(text: String) = apply {
        composeRule.onNodeWithText(text).assertIsDisplayed()
    }

    fun onClickRadioButtonYes() = apply {
        composeRule.onNodeWithText("Yes").performClick()
    }

    fun onValidChangeItem(value: Boolean) {
        Assert.assertEquals(true, value)
    }
}