package entriverse.shared.theme.dimen
import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalDimens = staticCompositionLocalOf { dimenValue }

internal val dimenValue = with(entriverse.shared.Entriverse.dimens) {
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