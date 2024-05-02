package me.arunajayan.entriverselibrary.theme.dimen

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

@Immutable
public data class EntriverseDimens internal constructor(
    public val referenceDimens: ReferenceDimens
)

@Immutable
public data class ReferenceDimens internal constructor(
    public val spacingNone: Dp,
    public val spacingXs: Dp,
    public val spacingS: Dp,
    public val spacingM: Dp,
    public val spacingL: Dp,
    public val spacingXl: Dp,
    public val spacingXxl: Dp,
    public val spacingXxxl: Dp
)