package me.arunajayan.entriverselibrary.theme.typography

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import me.arunajayan.entriverselibrary.theme.colors.EntriverseColors

@Immutable
public data class EntriverseTypography constructor(
    private val colors: EntriverseColors,
    public val display1: TextStyle,
)