package co.condorlabs.emerald.emeraldTextField

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import co.condorlabs.emerald.BaseTestingActivity
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldState
import co.condorlabs.emerald.emeraldTextField.page.EmeraldMonthYearTextFieldPage
import co.condorlabs.emerald.uiteststubs.base.Page
import org.junit.Rule
import org.junit.Test

class EmeraldMonthYearTextFieldTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<BaseTestingActivity>()

    @Test
    fun givenAValidMonthYearWhenTheViewIsCreatedThenItShouldShowTheDate() {
        Page.on<EmeraldMonthYearTextFieldPage>(composeRule)
            .launchView(
                state = EmeraldTextFieldState(text = "102022"),
                label = "Valid month year"
            )
            .validateIfValidLabelIsDisplayed()
            .validateIfMonthYearTextIsDisplayed()
    }

    @Test
    fun givenAnInvalidMonthWhenTheViewIsCreatedThenItShouldGetTheErrorMessage() {
        Page.on<EmeraldMonthYearTextFieldPage>(composeRule)
            .launchView(
                state = EmeraldTextFieldState(text = "359999", error = "Month year is invalid"),
                label = "Invalid month year"
            )
            .validateIfInvalidLabelIsDisplayed()
            .validateIfInvalidMonthYearIsDisplayed()
            .validateIfMessageErrorIsDisplayed()
    }

    @Test
    fun whenTheCalendarIconIsPressedThenItShouldShowTheMonthYearDialog() {
        Page.on<EmeraldMonthYearTextFieldPage>(composeRule)
            .launchViewWithDefaultDate(
                state = EmeraldTextFieldState(text = "", error = null),
                label = "Show month year picker"
            )
            .validateIfShowMonthYearPickerLabelIsDisplayed()
            .onClickIconShowCalendar()
            .validateIfMonthYearPickerIsDisplayed()
    }
}