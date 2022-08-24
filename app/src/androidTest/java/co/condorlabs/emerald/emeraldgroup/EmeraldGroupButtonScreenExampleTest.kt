package co.condorlabs.emerald.emeraldgroup

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.condorlabs.emerald.BaseTestingActivity
import co.condorlabs.emerald.components.radiogroup.EmeraldRadioButtonState
import co.condorlabs.emerald.components.radiogroup.EmeraldRadioGroup
import co.condorlabs.emerald.theme.EmeraldTheme
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalTestApi
@RunWith(AndroidJUnit4::class)
class EmeraldGroupButtonScreenExampleTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<BaseTestingActivity>()

    @Test
    fun givenItemsWhenRadioGroupIsPressedThenShouldChangeTheValueOfTheItemYES() {
        val items = mutableListOf(EmeraldRadioButtonState(0, false, "Yes"),
            EmeraldRadioButtonState(1, false, "No"))

        composeRule.setContent {
            EmeraldTheme {
                EmeraldRadioGroup(
                    modifier = Modifier.fillMaxWidth(),
                    items = items,
                    selection = EmeraldRadioButtonState(0, true, "Yes"),
                    onItemClick = { emerald ->
                        val index = items.indexOfFirst { it.id == it.id }
                        items[index] = emerald.copy(value = !emerald.value)
                    }
                )
            }
        }

        composeRule.onNodeWithText("Yes")
            .assertIsDisplayed()
            .performClick()
        Assert.assertEquals(true, items.first().value)
    }

    @Test
    fun givenItemsAndErrorAndTitleWhenCreatedViewThenShouldShowTheMessageErrorAndTitle() {
        val items = mutableListOf(EmeraldRadioButtonState(0, false, "TEST"))
        val title = "This is example radio Group"
        val messageError = "Required"

        composeRule.setContent {
            EmeraldTheme {
                EmeraldRadioGroup(
                    modifier = Modifier.fillMaxWidth(),
                    items = items,
                    title = title,
                    error = messageError,
                    selection = EmeraldRadioButtonState(0, true, "Yes"),
                    onItemClick = {}
                )
            }
        }

        composeRule.onNodeWithText(title).assertIsDisplayed()
        composeRule.onNodeWithText("TEST").assertIsDisplayed()
        composeRule.onNodeWithText(messageError).assertIsDisplayed()
    }

    @Test
    fun givenItemsDisableWhenCreatedViewThenShouldShowTheMessageErrorAndTitle() {
        val items = mutableListOf(EmeraldRadioButtonState(0, true, "TEST"),
            EmeraldRadioButtonState(1, false, "TEST2"))

        composeRule.setContent {
            EmeraldTheme {
                EmeraldRadioGroup(
                    modifier = Modifier.fillMaxWidth(),
                    items = items,
                    enabled = false,
                    selection = EmeraldRadioButtonState(0, true, "TEST"),
                    onItemClick = {}
                )
            }
        }

        composeRule.onNodeWithText("TEST").assertIsNotEnabled()
        composeRule.onNodeWithText("TEST2").assertIsNotEnabled()
    }
}