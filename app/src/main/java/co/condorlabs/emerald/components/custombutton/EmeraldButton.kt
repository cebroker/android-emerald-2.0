package co.condorlabs.emerald.components.custombutton

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

@Composable
fun EmeraldButton(
    text: String,
    emeraldButtonType: String,
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
        when(buttonState) {
            ButtonState.Normal -> {
                Text(
                    text = text,
                    color = emeraldButtonStyle.textColor
                )
            }
            ButtonState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.wrapContentHeight(),
                    color = emeraldButtonStyle.textColor,
                )
            }
        }
    }
}

