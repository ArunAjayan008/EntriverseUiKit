package me.arunajayan.entriverselibrary.theme.dimen

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//
//internal val EntriverseDimens = staticCompositionLocalOf {  }
//
//internal val fontDimens =
//public class EntriverseDimens internal constructor(
//    public val fontDimens: FontDimens
//) {

class EntriverseFontDimens internal constructor(
    val text12sp: TextUnit = 12.sp,
    val text14sp: TextUnit = 14.sp
)

class EntriverseDimensValues internal constructor() {
    public val spacing0: Dp = 0.dp
    public val spacing50: Dp = 2.dp
    public val spacing100: Dp = 4.dp
    public val spacing200: Dp = 6.dp
    public val spacing300: Dp = 8.dp
    public val spacing400: Dp = 12.dp
    public val spacing500: Dp = 16.dp
    public val spacing600: Dp = 24.dp
    public val spacing700: Dp = 32.dp
    public val spacing800: Dp = 40.dp
    public val spacing900: Dp = 48.dp
    public val spacing1000: Dp = 56.dp
    public val spacing1100: Dp = 64.dp
    public val spacing1200: Dp = 72.dp
    public val spacing1300: Dp = 96.dp
    public val spacing1400: Dp = 120.dp
}
