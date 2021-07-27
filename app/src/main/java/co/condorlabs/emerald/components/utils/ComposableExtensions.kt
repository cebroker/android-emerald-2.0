package co.condorlabs.emerald.components.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun Int.numberToDp(): Dp {
    return with(LocalDensity.current) {
        this@numberToDp.toDp()
    }
}