package co.condorlabs.emerald.components.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.utils.RippleColorTheme
import co.condorlabs.emerald.numberToDp

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
    val buttonSize = remember {
        mutableStateOf(0)
    }
    Box {
        val isTouched = remember {
            //TODO: The idea is that when we have knowledge with which event to execute this state, the validations that are currently reflected are carried out. This will go in another PR.
            mutableStateOf(false)
        }
        CompositionLocalProvider(LocalRippleTheme provides RippleColorTheme(emeraldButtonStyle.rippleColor)) {
            Button(
                onClick = clickAction,
                border = emeraldButtonStyle.strokeWidth,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (isTouched.value) emeraldButtonStyle.rippleColor else emeraldButtonStyle.backgroundColor
                ),
                modifier = modifier
                    .onGloballyPositioned {
                        buttonSize.value = it.size.height
                    },
                enabled = enabled,
                interactionSource = interactionSource,
                elevation = elevation,
                shape = shape,
                contentPadding = contentPadding
            ) {
                if (emeraldButtonState is EmeraldButtonState.Normal) {
                    Text(
                        //TODO: The textStyle will be added later
                        text = text,
                        color = if (isTouched.value) emeraldButtonStyle.highlightTextColor else emeraldButtonStyle.textColor
                    )
                }
            }

            if (emeraldButtonState is EmeraldButtonState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(buttonSize.value.numberToDp() - DEFAULT_REDUCE_PADDING.dp),
                    color = emeraldButtonStyle.textColor
                )
            }
        }
    }
}

private const val DEFAULT_REDUCE_PADDING = 4


