package co.condorlabs.emerald.demo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import co.condorlabs.emerald.demo.screens.MainScreen
import co.condorlabs.emerald.theme.EmeraldTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmeraldTheme {
                MainScreen()
            }
        }
    }
}
