package me.arunajayan.entriverselibrary.theme.typography

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

public val interTypographyProvider: EntriverseTypographyProvider = EntriverseTypographyProvider {
    val colors = it
    EntriverseTypography(
        colors = colors,
        h1 = interTextStyle(
            64,
            100 * 1.00000000,
            -0.01900000000,
            300,
            colors.referenceColors.primaryText
        ),
        h1Bold = interTextStyle(
            64,
            100 * 1.00000000,
            -0.01900000000,
            700,
            colors.referenceColors.primaryText
        ),
        h2 = interTextStyle(
            48,
            70 * 1.00000000,
            -0.01900000000,
            300,
            colors.referenceColors.primaryText
        ),
        h2Bold = interTextStyle(
            48,
            70 * 1.00000000,
            -0.01900000000,
            700,
            colors.referenceColors.primaryText
        ),
        h3 = interTextStyle(
            40,
            60 * 1.00000000,
            -0.01900000000,
            300,
            colors.referenceColors.primaryText
        ),
        h3Bold = interTextStyle(
            40,
            60 * 1.00000000,
            -0.01900000000,
            700,
            colors.referenceColors.primaryText
        ),
        h4 = interTextStyle(
            32,
            50 * 1.00000000,
            -0.01900000000,
            300,
            colors.referenceColors.primaryText
        ),
        h4Bold = interTextStyle(
            32,
            50 * 1.00000000,
            -0.01900000000,
            700,
            colors.referenceColors.primaryText
        ),
        display1 = interTextStyle(
            12,
            12 * 1.00000000,
            -0.016000000,
            500,
            colors.referenceColors.primaryText
        ),
        buttonDefault = interTextStyle(
            14,
            25 * 1.00000000,
            0.015,
            400,
            colors.referenceColors.primaryText
        ),
        buttonBold = interTextStyle(
            14,
            25 * 1.00000000,
            -0.016000000,
            700,
            colors.referenceColors.primaryText
        ),
        buttonItalic = interTextStyle(
            12,
            12 * 1.00000000,
            -0.016000000,
            500,
            colors.referenceColors.primaryText
        ),
    )
}

private fun interTextStyle(
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
