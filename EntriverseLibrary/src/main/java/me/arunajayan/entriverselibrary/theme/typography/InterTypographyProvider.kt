package me.arunajayan.entriverselibrary.theme.typography

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

public val interTypographyProvider:EntriverseTypographyProvider= EntriverseTypographyProvider {
    val colors = it
    EntriverseTypography(
        colors = colors,
        display1 = roboto(96, 96 * 1.00000000, -0.01900000000, 500, colors.referenceColors.primaryText)
    )
}

private fun roboto(
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