package entriverse.shared.theme.colors


fun createDarkColors(): EntriverseColors {
    return EntriverseColors(
        lightMode = false,
        referenceColors = createDarkReferenceColors(),
        componentColors = createDarkComponentColors(),
        materialColors = createDarkMaterialColors()
    )
}

fun createDarkReferenceColors(): ReferenceColors {
    with(entriverse.shared.Entriverse.palette) {
        return ReferenceColors(
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
        )
    }
}

fun createDarkComponentColors(): ComponentColors {
    with(entriverse.shared.Entriverse.palette) {
        return ComponentColors(
            buttonColors = ButtonColors(
                // CTA - Button
                buttonFilledDefault = blue200,
                buttonFilledDefaultText = blue900,
                buttonFilledDisabledText = grey100,
                buttonFilledDisabled = grey600,
                buttonFilledHover = blue300,
                buttonFilledHoverText = blue900,
                buttonFilledFocused = blue300,
                buttonFilledFocusedText = blue900,
                buttonFilledFocusedBorder = blue50,

                buttonTonalDefault = grey200,
                buttonTonalDefaultText = grey30,
                buttonTonalDisabled = grey600,
                buttonTonalDisabledText = grey100,
                buttonTonalHover = grey100,
                buttonTonalHoverText = grey30,
                buttonTonalFocused = grey100,
                buttonTonalFocusedText = grey30,
                buttonTonalFocusedBorder = grey30,

                buttonFilledDefaultIcon = blue900,
                buttonFilledDisabledIcon = grey100,
                buttonFilledHoverIcon = blue900,
                buttonFilledFocusedIcon = blue900,

                buttonTonalDefaultIcon = grey30,
                buttonTonalDisabledIcon = grey100,
                buttonTonalHoverIcon = grey30,
                buttonTonalFocusedIcon = grey30,

                buttonOutlinedBorderDefault = blue200,
                buttonOutlinedDefaultText = blue100,
                buttonOutlinedDefaultIcon = blue100,
                buttonOutlinedBorderDisabled = grey600,
                buttonOutlinedDisabledText = grey100,
                buttonOutlinedDisabledIcon = grey100,
                buttonOutlinedFillHover = blue300,
                buttonOutlinedHoverText = blue900,
                buttonOutlinedHoverIcon = blue900,
                buttonOutlinedFillFocused = blue300,
                buttonOutlinedFocusedText = blue900,
                buttonOutlinedFocusedIcon = blue900,
                buttonOutlinedBorderHover = blue200,
                buttonOutlinedBorderFocused = blue50,

                buttonSecondaryOutlinedBorderDefault = grey300,
                buttonSecondaryOutlinedDefaultText = grey30,
                buttonSecondaryOutlinedDefaultIcon = grey30,
                buttonSecondaryOutlinedBorderDisabled = grey600,
                buttonSecondaryOutlinedDisabledText = grey100,
                buttonSecondaryOutlinedDisabledIcon = grey100,
                buttonSecondaryOutlinedFillHover = grey100,
                buttonSecondaryOutlinedBorderHover = grey300,
                buttonSecondaryOutlinedHoverText = grey30,
                buttonSecondaryOutlinedHoverIcon = grey30,
                buttonSecondaryOutlinedFillFocused = grey100,
                buttonSecondaryOutlinedBorderFocused = grey30,
                buttonSecondaryOutlinedFocusedText = grey30,
                buttonSecondaryOutlinedFocusedIcon = grey30,

                buttonDestructiveDefault = red200,
                buttonDestructiveDefaultText = red900,
                buttonDestructiveDefaultIcon = red900,
                buttonDestructiveDisabled = grey600,
                buttonDestructiveDisabledText = grey100,
                buttonDestructiveDisabledIcon = grey100,
                buttonDestructiveHover = red300,
                buttonDestructiveHoverText = red900,
                buttonDestructiveHoverIcon = red900,
                buttonDestructiveFocused = red300,
                buttonDestructiveFocusedText = red900,
                buttonDestructiveFocusedIcon = red900,
                buttonDestructiveFocusedBorder = red50,

                buttonSuccessDefault = green200,
                buttonSuccessDefaultText = green900,
                buttonSuccessDefaultIcon = green900,
                buttonSuccessDisabled = grey600,
                buttonSuccessDisabledText = grey100,
                buttonSuccessDisabledIcon = grey100,
                buttonSuccessHover = green300,
                buttonSuccessHoverText = green900,
                buttonSuccessHoverIcon = green900,
                buttonSuccessFocused = green300,
                buttonSuccessFocusedText = green900,
                buttonSuccessFocusedIcon = green900,
                buttonSuccessFocusedBorder = green50,
            ),
            fabColors = FabColors(
                fabContainerColor = orange800,
                fabTextColor = orange100,
                fabIconColor = orange100,
                fabHoverColor = gold700,
            ), checkboxColors = CheckboxColors(
                checkboxActive = blue200,
                checkboxInactive = grey100,
                checkboxInactiveHover = grey70,
                checkboxActiveHover = blue300,
                checkboxDisabled = grey300,
            ), inputColors = InputColors(
                cursorColor = blue100,
                inputTextActive = grey30,
                inputTextDisabled = grey300,
                inputTextPlaceholder = grey70,
                inputContainerSuccess = green400,
                inputContainerError =red100,
                inputContainerFocused = blue200,
                inputContainerOutline = grey100,
            ), labelColors = LabelColors(
                labelText = grey90,
                labelTextFocused = blue400,
                labelTextDisabled = grey300,
                labelBgColorDefault = grey1400,
                labelBgColorPrimaryContainer = grey1100,
                labelTextError = red400,
                labelTextSuccess = green400,
            ), iconColors = IconColors(
                trailingIcon = grey30,
                trailingIconFocused = blue400,
                trailingIconError = red400,
                trailingIconSuccess = green400,
                trailingIconDisabled = grey300,
                trailingIconSecondary = grey70,
                trailingIconPlaceholder = grey100,
                leadingIcon = grey30,
                leadingIconFocused = blue400,
                leadingIconDisabled = grey300,
                leadingIconError = red400,
                leadingIconSuccess = green400,
                leadingIconPlaceholder = grey100,
            ), supportingTextColors = SupportingTextColors(
                supportingText = grey90,
                supportingTextError = red400,
                supportingTextSuccess = green400,
                supportingTextDisabled = grey300,
            ), navigationBarColors = NavigationBarColors(
                navContainerColor = grey1100,
                navTextColor = grey30,
                navActiveIndicator = blue900,
                navIconActive = blue200,
                navIconInactive = grey50,
                navPremiumIconActive = purple400,
                navDividerColor = grey600,
            ), radioButtonColors = RadioButtonColors(
                radioActive = blue200,
                radioInactiveHover = grey70,
                radioActiveHover = blue300,
                radioDisabled = grey300,
                radioInactive = grey100,
            ), segmentedButtonColors = SegmentedButtonColors(
                segmentedActive = blue900,
                segmentedActiveOutline = blue200,
                segmentedInactiveContainer = fixedPureBlack,
                segmentedInactiveOutline = grey600,
                segmentedActiveText = blue500,
                segmentedActiveIcon = blue500,
                segmentedInactiveIcon = grey30,
                segmentedInactiveText = grey30,
                segmentedBg = grey1100,
            ), sliderColors = SliderColors(
                sliderValueContainerBg = grey20,
                sliderValueText = grey1000,
                sliderHandleContainerBg = grey1100,
                sliderHandle = blue400,
                sliderInactiveTrack = blue900,
                sliderActiveTrack = blue400,
                sliderStopIndicatorInactive = fixedWhiteLevel2,
                sliderDisabledTrack = grey30,
                sliderHandleDisabled = grey30,
                sliderHandleDisabledContainer = grey1100,
                sliderStopIndicatorActive = fixedBlackLevel2,
                sliderStopIndicatorDisabled = fixedWhiteLevel2,
            ), snackBarColors = SnackbarColors(
                snackbarBgDefault = grey10,
                snackbarText = grey1000,
                snackbarPrimaryCta = blue700,
            ), tabsColors = TabsColors(
                secondaryTabActiveText = grey30,
                secondaryTabInactiveText = grey70,
                secondaryTabIndicator = blue400,
                secondaryTabDivider = grey600,
                secondaryTabBgColor = grey1400,
                secondaryTabHover = grey800,
            ), tooltipColors = TooltipColors(
                tooltipBgDefault = grey10,
                tooltipBgGrey = grey20,
                tooltipPrimaryText = grey1000,
                tooltipSubtext = grey300,
                tooltipPrimaryCta = blue700,
                tooltipSecondaryCta = grey100,
            ), selectionColors = SelectionColors(
                selectionText = blue700,
                selectionActive = blue900,
                selectionInactive = grey1200,
                selectionOutlineActive = blue200,
                selectionSubtext = grey50,
                selectionProgressBarBg = darkLevel1,
                selectionProgressIndicator = green400,
                selectionDisabledText = grey100,
                selectionDisabled = grey400,
                selectionGoldActive = gold900,
                selectionGoldOutlineActive = gold400,
                selectionOutlineInactive = grey600,
                selectionTextGold = gold100,
            )
        )
    }
}

