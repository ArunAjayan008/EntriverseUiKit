package entriverse.shared.theme.dimen

import androidx.compose.runtime.staticCompositionLocalOf
import entriverse.shared.Entriverse.dimens

internal val LocalDimens = staticCompositionLocalOf { dimenValue }

internal val dimenValue = with(dimens) {
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
        ),
        fontDimens = FontDimens(
            fontSize100 = text8sp,
            fontSize200 = text10sp,
            fontSize300 = text12sp,
            fontSize400 = text14sp,
            fontSize500 = text16sp,
            fontSize600 = text18sp,
            fontSize700 = text20sp,
            fontSize800 = text24sp,
            fontSize900 = text28sp,
            fontSize1000 = text32sp,
            fontSize1100 = text40sp,
            fontSize1200 = text48sp,
            fontSize1300 = text54sp,
            fontSize1400 = text60sp,
            fontSize1500 = text72sp,
            fontSize1600 = text94sp
        ),
        fontWeightDimens = FontWeightDimens(
            fontWeight100 = fontWeight100,
            fontWeight200 = fontWeight200,
            fontWeight300 = fontWeight300,
            fontWeight400 = fontWeight400,
            fontWeight500 = fontWeight500,
            fontWeight600 = fontWeight600,
            fontWeight700 = fontWeight700,
            fontWeight800 = fontWeight800,
            fontWeight900 = fontWeight900,
        ),
        lineHeightDimens = LineHeightDimens(
            lineHeight100 = text8sp,
            lineHeight200 = text10sp,
            lineHeight300 = text12sp,
            lineHeight400 = text13_8sp,
            lineHeight500 = text14_4sp,
            lineHeight600 = text16_1sp,
            lineHeight700 = text16_5sp,
            lineHeight800 = text17sp,
            lineHeight900 = text17_5sp,
            lineHeight1000 = text18sp,
            lineHeight1100 = text18_4sp,
            lineHeight1200 = text20sp,
            lineHeight1300 = text21sp,
            lineHeight1400 = text22_4sp,
            lineHeight1500 = text24sp,
            lineHeight1600 = text28_8sp,
            lineHeight1700 = text38_4sp,
            lineHeight1800 = text57_6sp,
            lineHeight1900 = text72sp,
            lineHeight2000 = text112_8sp,
        ),
        letterSpacingDimens = LetterSpacingDimens(
            letterSpacing100 = textMinus1_5sp,
            letterSpacing200 = textMinus0_5sp,
            letterSpacing300 = text0sp,
            letterSpacing400 = text0_1sp,
            letterSpacing500 = text0_15sp,
            letterSpacing600 = text0_25sp,
            letterSpacing700 = text0_5sp,
            letterSpacing800 = text1sp,
        ),
        paraSpacingDimens = ParaSpacingDimens(
            paraSpacing100 = text0sp,
            paraSpacing200 = text2sp,
            paraSpacing300 = text4sp,
            paraSpacing400 = text8sp,
            paraSpacing500 = text12sp,
            paraSpacing600 = text16sp,
            paraSpacing700 = text24sp,
            paraSpacing800 = text32sp,
        ),
    )
}