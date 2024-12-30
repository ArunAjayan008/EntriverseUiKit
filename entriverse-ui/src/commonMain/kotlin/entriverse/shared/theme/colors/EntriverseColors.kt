package entriverse.shared.theme.colors

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class EntriverseColors internal constructor(
    val lightMode: Boolean,
    val referenceColors: ReferenceColors,
    val componentColors: ComponentColors,
    val materialColors: MaterialColors,
)

@Immutable
data class ReferenceColors internal constructor(
    val backgroundDefault: Color,
    val backgroundGrey: Color,
    val blueContainer: Color,
    val blueHover: Color,
    val blueIcon: Color,
    val blueOutline: Color,
    val brownIcon: Color,
    val defaultIcon: Color,
    val disabledIcon: Color,
    val disabledText: Color,
    val entriBlue: Color,
    val fixedBlack: Color,
    val fixedPureBlack: Color,
    val fixedWhite: Color,
    val goldIcon: Color,
    val greenIcon: Color,
    val invertedIcon: Color,
    val invertedText: Color,
    val linkText: Color,
    val linkTextHover: Color,
    val linkTextVisited: Color,
    val onBlue: Color,
    val onBlueContainer: Color,
    val orangeIcon: Color,
    val placeholderIcon: Color,
    val placeholderText: Color,
    val primaryContainer: Color,
    val primaryText: Color,
    val purpleIcon: Color,
    val secondaryContainer: Color,
    val secondaryIcon: Color,
    val subtext: Color,
    val surfaceOutline: Color,
    val surfaceOutlineDisabled: Color,
    val timestampText: Color,
    val yellowIcon: Color,
    val entriGreen: Color,
    val onGreen: Color,
    val greenContainer: Color,
    val onGreenContainer: Color,
    val greenHover: Color,
    val entriPurple: Color,
    val onPurple: Color,
    val purpleContainer: Color,
    val onPurpleContainer: Color,
    val purpleHover: Color,
    val entriOrange: Color,
    val onOrange: Color,
    val orangeContainer: Color,
    val onOrangeContainer: Color,
    val orangeHover: Color,
    val entriYellow: Color,
    val onYellow: Color,
    val yellowContainer: Color,
    val onYellowContainer: Color,
    val yellowHover: Color,
    val entriBrown: Color,
    val onBrown: Color,
    val brownContainer: Color,
    val onBrownContainer: Color,
    val brownHover: Color,
    val entriGold: Color,
    val onGold: Color,
    val goldContainer: Color,
    val onGoldContainer: Color,
    val goldHover: Color,
    val errorColor: Color,
    val onError: Color,
    val errorTextColor: Color,
    val errorOutlineColor: Color,
    val errorContainer: Color,
    val onErrorContainer: Color,
    val errorHover: Color,
    val successColor: Color,
    val onSuccess: Color,
    val successTextColor: Color,
    val successOutlineColor: Color,
    val successContainer: Color,
    val onSuccessContainer: Color,
    val successHover: Color,
)

@Immutable
data class ComponentColors(
    val buttonColors: ButtonColors,
    val fabColors: FabColors,
    val checkboxColors: CheckboxColors,
    val inputColors: InputColors,
    val labelColors: LabelColors,
    val iconColors: IconColors,
    val supportingTextColors: SupportingTextColors,
    val navigationBarColors: NavigationBarColors,
    val radioButtonColors: RadioButtonColors,
    val segmentedButtonColors: SegmentedButtonColors,
    val sliderColors: SliderColors,
    val snackBarColors: SnackbarColors,
    val tabsColors: TabsColors,
    val tooltipColors: TooltipColors,
    val selectionColors: SelectionColors
)

