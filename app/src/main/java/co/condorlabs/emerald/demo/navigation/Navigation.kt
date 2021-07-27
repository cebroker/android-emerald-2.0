package co.condorlabs.emerald.demo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.condorlabs.emerald.demo.drawer.NavDrawerItem
import co.condorlabs.emerald.demo.screens.samples.ButtonScreenSample
import co.condorlabs.emerald.demo.screens.samples.TextFieldScreenSample
import co.condorlabs.emerald.demo.screens.samples.TextScreenSample


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
    }
}