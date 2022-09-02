package co.condorlabs.demo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.condorlabs.demo.drawer.NavDrawerItem
import co.condorlabs.demo.screens.samples.ButtonScreenSample
import co.condorlabs.demo.screens.samples.CheckboxScreenSample
import co.condorlabs.demo.screens.samples.RadioGroupScreenSample
import co.condorlabs.demo.screens.samples.SpinnerScreenSample
import co.condorlabs.demo.screens.samples.TextFieldScreenSample
import co.condorlabs.demo.screens.samples.TextScreenSample

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavDrawerItem.Text.route) {
        composable(NavDrawerItem.Text.route) {
            TextScreenSample()
        }
        composable(NavDrawerItem.Button.route) {
            ButtonScreenSample()
        }
        composable(NavDrawerItem.TextField.route) {
            TextFieldScreenSample()
        }
        composable(NavDrawerItem.RadioGroup.route) {
            RadioGroupScreenSample()
        }
        composable(NavDrawerItem.CheckboxGroup.route) {
            CheckboxScreenSample()
        }
        composable(NavDrawerItem.Spinner.route) {
            SpinnerScreenSample()
        }
    }
}