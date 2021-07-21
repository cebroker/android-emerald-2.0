package co.condorlabs.emerald

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import co.condorlabs.emerald.components.EmeraldText
import co.condorlabs.emerald.components.EmeraldTextStyle
import co.condorlabs.emerald.components.PreviewEmeraldText
import co.condorlabs.emerald.theme.EmeraldTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
    }
}