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
        h1 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 30.sp, fontWeight = FontWeight.SemiBold),
        h2 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 24.sp, fontWeight = FontWeight.SemiBold),
        h3 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 18.sp, fontWeight = FontWeight.SemiBold),
        h4 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 16.sp, fontWeight = FontWeight.SemiBold),
        h5 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 14.sp, fontWeight = FontWeight.SemiBold),
        subtitle1 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 14.sp, fontWeight = FontWeight.SemiBold),
        body1 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 14.sp, fontWeight = FontWeight.Normal),
        body2 = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 14.sp, fontWeight = FontWeight.SemiBold),
        caption = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 12.sp, fontWeight = FontWeight.Normal),
        overline = TextStyle(fontFamily = EmeraldFonts.OpenSans, fontSize = 10.sp, fontWeight = FontWeight.Normal),
    )
}
