package co.condorlabs.demo.screens.samples

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import co.condorlabs.emerald.components.text.EmeraldText
import co.condorlabs.emerald.components.text.EmeraldTextStyle

@Composable
fun TextScreenSample() {
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