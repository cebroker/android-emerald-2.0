package co.condorlabs.emerald.emeraldmonthyeardialog

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.condorlabs.emerald.BaseTestingActivity
import co.condorlabs.emerald.uiteststubs.base.Page
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalTestApi
@RunWith(AndroidJUnit4::class)
class EmeraldMonthYearDialogTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<BaseTestingActivity>()

    @Test
    fun whenTheViewIsCreatedThenItShouldShowTheDialog() {
        Page.on<EmeraldMonthYearDialogPage>(composeRule)
            .launchView()
            .validateIfIsVisibleDialog()
    }

    @Test
    fun givenAMonthDefaultAndYearDefaultWhenTheViewIsCreatedThenItShouldShowTheMonthAndYearAndReturnSameData() {
        val monthDefault = 0
        val yearDefault = 2021
        Page.on<EmeraldMonthYearDialogPage>(composeRule)
            .launchView(
                monthSelected = monthDefault,
                yearSelected = yearDefault,
                onConfirmButton = { month, year ->
                    Assert.assertEquals(monthDefault, month)
                    Assert.assertEquals(yearDefault, year)
                }
            )
            .validateIfMonthTextIsDisplayed()
            .validateIfYearTextIsDisplayed()
            .onClickOkButton()

    }
}