package co.condorlabs.emerald.spinner

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.condorlabs.emerald.BaseTestingActivity
import co.condorlabs.emerald.components.spinner.EmeraldSpinnerState
import co.condorlabs.emerald.uiteststubs.base.Page.Companion.on
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalTestApi
@RunWith(AndroidJUnit4::class)
class EmeraldSpinnerTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<BaseTestingActivity>()

    @Test
    fun givenItemListWhenTheViewIsCreatedAndPressTheSpinnerThenShouldShowTheListItems() {
        val items = mutableListOf(EmeraldSpinnerState("Select"),
            EmeraldSpinnerState("Test"),
            EmeraldSpinnerState("Test2"))

        on<EmeraldSpinnerPage>(composeRule)
            .launchView(
                items = items,
                selected = items.first(),
                label ="Select",
                enabled = true
            )
            .validIfSelectItemIsDisplayed()
            .showItems()
            .validIfTestIsDisplayed()
    }

    @Test
    fun givenItemListWhenTheViewIsCreatedAndTheSpinnerIsDisabledThenNotShouldShowTheListItems() {
        val items = mutableListOf(EmeraldSpinnerState("Select"),
            EmeraldSpinnerState("Test"),
            EmeraldSpinnerState("Test2"))

        on<EmeraldSpinnerPage>(composeRule)
            .launchView(
                items = items,
                selected = items.first(),
                label ="Select",
                enabled = false
            )
            .validIfSelectItemIsDisplayed()
            .validIfSelectItemIsNotEnabled()
    }

    @Test
    fun givenItemListWhenTheViewIsCreatedAndTheSpinnerThenShouldErrorMessage() {
        val items = mutableListOf(EmeraldSpinnerState("Select"),
            EmeraldSpinnerState("Test"),
            EmeraldSpinnerState("Test2"))

        on<EmeraldSpinnerPage>(composeRule)
            .launchView(
                items = items,
                selected = items.first(),
                error = "Required",
                label ="Select",
            )
            .validIfSelectItemIsDisplayed()
            .validIfErrorMessageIsDisplayed()
    }
}