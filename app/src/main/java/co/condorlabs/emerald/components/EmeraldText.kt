package co.condorlabs.emerald.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import co.condorlabs.emerald.theme.EmeraldColors.labelColor
import co.condorlabs.emerald.theme.EmeraldColors.primaryColor
import co.condorlabs.emerald.theme.EmeraldColors.subtitleColor
import co.condorlabs.emerald.theme.EmeraldColors.textColor
import co.condorlabs.emerald.theme.EmeraldTheme
import co.condorlabs.emerald.theme.typography

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

    object H1Title : EmeraldTextStyle(typography.h1, textColor)
    object H2Title : EmeraldTextStyle(typography.h2, textColor)
    object H3Title : EmeraldTextStyle(typography.h3, textColor)
    object Title : EmeraldTextStyle(typography.h4, textColor)
    object SectionTitle : EmeraldTextStyle(typography.h5, textColor)
    object SubTitle : EmeraldTextStyle(typography.subtitle1, subtitleColor)
    object Body : EmeraldTextStyle(typography.body1, labelColor)
    object SectionBody : EmeraldTextStyle(typography.body1, textColor)
    object Link : EmeraldTextStyle(typography.body2, primaryColor)
    object BodySmall : EmeraldTextStyle(typography.caption, subtitleColor)

    fun getColorText(): Color {
        return colorText
    }

    fun getTextStyle(): TextStyle {
        return textStyle
    }
}