package entriverse.shared.components.button

import androidx.compose.runtime.Composable
import entriverse.shared.Entriverse


internal object ButtonColors {
    @Composable
    fun calcButtonColor(type: ButtonType) = when (type) {
        ButtonType.FILLED -> Entriverse.colors.referenceColors.onBlue
        ButtonType.TONAL -> Entriverse.colors.referenceColors.onBlueContainer
        ButtonType.OUTLINED -> Entriverse.palette.transparentColor
        ButtonType.SECONDARY_OUTLINED -> Entriverse.colors.referenceColors.primaryText
        ButtonType.DESTRUCTIVE -> Entriverse.colors.referenceColors.errorColor
        ButtonType.SUCCESS -> Entriverse.colors.referenceColors.successColor
    }

    @Composable
    fun calcButtonTextColor(type: ButtonType) = when (type) {
        ButtonType.FILLED -> Entriverse.colors.referenceColors.onBlueContainer
        ButtonType.TONAL -> Entriverse.colors.referenceColors.onBlue
        ButtonType.OUTLINED -> Entriverse.colors.referenceColors.onBlue
        ButtonType.SECONDARY_OUTLINED -> Entriverse.colors.referenceColors.invertedText
        ButtonType.DESTRUCTIVE -> Entriverse.colors.referenceColors.fixedWhite
        ButtonType.SUCCESS -> Entriverse.colors.referenceColors.fixedWhite
    }

    @Composable
    fun rippleColor(type: ButtonType) = when (type) {
        ButtonType.FILLED -> Entriverse.colors.referenceColors.blueHover
        ButtonType.TONAL -> Entriverse.colors.referenceColors.onBlueContainer
        ButtonType.OUTLINED -> Entriverse.colors.referenceColors.blueOutline
        ButtonType.SECONDARY_OUTLINED -> Entriverse.colors.referenceColors.secondaryContainer
        ButtonType.DESTRUCTIVE -> Entriverse.colors.referenceColors.errorHover
        ButtonType.SUCCESS -> Entriverse.colors.referenceColors.successHover
    }
}