package co.condorlabs.emerald.emeraldTextField

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.condorlabs.emerald.BaseTestingActivity
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldState
import co.condorlabs.emerald.emeraldTextField.page.EmeraldPasswordTextFieldPage
import co.condorlabs.emerald.uiteststubs.base.Page
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalTestApi
@RunWith(AndroidJUnit4::class)
class EmeraldPasswordTextFieldTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<BaseTestingActivity>()

    @Test
    fun givenPasswordWhenTheVisibilityIconIsPressedThenShouldShowThePassword() {
        Page.on<EmeraldPasswordTextFieldPage>(composeRule)
            .launchView(
                state = EmeraldTextFieldState(text = "Password1234"),
                label = "Show password"
            )
            .validateIfShowPasswordLabelIsDisplayed()
            .onClickIconVisibilityOn()
            .validateIfPasswordIsDisplayed()
    }

    @Test
    fun givenMessageErrorWhenTheViewIsCreatedThenNotShouldShowTheMessageError() {
        Page.on<EmeraldPasswordTextFieldPage>(composeRule)
            .launchView(
                state = EmeraldTextFieldState(text = "", error = "Password invalid"),
                label = "Error password"
            )
            .validateIfErrorPasswordLabelIsDisplayed()
            .validateIfErrorPasswordIsDisplayed()
    }
}