@Immutable
data class ButtonColors(
    val buttonFilledDefault: Color,
    val buttonFilledDefaultText: Color,
    val buttonFilledDisabledText: Color,
    val buttonFilledDisabled: Color,
    val buttonFilledHover: Color,
    val buttonFilledHoverText: Color,
    val buttonFilledFocused: Color,
    val buttonFilledFocusedText: Color,
    val buttonFilledFocusedBorder: Color,
    val buttonFilledDefaultIcon: Color,
    val buttonFilledDisabledIcon: Color,
    val buttonFilledHoverIcon: Color,
    val buttonFilledFocusedIcon: Color,
    val buttonTonalDefault: Color,
    val buttonTonalDefaultText: Color,
    val buttonTonalDisabled: Color,
    val buttonTonalDisabledText: Color,
    val buttonTonalHover: Color,
    val buttonTonalHoverText: Color,
    val buttonTonalFocused: Color,
    val buttonTonalFocusedText: Color,
    val buttonTonalFocusedBorder: Color,
    val buttonTonalDefaultIcon: Color,
    val buttonTonalDisabledIcon: Color,
    val buttonTonalHoverIcon: Color,
    val buttonTonalFocusedIcon: Color,
    val buttonOutlinedBorderDefault: Color,
    val buttonOutlinedDefaultText: Color,
    val buttonOutlinedDefaultIcon: Color,
    val buttonOutlinedBorderDisabled: Color,
    val buttonOutlinedDisabledText: Color,
    val buttonOutlinedDisabledIcon: Color,
    val buttonOutlinedFillHover: Color,
    val buttonOutlinedHoverText: Color,
    val buttonOutlinedHoverIcon: Color,
    val buttonOutlinedFillFocused: Color,
    val buttonOutlinedFocusedText: Color,
    val buttonOutlinedFocusedIcon: Color,
    val buttonOutlinedBorderHover: Color,
    val buttonOutlinedBorderFocused: Color,
    val buttonSecondaryOutlinedBorderDefault: Color,
    val buttonSecondaryOutlinedDefaultText: Color,
    val buttonSecondaryOutlinedDefaultIcon: Color,
    val buttonSecondaryOutlinedBorderDisabled: Color,
    val buttonSecondaryOutlinedDisabledText: Color,
    val buttonSecondaryOutlinedDisabledIcon: Color,
    val buttonSecondaryOutlinedFillHover: Color,
    val buttonSecondaryOutlinedBorderHover: Color,
    val buttonSecondaryOutlinedHoverText: Color,
    val buttonSecondaryOutlinedHoverIcon: Color,
    val buttonSecondaryOutlinedFillFocused: Color,
    val buttonSecondaryOutlinedBorderFocused: Color,
    val buttonSecondaryOutlinedFocusedText: Color,
    val buttonSecondaryOutlinedFocusedIcon: Color,
    val buttonDestructiveDefault: Color,
    val buttonDestructiveDefaultText: Color,
    val buttonDestructiveDefaultIcon: Color,
    val buttonDestructiveDisabled: Color,
    val buttonDestructiveDisabledText: Color,
    val buttonDestructiveDisabledIcon: Color,
    val buttonDestructiveHover: Color,
    val buttonDestructiveHoverText: Color,
    val buttonDestructiveHoverIcon: Color,
    val buttonDestructiveFocused: Color,
    val buttonDestructiveFocusedText: Color,
    val buttonDestructiveFocusedIcon: Color,
    val buttonDestructiveFocusedBorder: Color,
    val buttonSuccessDefault: Color,
    val buttonSuccessDefaultText: Color,
    val buttonSuccessDefaultIcon: Color,
    val buttonSuccessDisabled: Color,
    val buttonSuccessDisabledText: Color,
    val buttonSuccessDisabledIcon: Color,
    val buttonSuccessHover: Color,
    val buttonSuccessHoverText: Color,
    val buttonSuccessHoverIcon: Color,
    val buttonSuccessFocused: Color,
    val buttonSuccessFocusedText: Color,
    val buttonSuccessFocusedIcon: Color,
    val buttonSuccessFocusedBorder: Color,
)

@Immutable
data class FabColors(
    val fabContainerColor: Color,
    val fabTextColor: Color,
    val fabIconColor: Color,
    val fabHoverColor: Color,
)

@Immutable
data class CheckboxColors(
    val checkboxActive: Color,
    val checkboxInactive: Color,
    val checkboxInactiveHover: Color,
    val checkboxActiveHover: Color,
    val checkboxDisabled: Color,
)

@Immutable
data class InputColors(
    val cursorColor: Color,
    val inputTextActive: Color,
    val inputTextDisabled: Color,
    val inputTextPlaceholder: Color,
    val inputContainerSuccess: Color,
    val inputContainerError: Color,
    val inputContainerFocused: Color,
    val inputContainerOutline: Color,
)

