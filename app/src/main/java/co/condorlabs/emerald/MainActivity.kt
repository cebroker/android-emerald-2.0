package co.condorlabs.emerald

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.EmeraldText
import co.condorlabs.emerald.components.EmeraldTextStyle
import co.condorlabs.emerald.components.custombutton.BUTTON_PRIMARY_TYPE
import co.condorlabs.emerald.components.custombutton.BUTTON_SUCCESS_TYPE
import co.condorlabs.emerald.components.custombutton.BUTTON_DANGER_TYPE
import co.condorlabs.emerald.components.custombutton.ButtonState
import co.condorlabs.emerald.components.custombutton.EmeraldButton
import co.condorlabs.emerald.theme.EmeraldTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmeraldTheme {
                Column {
                    EmeraldText(text = "h1 Title", style = EmeraldTextStyle.H1Title)
                    EmeraldText(text = "h2 Title", style = EmeraldTextStyle.H2Title)
                    EmeraldText(text = "h3 Title", style = EmeraldTextStyle.H3Title)
                    EmeraldText(text = "Title", style = EmeraldTextStyle.Title)
                    EmeraldText(text = "Subtitle", style = EmeraldTextStyle.SubTitle)
                    EmeraldText(text = "Body", style = EmeraldTextStyle.Body)
                    EmeraldText(text = "Small body", style = EmeraldTextStyle.BodySmall)
                    EmeraldText(text = "Section title", style = EmeraldTextStyle.SectionTitle)
                    EmeraldText(text = "Section body", style = EmeraldTextStyle.SectionBody)
                    EmeraldText(text = "Link", style = EmeraldTextStyle.Link)
                    val currentButtonState: MutableState<ButtonState> = remember { mutableStateOf(ButtonState.Normal) }
                    EmeraldButton(
                        text = "Primary Button",
                        emeraldButtonType = BUTTON_PRIMARY_TYPE,
                        modifier = Modifier.fillMaxWidth().height(40.dp),
                        buttonState = currentButtonState.value
                    ) {
                        if(currentButtonState.value is ButtonState.Normal) {
                            currentButtonState.value = ButtonState.Loading
                        } else {
                            currentButtonState.value = ButtonState.Normal
                        }
                    }
                    EmeraldButton(
                        text = "Success Button",
                        emeraldButtonType = BUTTON_SUCCESS_TYPE
                    ) {}

                    EmeraldButton(
                        text = "Danger Button",
                        emeraldButtonType = BUTTON_DANGER_TYPE
                    ) {}
                }
            }
        }
    }
}