package co.condorlabs.emerald.emeraldTextField

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.condorlabs.emerald.BaseTestingActivity
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldState
import co.condorlabs.emerald.emeraldTextField.page.EmeraldDateTextFieldPage
import co.condorlabs.emerald.uiteststubs.base.Page
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalTestApi
@RunWith(AndroidJUnit4::class)
class EmeraldDateTextFieldTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<BaseTestingActivity>()

    @Test
    fun givenAValidDateWhenTheViewIsCreatedThenItShouldShowTheDate() {
        Page.on<EmeraldDateTextFieldPage>(composeRule)
            .launchView(
                state = EmeraldTextFieldState(text = "09202022"),
                label = "Valid date"
            )
            .validateIfValidLabelIsDisplayed()
            .validateIfDateTextIsDisplayed()
    }

    @Test
    fun givenAnInvalidDateWhenTheViewIsCreatedThenItShouldGetTheErrorMessage() {
        Page.on<EmeraldDateTextFieldPage>(composeRule)
            .launchView(
                state = EmeraldTextFieldState(text = "35609999", error = "Date is invalid"),
                label = "Invalid date"
            )
            .validateIfInvalidLabelIsDisplayed()
            .validateIfInvalidDateIsDisplayed()
            .validateIfMessageErrorIsDisplayed()
    }

    @Test
    fun whenTheCalendarIconIsPressedThenItShouldShowTheDatePicker() {
        Page.on<EmeraldDateTextFieldPage>(composeRule)
            .launchViewWithDefaultDate(
                state = EmeraldTextFieldState(text = "", error = null),
                label = "Show date picker"
            )
            .validateIfShowDatePickerLabelIsDisplayed()
            .onClickIconShowCalendar()
            .validateIfDatePickerIsDisplayed()
    }
}
