package co.condorlabs.emerald.components.text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import co.condorlabs.emerald.theme.EmeraldColors
import co.condorlabs.emerald.theme.EmeraldTypography

sealed class EmeraldTextStyle(
    private val textStyle: TextStyle,
    private val colorText: Color
) {

    object H1Title : EmeraldTextStyle(EmeraldTypography.textTypography.h1, EmeraldColors.textColor)
    object H2Title : EmeraldTextStyle(EmeraldTypography.textTypography.h2, EmeraldColors.textColor)
    object H3Title : EmeraldTextStyle(EmeraldTypography.textTypography.h3, EmeraldColors.textColor)
    object Title : EmeraldTextStyle(EmeraldTypography.textTypography.h4, EmeraldColors.textColor)
    object SectionTitle : EmeraldTextStyle(EmeraldTypography.textTypography.h5, EmeraldColors.textColor)
    object SubTitle : EmeraldTextStyle(EmeraldTypography.textTypography.subtitle1, EmeraldColors.subtitleColor)
    object Body : EmeraldTextStyle(EmeraldTypography.textTypography.body1, EmeraldColors.labelColor)
    object SectionBody : EmeraldTextStyle(EmeraldTypography.textTypography.body1, EmeraldColors.textColor)
    object Link : EmeraldTextStyle(EmeraldTypography.textTypography.body2, EmeraldColors.primaryColor)
    object BodySmall : EmeraldTextStyle(EmeraldTypography.textTypography.caption, EmeraldColors.subtitleColor)

    fun getColorText(): Color {
        return colorText
    }

    fun getTextStyle(): TextStyle {
        return textStyle
    }
}