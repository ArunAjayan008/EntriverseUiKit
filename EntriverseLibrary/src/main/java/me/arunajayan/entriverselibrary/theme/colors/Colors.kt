package me.arunajayan.entriverselibrary.theme.colors

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import me.arunajayan.entriverselibrary.Entriverse

@Composable
internal fun ProvideEntriverseColors(colors: EntriverseColors, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalEntriverseColors provides colors, content = content)
}

internal val LocalEntriverseColors = staticCompositionLocalOf { lightColors }

internal val lightColors = with(Entriverse.palette) {
    EntriverseColors(
        lightMode = true,
        referenceColors = ReferenceColors(
            backgroundDefault = grey1400,
            backgroundGrey = pureBlack,
            primaryContainer = grey1100,
            secondaryContainer = grey1200,
            surfaceOutline = grey600,
            surfaceOutlineDisabled = grey1300,
            blueOutline = blue200,
            primaryText = grey30,
            subtext = grey70,
            placeholderText = grey90,
            timestampText = grey100,
            invertedText = grey1000,
            disabledText = grey300,
            linkText = blue100,
            linkTextHover = blue300,
            linkTextVisited = purple200,
            defaultIcon = grey30,
            secondaryIcon = grey70,
            invertedIcon = grey1000,
            placeholderIcon = grey100,
            disabledIcon = grey300,
            blueIcon = blue400,
            greenIcon = green400,
            purpleIcon = purple400,
            orangeIcon = orange400,
            yellowIcon = yellow400,
            brownIcon = brown400,
            goldIcon = gold400,
            fixedWhite = pureWhite,
            fixedBlack = grey1000,
            fixedPureBlack = pureBlack,
            entriBlue = blue400,
            onBlue = blue900,
            blueContainer = blue900,
            onBlueContainer = blue100,
            blueHover = blue300
        )
    )
}

internal val darkColors = with(Entriverse.palette) {
    EntriverseColors(
        lightMode = false,
        referenceColors = ReferenceColors(
            backgroundDefault = blue100,
            backgroundGrey = grey30,
            primaryContainer = pureWhite,
            secondaryContainer = grey20,
            surfaceOutline = grey30,
            surfaceOutlineDisabled = grey10,
            blueOutline = blue700,
            primaryText = grey1000,
            subtext = grey80,
            placeholderText = grey60,
            timestampText = grey50,
            invertedText = grey30,
            disabledText = grey40,
            linkText = blue700,
            linkTextHover = blue800,
            linkTextVisited = purple700,
            defaultIcon = grey1000,
            secondaryIcon = grey80,
            invertedIcon = grey30,
            placeholderIcon = grey50,
            disabledIcon = grey40,
            blueIcon = blue500,
            greenIcon = green500,
            purpleIcon = purple500,
            orangeIcon = orange500,
            yellowIcon = yellow500,
            brownIcon = brown500,
            goldIcon = gold500,
            fixedWhite = pureWhite,
            fixedBlack = grey1000,
            fixedPureBlack = pureBlack,
            entriBlue = blue500,
            onBlue = pureWhite,
            blueContainer = blue50,
            onBlueContainer = blue800,
            blueHover = blue800
        )
    )
}
