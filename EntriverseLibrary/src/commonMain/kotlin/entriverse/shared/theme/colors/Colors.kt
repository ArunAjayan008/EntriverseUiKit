package entriverse.shared.theme.colors

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
internal fun ProvideEntriverseColors(colors: EntriverseColors, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalEntriverseColors provides colors, content = content)
}

internal val LocalEntriverseColors = staticCompositionLocalOf { lightColors }

internal val lightColors = with(entriverse.shared.Entriverse.palette) {
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
            blueHover = blue300,
            entriGreen = green500,
            onGreen = pureWhite,
            greenContainer = green50,
            onGreenContainer = green800,
            greenHover = green800,
            entriPurple = purple500,
            onPurple = pureWhite,
            purpleContainer = purple50,
            onPurpleContainer = purple800,
            purpleHover = purple800,
            entriOrange = orange500,
            onOrange = grey1000,
            orangeContainer = orange50,
            onOrangeContainer = orange800,
            orangeHover = orange800,
            entriYellow = yellow500,
            onYellow = grey1000,
            yellowContainer = yellow50,
            onYellowContainer = yellow800,
            yellowHover = yellow800,
            entriBrown = brown500,
            onBrown = pureWhite,
            brownContainer = brown50,
            onBrownContainer = brown800,
            brownHover = brown800,
            entriGold = gold500,
            onGold = grey1000,
            goldContainer = gold50,
            onGoldContainer = gold800,
            goldHover = gold800,
            errorColor = red500,
            onError = pureWhite,
            errorTextColor = red500,
            errorOutlineColor = red800,
            errorContainer = red50,
            onErrorContainer = red800,
            errorHover = red800,
            successColor = green500,
            onSuccess = pureWhite,
            successTextColor = green500,
            successOutlineColor = green800,
            successContainer = green50,
            onSuccessContainer = green800,
            successHover = green800
        ),
        componentColors = ComponentColors(
            buttonXsDestructiveDefault =,
            buttonXsDestructiveDefaultText =,
            buttonXsDestructiveDefaultIcon =,
            buttonXsDestructiveDisabled =,
            buttonXsDestructiveDisabledText =,
            buttonXsDestructiveDisabledIcon =,
            buttonXsDestructiveHover =,
            buttonXsDestructiveHoverIcon =,
            buttonXsDestructiveFocused =,
            buttonXsDestructiveFocusedText =,
            buttonXsDestructiveFocusedIcon =,
            buttonXsDestructiveFocusedBorder =,
            buttonXsOutlinedBorderDefault =,
            buttonXsOutlinedDefaultText =,
            buttonXsOutlinedDefaultIcon =,
            buttonXsOutlinedBorderDisabled =,
            buttonXsOutlinedDisabledText =,
            buttonXsOutlinedDisabledIcon =,
            buttonXsOutlinedFillHover =,
            buttonXsOutlinedBorderHover =,
            buttonXsOutlinedHoverText =,
            buttonXsOutlinedHoverIcon =,
            buttonXsOutlinedFillFocused =,
            buttonXsOutlinedBorderFocused =,
            buttonXsOutlinedFocusedText =,
            buttonXsOutlinedFocusedIcon =,
            buttonXsSecondaryOutlinedBorderDefault =,
            buttonXsSecondaryOutlinedDefaultText =,
            buttonXsSecondaryOutlinedDefaultIcon =,
            buttonXsSecondaryOutlinedBorderDisabled =,
            buttonXsSecondaryOutlinedDisabledText =,
            buttonXsSecondaryOutlinedDisabledIcon =,
            buttonXsSecondaryOutlinedFillHover =,
            buttonXsSecondaryOutlinedBorderHover =,
            buttonXsSecondaryOutlinedHoverText =,
            buttonXsSecondaryOutlinedHoverIcon =,
            buttonXsSecondaryOutlinedFillFocused =,
            buttonXsSecondaryOutlinedBorderFocused =,
            buttonXsSecondaryOutlinedFocusedText =,
            buttonXsSecondaryOutlinedFocusedIcon =,
            buttonXsSuccessDefault =,
            buttonXsSuccessDefaultText =,
            buttonXsSuccessDefaultIcon =,
            buttonXsSuccessDisabled =,
            buttonXsSuccessDisabledText =,
            buttonXsSuccessDisabledIcon =,
            buttonXsSuccessHover =,
            buttonXsSuccessHoverText =,
            buttonXsSuccessHoverIcon =,
            buttonXsSuccessFocused =,
            buttonXsSuccessFocusedText =,
            buttonXsSuccessFocusedIcon =,
            buttonXsSuccessFocusedBorder =,
            buttonXsTonalDefault =,
            buttonXsTonalDefaultText =,
            buttonXsTonalDefaultIcon =,
            buttonXsTonalDisabled =,
            buttonXsTonalDisabledText =,
            buttonXsTonalDisabledIcon =,
            buttonXsTonalHover =,
            buttonXsTonalHoverText =,
            buttonXsTonalHoverIcon =,
            buttonXsTonalFocused =,
            buttonXsTonalFocusedText =,
            buttonXsTonalFocusedIcon =,
            buttonXsTonalFocusedBorder =,
            buttonXsFilledDefault =
        )
    )
}

