package co.condorlabs.emerald.checkboxgroup

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.condorlabs.emerald.BaseTestingActivity
import co.condorlabs.emerald.components.checkbox.EmeraldCheckboxState
import co.condorlabs.emerald.uiteststubs.base.Page
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalTestApi
@RunWith(AndroidJUnit4::class)
class EmeraldCheckboxGroupTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<BaseTestingActivity>()

    @Test
    fun givenItemsWhenCheckboxGroupIsPressedThenShouldChangeTheValueOfBothItems() {
        val items = mutableListOf(EmeraldCheckboxState(0, true, "Checkbox 1"),
            EmeraldCheckboxState(1, false, "Checkbox 2"))

        Page.on<EmeraldCheckboxGroupPage>(composeRule)
            .launchViewOnClick(items)
            .validIfTextCheckboxIsDisplayed("Checkbox 1")
            .onClickCheckboxOne()
            .onValidChangeItem(
                expected = false,
                value = items.first().value)
            .validIfTextCheckboxIsDisplayed("Checkbox 2")
            .onClickCheckboxTwo()
            .onValidChangeItem(
                expected = true,
                value = items.last().value)
    }

    @Test
    fun givenItemsAndErrorAndTitleWhenCreatedViewThenShouldShowTheMessageErrorAndTitle() {
        val items = mutableListOf(EmeraldCheckboxState(0, false, "TEST"))
        val title = "This is example checkbox"
        val messageError = "Required"

        Page.on<EmeraldCheckboxGroupPage>(composeRule)
            .launchView(
                items = items,
                title = title,
                messageError = messageError
            )
            .validIfTitleIsDisplayed()
            .validIfTextCheckboxIsDisplayed("TEST")
            .validIfMessageErrorIsDisplayed()
    }

    @Test
    fun givenItemsDisableWhenCreatedViewThenShouldShowTheMessageErrorAndTitleAndTheValuesShouldNotChange() {
        val items = mutableListOf(EmeraldCheckboxState(0, true, "Checkbox 1"),
            EmeraldCheckboxState(1, false, "Checkbox 2"))

        Page.on<EmeraldCheckboxGroupPage>(composeRule)
            .launchView(items = items, enabled = false)
            .validIfTextCheckboxIsDisplayed("Checkbox 1")
            .onClickCheckboxOne()
            .onValidChangeItem(
                expected = true,
                value = items.first().value)
            .validIfTextCheckboxIsDisplayed("Checkbox 2")
            .onClickCheckboxTwo()
            .onValidChangeItem(
                expected = false,
                value = items.last().value)

    }
}