package co.condorlabs.emerald.components.custombutton

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import co.condorlabs.emerald.theme.RippleColorTheme

@Composable
fun EmeraldButton(
    text: String = "",
    emeraldButtonType: String = BUTTON_PRIMARY_TYPE,
    buttonState: ButtonState = ButtonState.Normal,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = MaterialTheme.shapes.small,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    clickAction: () -> Unit
) {
    val emeraldButtonStyle: EmeraldButtonStyle =
        EmeraldButtonStyleFactory().getEmeraldButtonStyle(emeraldButtonType)

    CompositionLocalProvider(LocalRippleTheme provides RippleColorTheme(emeraldButtonStyle.rippleColor)) {
        Button(
            onClick = clickAction,
            border = emeraldButtonStyle.strokeWidth,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = emeraldButtonStyle.backgroundColor
            ),
            modifier = modifier,
            enabled = enabled,
            interactionSource = interactionSource,
            elevation = elevation,
            shape = shape,
            contentPadding = contentPadding
        ) {
            when (buttonState) {
                ButtonState.Normal -> {
                    Text(
                        text = text,
                        color = emeraldButtonStyle.textColor
                    )
                }
                ButtonState.Loading -> {
                    Box(modifier = Modifier.fillMaxHeight()) {
                        CircularProgressIndicator(
                            modifier = Modifier.fillMaxHeight(),
                            color = emeraldButtonStyle.textColor,
                        )
                    }
                }
            }
        }
    }
}