internal val darkColors = with(entriverse.shared.Entriverse.palette) {
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
            blueHover = blue800,
            entriGreen =green400,
            onGreen =green900,
            greenContainer =green900,
            onGreenContainer =green100,
            greenHover =green300,
            entriPurple =purple400,
            onPurple =purple900,
            purpleContainer =purple900,
            onPurpleContainer =purple100,
            purpleHover =purple300,
            entriOrange =orange400,
            onOrange =orange900,
            orangeContainer =orange900,
            onOrangeContainer =orange100,
            orangeHover =orange300,
            entriYellow =yellow400,
            onYellow =yellow900,
            yellowContainer =yellow900,
            onYellowContainer =yellow100,
            yellowHover =yellow300,
            entriBrown =brown400,
            onBrown =brown900,
            brownContainer =brown900,
            onBrownContainer =brown100,
            brownHover =brown300,
            entriGold =gold400,
            onGold =gold900,
            goldContainer =gold900,
            onGoldContainer =gold100,
            goldHover =gold300,
            errorColor =red400,
            onError =red900,
            errorTextColor =red400,
            errorOutlineColor =red100,
            errorContainer =red900,
            onErrorContainer =red100,
            errorHover =red300,
            successColor =green400,
            onSuccess =green900,
            successTextColor =green400,
            successOutlineColor =green100,
            successContainer =green900,
            onSuccessContainer =green100,
            successHover =green300,
        ),
        componentColors = ComponentColors(
            buttonXsDestructiveDefault =,
            buttonXsDestructiveDefaultText =,
            buttonXsDestructiveDefaultIcon =,
            buttonXsDestructiveDisabled =,
            buttonXsDestructiveDisabledText =,
            buttonXsDestructiveDisabledIcon =,
            buttonXsDestructiveHover =,
            buttonXsDestructiveHoverIcon =,
            buttonXsDestructiveFocused =,
            buttonXsDestructiveFocusedText =,
            buttonXsDestructiveFocusedIcon =,
            buttonXsDestructiveFocusedBorder =,
            buttonXsOutlinedBorderDefault =,
            buttonXsOutlinedDefaultText =,
            buttonXsOutlinedDefaultIcon =,
            buttonXsOutlinedBorderDisabled =,
            buttonXsOutlinedDisabledText =,
            buttonXsOutlinedDisabledIcon =,
            buttonXsOutlinedFillHover =,
            buttonXsOutlinedBorderHover =,
            buttonXsOutlinedHoverText =,
            buttonXsOutlinedHoverIcon =,
            buttonXsOutlinedFillFocused =,
            buttonXsOutlinedBorderFocused =,
            buttonXsOutlinedFocusedText =,
            buttonXsOutlinedFocusedIcon =,
            buttonXsSecondaryOutlinedBorderDefault =,
            buttonXsSecondaryOutlinedDefaultText =,
            buttonXsSecondaryOutlinedDefaultIcon =,
            buttonXsSecondaryOutlinedBorderDisabled =,
            buttonXsSecondaryOutlinedDisabledText =,
            buttonXsSecondaryOutlinedDisabledIcon =,
            buttonXsSecondaryOutlinedFillHover =,
            buttonXsSecondaryOutlinedBorderHover =,
            buttonXsSecondaryOutlinedHoverText =,
            buttonXsSecondaryOutlinedHoverIcon =,
            buttonXsSecondaryOutlinedFillFocused =,
            buttonXsSecondaryOutlinedBorderFocused =,
            buttonXsSecondaryOutlinedFocusedText =,
            buttonXsSecondaryOutlinedFocusedIcon =,
            buttonXsSuccessDefault =,
            buttonXsSuccessDefaultText =,
            buttonXsSuccessDefaultIcon =,
            buttonXsSuccessDisabled =,
            buttonXsSuccessDisabledText =,
            buttonXsSuccessDisabledIcon =,
            buttonXsSuccessHover =,
            buttonXsSuccessHoverText =,
            buttonXsSuccessHoverIcon =,
            buttonXsSuccessFocused =,
            buttonXsSuccessFocusedText =,
            buttonXsSuccessFocusedIcon =,
            buttonXsSuccessFocusedBorder =,
            buttonXsTonalDefault =,
            buttonXsTonalDefaultText =,
            buttonXsTonalDefaultIcon =,
            buttonXsTonalDisabled =,
            buttonXsTonalDisabledText =,
            buttonXsTonalDisabledIcon =,
            buttonXsTonalHover =,
            buttonXsTonalHoverText =,
            buttonXsTonalHoverIcon =,
            buttonXsTonalFocused =,
            buttonXsTonalFocusedText =,
            buttonXsTonalFocusedIcon =,
            buttonXsTonalFocusedBorder =,
            buttonXsFilledDefault =
        )
    )
}
