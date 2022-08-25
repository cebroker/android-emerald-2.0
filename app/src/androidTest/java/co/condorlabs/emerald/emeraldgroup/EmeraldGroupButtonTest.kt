package co.condorlabs.emerald.emeraldgroup

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.condorlabs.emerald.BaseTestingActivity
import co.condorlabs.emerald.components.radiogroup.EmeraldRadioButtonState
import co.condorlabs.emerald.uiteststubs.base.Page.Companion.on
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalTestApi
@RunWith(AndroidJUnit4::class)
class EmeraldGroupButtonTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<BaseTestingActivity>()

    @Test
    fun givenItemsWhenRadioGroupIsPressedThenShouldChangeTheValueOfTheItemYES() {
        val items = mutableListOf(EmeraldRadioButtonState(0, false, "Yes"),
            EmeraldRadioButtonState(1, false, "No"))

        on<EmeraldGroupButtonPage>(composeRule)
            .launchViewOnClick(items)
            .validIfTextRadioButtonIsDisplayed("Yes")
            .onClickRadioButtonYes()
            .onValidChangeItem(items.first().value)
    }

    @Test
    fun givenItemsAndErrorAndTitleWhenCreatedViewThenShouldShowTheMessageErrorAndTitle() {
        val items = mutableListOf(EmeraldRadioButtonState(0, false, "TEST"))
        val title = "This is example radio Group"
        val messageError = "Required"

        on<EmeraldGroupButtonPage>(composeRule)
            .launchView(
                items = items,
                title = title,
                messageError = messageError
            )
            .validIfTitleIsDisplayed()
            .validIfTextRadioButtonIsDisplayed("TEST")
            .validIfMessageErrorIsDisplayed()
    }

    @Test
    fun givenItemsDisableWhenCreatedViewThenShouldShowTheMessageErrorAndTitle() {
        val items = mutableListOf(EmeraldRadioButtonState(0, true, "Yes"),
            EmeraldRadioButtonState(1, false, "No"))

        on<EmeraldGroupButtonPage>(composeRule)
            .launchView(items = items, enabled = false)
            .onClickRadioButtonYes()
            .validIfTextRadioButtonIsDisplayed("Yes")
            .validIfTextRadioButtonIsDisplayed("No")
    }
}