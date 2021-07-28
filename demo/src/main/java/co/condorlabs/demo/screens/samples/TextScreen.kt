package co.condorlabs.demo.screens.samples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.condorlabs.emerald.components.text.EmeraldText
import co.condorlabs.emerald.components.text.EmeraldTextStyle

@Composable
fun TextScreenSample() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.padding(10.dp).verticalScroll(scrollState)) {
        EmeraldText(text = "Title labels", style =EmeraldTextStyle.SectionTitle)

        EmeraldText(text = "H1\nLorem ipsum dolor sit", style = EmeraldTextStyle.H1Title, modifier = Modifier.padding(top = 5.dp))
        EmeraldText(text = "H2\nLorem ipsum dolor sit amet", style = EmeraldTextStyle.H2Title, modifier = Modifier.padding(top = 5.dp))
        EmeraldText(text = "H3\nLorem ipsum dolor sit amet", style = EmeraldTextStyle.H3Title, modifier = Modifier.padding(top = 5.dp))
        EmeraldText(text = "Title\n Lorem ipsum dolor sit amet", style = EmeraldTextStyle.Title, modifier = Modifier.padding(top = 5.dp))
        EmeraldText(text = "Section title\nLorem ipsum dolor sit amet", style = EmeraldTextStyle.SectionTitle, modifier = Modifier.padding(top = 5.dp))
        Divider(color = Color.Black)

        EmeraldText(text = "Body labels", style =EmeraldTextStyle.SectionTitle, modifier = Modifier.padding(top = 10.dp))
        EmeraldText(text = "Body\nAccumsan ad hendrerit senectus est dis cursus, massa fermentum nascetur magnis ornare rhoncus lacinia, sociosqu aenean libero nullam mollis.", style = EmeraldTextStyle.Body, modifier = Modifier.padding(top = 5.dp))
        EmeraldText(text = "Small body\nAccumsan ad hendrerit senectus est dis cursus, massa fermentum nascetur magnis ornare rhoncus lacinia, sociosqu aenean libero nullam mollis.", style = EmeraldTextStyle.BodySmall, modifier = Modifier.padding(top = 5.dp))
        EmeraldText(text = "Section body\nAccumsan ad hendrerit senectus est dis cursus, massa fermentum nascetur magnis ornare rhoncus lacinia, sociosqu aenean libero nullam mollis.", style = EmeraldTextStyle.SectionBody, modifier = Modifier.padding(top = 5.dp))
        Divider(color = Color.Black)

        EmeraldText(text = "Other labels", style =EmeraldTextStyle.SectionTitle, modifier = Modifier.padding(top = 10.dp))
        EmeraldText(text = "Subtitle\nAliquam sociosqu varius praesent maecenas", style = EmeraldTextStyle.SubTitle, modifier = Modifier.padding(top = 5.dp))
        EmeraldText(text = "Link\nhttps://evercheck.com/", style = EmeraldTextStyle.Link, modifier = Modifier.padding(top = 5.dp))
    }
}