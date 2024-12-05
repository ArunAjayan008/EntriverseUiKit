package entriverse.shared.theme.dimen

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Immutable
data class EntriverseDimens internal constructor(
    val referenceDimens: ReferenceDimens,
    val fontDimens: FontDimens,
    val fontWeightDimens:FontWeightDimens,
    val lineHeightDimens:LineHeightDimens,
    val letterSpacingDimens:LetterSpacingDimens,
    val paraSpacingDimens:ParaSpacingDimens
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

@Immutable
data class FontDimens internal constructor(
    val fontSize100: TextUnit,
    val fontSize200: TextUnit,
    val fontSize300: TextUnit,
    val fontSize400: TextUnit,
    val fontSize500: TextUnit,
    val fontSize600: TextUnit,
    val fontSize700: TextUnit,
    val fontSize800: TextUnit,
    val fontSize900: TextUnit,
    val fontSize1000: TextUnit,
    val fontSize1100: TextUnit,
    val fontSize1200: TextUnit,
    val fontSize1300: TextUnit,
    val fontSize1400: TextUnit,
    val fontSize1500: TextUnit,
    val fontSize1600: TextUnit
)

@Immutable
data class FontWeightDimens internal constructor(
    val fontWeight100: FontWeight,
    val fontWeight200: FontWeight,
    val fontWeight300: FontWeight,
    val fontWeight400: FontWeight,
    val fontWeight500: FontWeight,
    val fontWeight600: FontWeight,
    val fontWeight700: FontWeight,
    val fontWeight800: FontWeight,
    val fontWeight900: FontWeight,

    )

@Immutable
data class LineHeightDimens internal constructor(
    val lineHeight100: TextUnit,
    val lineHeight200: TextUnit,
    val lineHeight300: TextUnit,
    val lineHeight400: TextUnit,
    val lineHeight500: TextUnit,
    val lineHeight600: TextUnit,
    val lineHeight700: TextUnit,
    val lineHeight800: TextUnit,
    val lineHeight900: TextUnit,
    val lineHeight1000: TextUnit,
    val lineHeight1100: TextUnit,
    val lineHeight1200: TextUnit,
    val lineHeight1300: TextUnit,
    val lineHeight1400: TextUnit,
    val lineHeight1500: TextUnit,
    val lineHeight1600: TextUnit,
    val lineHeight1700: TextUnit,
    val lineHeight1800: TextUnit,
    val lineHeight1900: TextUnit,
    val lineHeight2000: TextUnit,
)

@Immutable
data class LetterSpacingDimens internal constructor(
    val letterSpacing100: TextUnit,
    val letterSpacing200: TextUnit,
    val letterSpacing300: TextUnit,
    val letterSpacing400: TextUnit,
    val letterSpacing500: TextUnit,
    val letterSpacing600: TextUnit,
    val letterSpacing700: TextUnit,
    val letterSpacing800: TextUnit,
)

@Immutable
data class ParaSpacingDimens internal constructor(
    val paraSpacing100: TextUnit,
    val paraSpacing200: TextUnit,
    val paraSpacing300: TextUnit,
    val paraSpacing400: TextUnit,
    val paraSpacing500: TextUnit,
    val paraSpacing600: TextUnit,
    val paraSpacing700: TextUnit,
    val paraSpacing800: TextUnit,
)