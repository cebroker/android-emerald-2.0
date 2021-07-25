package co.condorlabs.emerald.components.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.utils.RippleColorTheme

@Composable
fun EmeraldButton(
    text: String,
    emeraldButtonStyle: EmeraldButtonStyle,
    emeraldButtonState: EmeraldButtonState = EmeraldButtonState.Normal,
    modifier: Modifier = Modifier,
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
        CompositionLocalProvider(LocalRippleTheme provides RippleColorTheme(emeraldButtonStyle.rippleColor)) {
            Button(
                onClick = clickAction,
                border = emeraldButtonStyle.strokeWidth,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = emeraldButtonStyle.backgroundColor
                ),
                modifier = modifier.onGloballyPositioned {
                    buttonSize.value = it.size.height
                },
                enabled = enabled,
                interactionSource = interactionSource,
                elevation = elevation,
                shape = shape,
                contentPadding = contentPadding
            ) {
                if (!isLoading(emeraldButtonState = emeraldButtonState)) {
                    Text(
                        //TODO: The textStyle will be added later
                        text = text,
                        color = emeraldButtonStyle.textColor
                    )
                }
            }

            if(isLoading(emeraldButtonState = emeraldButtonState)) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(numberToDp(number = buttonSize.value) - DEFAULT_REDUCE_PADDING.dp),
                    color = emeraldButtonStyle.textColor
                )
            }
        }
    }
}

@Composable
private fun isLoading(emeraldButtonState: EmeraldButtonState): Boolean {
    return when (emeraldButtonState) {
        EmeraldButtonState.Normal -> {
            false
        }
        EmeraldButtonState.Loading -> {
            return true
        }
    }
}

@Composable
fun numberToDp(number: Int): Dp {
    return with(LocalDensity.current) {
        number.toDp()
    }
}

private const val DEFAULT_REDUCE_PADDING = 4


