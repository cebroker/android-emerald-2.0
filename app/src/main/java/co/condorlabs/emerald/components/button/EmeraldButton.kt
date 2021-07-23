package co.condorlabs.emerald.components.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import co.condorlabs.emerald.components.utils.RippleColorTheme

@Composable
fun EmeraldButton(
    text: String,
    emeraldButtonStyle: EmeraldButtonStyle,
    modifier: Modifier = Modifier,
    emeraldButtonState: EmeraldButtonState = EmeraldButtonState.Normal,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = MaterialTheme.shapes.small,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    clickAction: () -> Unit
) {
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
            when (emeraldButtonState) {
                EmeraldButtonState.Normal -> {
                    Text(
                        //TODO: The textStyle will be added later
                        text = text,
                        color = emeraldButtonStyle.textColor
                    )
                }
                EmeraldButtonState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.wrapContentHeight(),
                        color = emeraldButtonStyle.textColor,
                    )
                }
            }
        }
    }
}

