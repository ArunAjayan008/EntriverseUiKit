package me.arunajayan.entriverselibrary.theme.typography

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

public val notoSerifTypographyProvider: EntriverseTypographyProvider =
    EntriverseTypographyProvider {
        val colors = it
        EntriverseTypography(
            colors = colors,
            h1 = notoSerifTextStyle(
                36,
                46.8 * 1.00000000,
                0.72,
                300,
                colors.referenceColors.primaryText
            ),
            h1Bold = notoSerifTextStyle(
                36,
                46.8 * 1.00000000,
                0.72,
                600,
                colors.referenceColors.primaryText
            ),
            h2 = notoSerifTextStyle(
                32,
                41.6 * 1.00000000,
                0.64,
                300,
                colors.referenceColors.primaryText
            ),
            h2Bold = notoSerifTextStyle(
                32,
                41.6 * 1.00000000,
                0.64,
                600,
                colors.referenceColors.primaryText
            ),
            h3 = notoSerifTextStyle(
                28,
                36.4 * 1.00000000,
                0.56,
                300,
                colors.referenceColors.primaryText
            ),
            h3Bold = notoSerifTextStyle(
                28,
                36.4 * 1.00000000,
                0.56,
                600,
                colors.referenceColors.primaryText
            ),
            h4 = notoSerifTextStyle(
                24,
                32.4 * 1.00000000,
                0.48,
                300,
                colors.referenceColors.primaryText
            ),
            h4Bold = notoSerifTextStyle(
                24,
                32.4 * 1.00000000,
                0.48,
                600,
                colors.referenceColors.primaryText
            ),
            display1 = notoSerifTextStyle(
                55,
                96 * 1.00000000,
                -0.01900000000,
                500,
                colors.referenceColors.primaryText
            ),
            buttonDefault = notoSerifTextStyle(
                14,
                0.00000000,
                0.01,
                400,
                colors.referenceColors.primaryText
            ),
            buttonBold = notoSerifTextStyle(
                16,
                1.00000000,
                0.15,
                700,
                colors.referenceColors.primaryText
            ),
            buttonItalic = notoSerifTextStyle(
                14,
                25 * 1.00000000,
                0.05,
                400,
                colors.referenceColors.primaryText
            ),
        )
    }

private fun notoSerifTextStyle(
    fontSize: Int,
    lineHeight: Double,
    letterSpacing: Double,
    fontWeight: Int,
    color: Color,
): TextStyle = TextStyle(
    fontSize = fontSize.sp,
    lineHeight = lineHeight.sp,
    letterSpacing = letterSpacing.em,
    fontWeight = FontWeight(fontWeight),
    color = color,
)

public fun initTypography() {
    EntriverseTypographyManager.provideTypography(notoSerifTypographyProvider)
}