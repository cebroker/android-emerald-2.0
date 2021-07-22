package co.condorlabs.emerald.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
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
fun EmeraldText(
    text: String,
    style: EmeraldTextStyle,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
) {
    Text(
        text = text,
        style = style.getTextStyle(),
        color = style.getColorText(),
        modifier = modifier,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
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