fun createDarkMaterialColors(): MaterialColors {
    with(entriverse.shared.Entriverse.palette) {
        return MaterialColors(
            primary = DarkPrimary,
            onPrimary = DarkOnPrimary,
            primaryContainer = DarkPrimaryContainer,
            onPrimaryContainer = DarkOnPrimaryContainer,
            inversePrimary = DarkInversePrimary,
            secondary = DarkSecondary,
            onSecondary = DarkOnSecondary,
            secondaryContainer = DarkSecondaryContainer,
            onSecondaryContainer = DarkOnSecondaryContainer,
            tertiary = DarkTertiary,
            onTertiary = DarkOnTertiary,
            tertiaryContainer = DarkTertiaryContainer,
            onTertiaryContainer = DarkOnTertiaryContainer,
            background = DarkBackground,
            onBackground = DarkOnBackground,
            surface = DarkSurface,
            onSurface = DarkOnSurface,
            surfaceVariant = DarkSurfaceVariant,
            onSurfaceVariant = DarkOnSurfaceVariant,
            surfaceTint = DarkSurfaceTint,
            inverseSurface = DarkInverseSurface,
            inverseOnSurface = DarkInverseOnSurface,
            error = DarkError,
            onError = DarkOnError,
            errorContainer = DarkErrorContainer,
            onErrorContainer = DarkOnErrorContainer,
            outline = DarkOutline,
            outlineVariant = DarkOutlineVariant,
            scrim = DarkScrim
        )
    }
}