@Immutable
data class LabelColors(
    val labelText: Color,
    val labelTextFocused: Color,
    val labelTextDisabled: Color,
    val labelBgColorDefault: Color,
    val labelBgColorPrimaryContainer: Color,
    val labelTextError: Color,
    val labelTextSuccess: Color,
)

@Immutable
data class IconColors(
    val leadingIcon: Color,
    val leadingIconFocused: Color,
    val leadingIconDisabled: Color,
    val leadingIconError: Color,
    val leadingIconSuccess: Color,
    val leadingIconPlaceholder: Color,
    val trailingIcon: Color,
    val trailingIconFocused: Color,
    val trailingIconError: Color,
    val trailingIconSuccess: Color,
    val trailingIconDisabled: Color,
    val trailingIconSecondary: Color,
    val trailingIconPlaceholder: Color,
)

@Immutable
data class SupportingTextColors(
    val supportingText: Color,
    val supportingTextError: Color,
    val supportingTextSuccess: Color,
    val supportingTextDisabled: Color,

    )

@Immutable
data class NavigationBarColors(
    val navContainerColor: Color,
    val navTextColor: Color,
    val navActiveIndicator: Color,
    val navIconActive: Color,
    val navIconInactive: Color,
    val navPremiumIconActive: Color,
    val navDividerColor: Color,
    )

@Immutable
data class RadioButtonColors(
    val radioActive: Color,
    val radioInactiveHover: Color,
    val radioActiveHover: Color,
    val radioDisabled: Color,
    val radioInactive: Color,

    )

@Immutable
data class SegmentedButtonColors(
    val segmentedActive: Color,
    val segmentedActiveOutline: Color,
    val segmentedInactiveContainer: Color,
    val segmentedInactiveOutline: Color,
    val segmentedActiveText: Color,
    val segmentedActiveIcon: Color,
    val segmentedInactiveIcon: Color,
    val segmentedInactiveText: Color,
    val segmentedBg: Color,

    )

@Immutable
data class SliderColors(
    val sliderValueContainerBg: Color,
    val sliderValueText: Color,
    val sliderHandleContainerBg: Color,
    val sliderHandle: Color,
    val sliderInactiveTrack: Color,
    val sliderActiveTrack: Color,
    val sliderStopIndicatorInactive: Color,
    val sliderDisabledTrack: Color,
    val sliderHandleDisabled: Color,
    val sliderHandleDisabledContainer: Color,
    val sliderStopIndicatorActive: Color,
    val sliderStopIndicatorDisabled: Color,
    )

@Immutable
data class SnackbarColors(
    val snackbarBgDefault: Color,
    val snackbarText: Color,
    val snackbarPrimaryCta: Color,
)

@Immutable
data class TabsColors(
    val secondaryTabActiveText: Color,
    val secondaryTabInactiveText: Color,
    val secondaryTabIndicator: Color,
    val secondaryTabDivider: Color,
    val secondaryTabBgColor: Color,
    val secondaryTabHover: Color,

    )

@Immutable
data class TooltipColors(
    val tooltipBgDefault: Color,
    val tooltipBgGrey: Color,
    val tooltipPrimaryText: Color,
    val tooltipSubtext: Color,
    val tooltipPrimaryCta: Color,
    val tooltipSecondaryCta: Color,

    )

@Immutable
data class SelectionColors(
    val selectionActive: Color,
    val selectionInactive: Color,
    val selectionText: Color,
    val selectionOutlineActive: Color,
    val selectionSubtext: Color,
    val selectionProgressBarBg: Color,
    val selectionProgressIndicator: Color,
    val selectionDisabledText: Color,
    val selectionDisabled: Color,
    val selectionGoldActive: Color,
    val selectionGoldOutlineActive: Color,
    val selectionOutlineInactive: Color,
    val selectionTextGold: Color,
    )

@Immutable
data class MaterialColors(
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val inversePrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val secondaryContainer: Color,
    val onSecondaryContainer: Color,
    val tertiary: Color,
    val onTertiary: Color,
    val tertiaryContainer: Color,
    val onTertiaryContainer: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val surfaceVariant: Color,
    val onSurfaceVariant: Color,
    val surfaceTint: Color,
    val inverseSurface: Color,
    val inverseOnSurface: Color,
    val error: Color,
    val onError: Color,
    val errorContainer: Color,
    val onErrorContainer: Color,
    val outline: Color,
    val outlineVariant: Color,
    val scrim: Color,
)