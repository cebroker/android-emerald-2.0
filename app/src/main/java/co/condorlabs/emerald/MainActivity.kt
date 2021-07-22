package co.condorlabs.emerald

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.button.EmeraldButton
import co.condorlabs.emerald.components.button.EmeraldButtonState
import co.condorlabs.emerald.components.button.EmeraldButtonStyle
import co.condorlabs.emerald.components.text.EmeraldText
import co.condorlabs.emerald.components.text.EmeraldTextStyle
import co.condorlabs.emerald.components.textfield.EmeraldTextField
import co.condorlabs.emerald.components.textfield.EmeraldTextFieldState
import co.condorlabs.emerald.theme.EmeraldTheme

/**
 * This Class is just for development purposes, to check the look and feel,
 * and the behavior of the components. It will be removed in the future
 * or it can be adapted as a demo of the components
 **/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmeraldTheme {
                Column(Modifier.padding(horizontal = 20.dp)) {
                    TextSample()
                    TextFieldSample()
                    val currentButtonState: MutableState<EmeraldButtonState> = remember { mutableStateOf(EmeraldButtonState.Normal) }
                    EmeraldButton(
                        text = "Primary Button",
                        emeraldButtonStyle = EmeraldButtonStyle.EmeraldPrimaryButton,
                        modifier = Modifier.fillMaxWidth().height(40.dp),
                    ) {
                        if(currentButtonState.value is EmeraldButtonState.Normal) {
                            currentButtonState.value = EmeraldButtonState.Loading
                        } else {
                            currentButtonState.value = EmeraldButtonState.Normal
                        }
                    }
                    EmeraldButton(
                        text = "Success Button",
                        emeraldButtonStyle = EmeraldButtonStyle.EmeraldSuccessButton
                    ) {}

                    EmeraldButton(
                        text = "Danger Button",
                        emeraldButtonStyle = EmeraldButtonStyle.EmeraldDangerButton
                    ) {}
                }
            }
        }
    }
}

@Composable
fun TextSample() {
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
    }
}

@Composable
fun TextFieldSample() {
    val textStateEmpty = remember {
        mutableStateOf(EmeraldTextFieldState())
    }

    val textStateCorrect = remember {
        mutableStateOf(EmeraldTextFieldState())
    }

    val textStateError = remember {
        mutableStateOf(EmeraldTextFieldState())
    }

    val onValueChangedEmpty = { text: TextFieldValue ->
        textStateEmpty.value = textStateEmpty.value.copy(text = text)
    }

    val onValueChangedCorrect = { text: TextFieldValue ->
        textStateCorrect.value = textStateCorrect.value.copy(text = text)
    }

    val onValueChangedError = { text: TextFieldValue ->
        textStateError.value = textStateError.value.copy(text = text)
        if (text.text.length > 5) {
            textStateError.value = textStateError.value.copy(text = text, error = "This is an error message")
        }
    }

    Column {
        EmeraldTextField(
            state = textStateEmpty.value,
            onValueChange = onValueChangedEmpty,
            label = "Normal",
        )
        EmeraldTextField(
            state = textStateCorrect.value,
            onValueChange = onValueChangedCorrect,
            label = "With placeholder",
            placeholder = "With placeholder",
        )
        EmeraldTextField(
            state = textStateError.value,
            onValueChange = onValueChangedError,
            label = "With error message",
        )
    }

}