package me.arunajayan.entriverselibrary.theme.colors

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
public data class EntriverseColors internal constructor(
    public val lightMode: Boolean,
    public val referenceColors: ReferenceColors,
)

@Immutable
public data class ReferenceColors internal constructor(
    public val backgroundDefault: Color,
    public val backgroundGrey: Color,
    public val blueContainer: Color,
    public val blueHover: Color,
    public val blueIcon: Color,
    public val blueOutline: Color,
    public val brownIcon: Color,
    public val defaultIcon: Color,
    public val disabledIcon: Color,
    public val disabledText: Color,
    public val entriBlue: Color,
    public val fixedBlack: Color,
    public val fixedPureBlack: Color,
    public val fixedWhite: Color,
    public val goldIcon: Color,
    public val greenIcon: Color,
    public val invertedIcon: Color,
    public val invertedText: Color,
    public val linkText: Color,
    public val linkTextHover: Color,
    public val linkTextVisited: Color,
    public val onBlue: Color,
    public val onBlueContainer: Color,
    public val orangeIcon: Color,
    public val placeholderIcon: Color,
    public val placeholderText: Color,
    public val primaryContainer: Color,
    public val primaryText: Color,
    public val purpleIcon: Color,
    public val secondaryContainer: Color,
    public val secondaryIcon: Color,
    public val subtext: Color,
    public val surfaceOutline: Color,
    public val surfaceOutlineDisabled: Color,
    public val timestampText: Color,
    public val yellowIcon: Color
)
