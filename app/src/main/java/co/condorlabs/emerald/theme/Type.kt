package co.condorlabs.emerald.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object ButtonTextStyle {
    val TextStyle = TextStyle(fontFamily =  EmeraldFonts.OpenSans, fontWeight = FontWeight.SemiBold)
}

object EmeraldTypography {
    val TextTypography = Typography(
        h1 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 30.sp, fontWeight = FontWeight.Normal),
        h2 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 24.sp, fontWeight = FontWeight.Normal),
        h3 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 18.sp, fontWeight = FontWeight.Normal),
        h4 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 16.sp, fontWeight = FontWeight.Normal),
        h5 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 14.sp, fontWeight = FontWeight.Normal),
        subtitle1 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 14.sp, fontWeight = FontWeight.Normal),
        body1 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 14.sp, fontWeight = FontWeight.SemiBold),
        body2 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 14.sp, fontWeight = FontWeight.Normal),
        caption = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 12.sp, fontWeight = FontWeight.SemiBold),
        overline = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 12.sp, fontWeight = FontWeight.Normal),
    )
}
