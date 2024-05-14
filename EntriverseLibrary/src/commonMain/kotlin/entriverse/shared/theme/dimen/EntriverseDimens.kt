package entriverse.shared.theme.dimen

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

@Immutable
 data class EntriverseDimens internal constructor(
     val referenceDimens: ReferenceDimens
)

@Immutable
 data class ReferenceDimens internal constructor(
     val spacingNone: Dp,
     val spacingXs: Dp,
     val spacingS: Dp,
     val spacingM: Dp,
     val spacingL: Dp,
     val spacingXl: Dp,
     val spacingXxl: Dp,
     val spacingXxxl: Dp
)