package co.condorlabs.emerald.components.text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import co.condorlabs.emerald.theme.EmeraldColors
import co.condorlabs.emerald.theme.EmeraldTypography

sealed class EmeraldTextStyle(
    private val textStyle: TextStyle,
    private val colorText: Color
) {

    object H1Title : EmeraldTextStyle(EmeraldTypography.TextTypography.h1, EmeraldColors.TextColor)
    object H2Title : EmeraldTextStyle(EmeraldTypography.TextTypography.h2, EmeraldColors.TextColor)
    object H3Title : EmeraldTextStyle(EmeraldTypography.TextTypography.h3, EmeraldColors.TextColor)
    object Title : EmeraldTextStyle(EmeraldTypography.TextTypography.h4, EmeraldColors.TextColor)
    object SectionTitle : EmeraldTextStyle(EmeraldTypography.TextTypography.h5, EmeraldColors.TextColor)
    object SubTitle : EmeraldTextStyle(EmeraldTypography.TextTypography.subtitle1, EmeraldColors.SubtitleColor)
    object Body : EmeraldTextStyle(EmeraldTypography.TextTypography.body1, EmeraldColors.LabelColor)
    object SectionBody : EmeraldTextStyle(EmeraldTypography.TextTypography.body1, EmeraldColors.TextColor)
    object Danger : EmeraldTextStyle(EmeraldTypography.TextTypography.body1, EmeraldColors.DangerColor)
    object Link : EmeraldTextStyle(EmeraldTypography.TextTypography.body2, EmeraldColors.InfoColor)
    object BodySmall : EmeraldTextStyle(EmeraldTypography.TextTypography.caption, EmeraldColors.SubtitleColor)

    fun getColorText(): Color {
        return colorText
    }

    fun getTextStyle(): TextStyle {
        return textStyle
    }
}