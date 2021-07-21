package co.condorlabs.emerald.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import co.condorlabs.emerald.theme.EmeraldColors
import co.condorlabs.emerald.theme.EmeraldTheme
import co.condorlabs.emerald.theme.EmeraldTypography

@Preview(showBackground = true)
@Composable
fun PreviewEmeraldText() {
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
        }
    }
}

@Composable
fun EmeraldText(text: String, style: EmeraldTextStyle) {
    Text(
        text = text,
        style = style.getTextStyle(),
        color = style.getColorText(),
    )
}

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