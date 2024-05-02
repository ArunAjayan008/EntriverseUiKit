package me.arunajayan.entriverselibrary.theme.dimen

import androidx.compose.runtime.staticCompositionLocalOf
import me.arunajayan.entriverselibrary.Entriverse

internal val LocalDimens = staticCompositionLocalOf { dimenValue }

internal val dimenValue = with(Entriverse.dimens) {
    EntriverseDimens(
        referenceDimens = ReferenceDimens(
            spacingNone = spacing0,
            spacingXs = spacing50,
            spacingS = spacing100,
            spacingM = spacing300,
            spacingL = spacing400,
            spacingXl = spacing500,
            spacingXxl = spacing600,
            spacingXxxl = spacing700
        )
    )
}