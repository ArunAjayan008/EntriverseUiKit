package me.arunajayan.entriverselibrary.theme.typography

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import me.arunajayan.entriverselibrary.theme.colors.EntriverseColors

@Immutable
public data class EntriverseTypography(
    private val colors: EntriverseColors,
    public val h1:TextStyle,
    public val h1Bold:TextStyle,
    public val h2:TextStyle,
    public val h2Bold:TextStyle,
    public val h3:TextStyle,
    public val h3Bold:TextStyle,
    public val h4:TextStyle,
    public val h4Bold:TextStyle,
    public val display1: TextStyle,
    public val buttonDefault: TextStyle,
    public val buttonBold: TextStyle,
    public val buttonItalic: TextStyle,
)