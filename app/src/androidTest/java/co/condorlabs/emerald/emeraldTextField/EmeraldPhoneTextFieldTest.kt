package co.condorlabs.emerald.emeraldTextField

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.condorlabs.emerald.BaseTestingActivity
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldState
import co.condorlabs.emerald.emeraldTextField.page.EmeraldPhoneTextFieldPage
import co.condorlabs.emerald.uiteststubs.base.Page
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalTestApi
@RunWith(AndroidJUnit4::class)
class EmeraldPhoneTextFieldTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<BaseTestingActivity>()

    @Test
    fun givenPhoneWhenTheComponentIsVisibleThenShouldShowTheLabelAndText() {
        val label = "Phone"
        Page.on<EmeraldPhoneTextFieldPage>(composeRule)
            .launchView(
                label = label,
                state = EmeraldTextFieldState(text = "9876543210"),
            )
            .validateIfLabelIsDisplayed(label)
            .validateIfTextIsDisplayed("(987) 654 3210")
    }

    @Test
    fun givenPhoneWhenTheComponentIsVisibleThenShouldShowTheLabelAndTextWithTheCorrectFormat() {
        val label = "Phone"
        val error = "Invalid phone"
        Page.on<EmeraldPhoneTextFieldPage>(composeRule)
            .launchView(
                label = label,
                state = EmeraldTextFieldState(text = "987654", error = error)
            )
            .validateIfLabelIsDisplayed(label)
            .validateIfTextIsDisplayed("(987) 654")
            .validateIfErrorIsDisplayed(error)
    }
}