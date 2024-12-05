package entriverse.shared.theme.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import entriverse.shared.theme.UserLocale
import entriverse.shared.theme.fonts.interFamily
import entriverse.shared.theme.fonts.notoSansMalayalamFamily
import entriverse.shared.theme.fonts.notoSerifMalayalamFamily
import entriverse.shared.theme.fonts.notoSerifRegularFamily

val evTypographyProvider: EntriverseTypographyProvider =
    EntriverseTypographyProvider { userLocale, fontDimensVal ->

        val (fontSerifFamily, fontSansFamily) = when (userLocale) {
            UserLocale.EN -> Pair(notoSerifRegularFamily, interFamily)
            UserLocale.ML -> Pair(notoSerifMalayalamFamily, notoSansMalayalamFamily)
            else -> Pair(interFamily, interFamily)
        }

        EntriverseTypography(
            bodyDefaultRegular = evTextStyle(
                fontFamily = fontSansFamily,
                fontSize = fontDimensVal.fontDimens.fontSize400,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight400,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing600
            ),
            bodyDefaultMedium = evTextStyle(
                fontFamily = fontSansFamily,
                fontSize = fontDimensVal.fontDimens.fontSize400,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight500,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing600
            ),
            bodyDefaultBold = evTextStyle(
                fontFamily = fontSansFamily,
                fontSize = fontDimensVal.fontDimens.fontSize400,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight600,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing600
            ),
            bodyLargeRegular = evTextStyle(
                fontFamily = fontSansFamily,
                fontSize = fontDimensVal.fontDimens.fontSize500,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight400,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing300
            ),
            bodyLargeMedium = evTextStyle(
                fontFamily = fontSansFamily,
                fontSize = fontDimensVal.fontDimens.fontSize500,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight500,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing300
            ),
            bodyLargeBold = evTextStyle(
                fontFamily = fontSansFamily,
                fontSize = fontDimensVal.fontDimens.fontSize500,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight600,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing300
            ),
            bodySerifRegular = evTextStyle(
                fontFamily = fontSerifFamily,
                fontSize = fontDimensVal.fontDimens.fontSize400,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight400,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing600
            ),
            bodySerifMedium = evTextStyle(
                fontFamily = fontSerifFamily,
                fontSize = fontDimensVal.fontDimens.fontSize400,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight400,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing600
            ),
            bodySerifBold = evTextStyle(
                fontFamily = fontSerifFamily,
                fontSize = fontDimensVal.fontDimens.fontSize400,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight700,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing600
            ),
            captionDefaultRegular = evTextStyle(
                fontFamily = fontSansFamily,
                fontSize = fontDimensVal.fontDimens.fontSize300,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight400,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing600
            ),
            captionDefaultMedium = evTextStyle(
                fontFamily = fontSansFamily,
                fontSize = fontDimensVal.fontDimens.fontSize300,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight500,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing600
            ),
            captionDefaultBold = evTextStyle(
                fontFamily = fontSansFamily,
                fontSize = fontDimensVal.fontDimens.fontSize300,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight700,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing600
            ),
            captionSmallRegular = evTextStyle(
                fontFamily = fontSansFamily,
                fontSize = fontDimensVal.fontDimens.fontSize200,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight400,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing600
            ),
            captionSmallMedium = evTextStyle(
                fontFamily = fontSansFamily,
                fontSize = fontDimensVal.fontDimens.fontSize200,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight500,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing600
            ),
            captionSmallBold = evTextStyle(
                fontFamily = fontSansFamily,
                fontSize = fontDimensVal.fontDimens.fontSize200,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight700,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing600
            ),
            labelText = evTextStyle(
                fontFamily = fontSansFamily,
                fontSize = fontDimensVal.fontDimens.fontSize100,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight700,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing800
            ),
            buttonText = evTextStyle(
                fontFamily = fontSansFamily,
                fontSize = fontDimensVal.fontDimens.fontSize400,
                fontWeight = fontDimensVal.fontWeightDimens.fontWeight700,
                letterSpacing = fontDimensVal.letterSpacingDimens.letterSpacing700
            ),
        )
    }


private fun evTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    letterSpacing: TextUnit
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    fontWeight = fontWeight,
    letterSpacing = letterSpacing,
)




