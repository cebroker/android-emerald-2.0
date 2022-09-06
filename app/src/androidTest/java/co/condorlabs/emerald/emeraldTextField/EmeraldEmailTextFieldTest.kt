package co.condorlabs.emerald.emeraldTextField

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.condorlabs.emerald.BaseTestingActivity
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldState
import co.condorlabs.emerald.uiteststubs.base.Page.Companion.on
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalTestApi
@RunWith(AndroidJUnit4::class)
class EmeraldEmailTextFieldTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<BaseTestingActivity>()

    @Test
    fun givenInvalidEmailWhenTheViewIsCreatedThenShouldShowMessageError() {
        on<EmeraldEmailTextFieldPage>(composeRule)
            .launchView(
                state = EmeraldTextFieldState(text = "email@.", error = "Email is invalid"),
                label = "Email invalid"
            )
            .validIfLabelEmailInvalidIsDisplayed()
            .validIfInvalidEmailIsDisplayed()
            .validIfMessageErrorIsDisplayed()
    }

    @Test
    fun givenValidEmailWhenTheViewIsCreatedThenShouldShowEmailValid() {
        on<EmeraldEmailTextFieldPage>(composeRule)
            .launchView(
                state = EmeraldTextFieldState(text = "email@ec.com"),
                label = "Email valid"
            )
            .validIfLabelEmailValidIsDisplayed()
            .validIfValidEmailIsDisplayed()
    }
}
