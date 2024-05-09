package me.arunajayan.entriverselibrary.components.button

import androidx.compose.runtime.Composable
import me.arunajayan.entriverselibrary.Entriverse

internal object ButtonColors {
    @Composable
    fun calcButtonColor(type: ButtonType) = when (type) {
        ButtonType.FILLED -> Entriverse.colors.referenceColors.blueContainer
        ButtonType.TONAL -> Entriverse.colors.referenceColors.onBlueContainer
        ButtonType.OUTLINED -> Entriverse.palette.transparentColor
        ButtonType.SECONDARY_OUTLINED -> Entriverse.colors.referenceColors.primaryText
        ButtonType.DESTRUCTIVE -> Entriverse.palette.red700
        ButtonType.SUCCESS -> Entriverse.palette.grey700
    }

    @Composable
    fun calcButtonTextColor(type: ButtonType) = when (type) {
        ButtonType.FILLED -> Entriverse.colors.referenceColors.onBlueContainer
        ButtonType.TONAL -> Entriverse.colors.referenceColors.onBlueContainer
        ButtonType.OUTLINED -> Entriverse.colors.referenceColors.onBlueContainer
        ButtonType.SECONDARY_OUTLINED -> Entriverse.colors.referenceColors.invertedText
        ButtonType.DESTRUCTIVE -> Entriverse.colors.referenceColors.fixedWhite
        ButtonType.SUCCESS -> Entriverse.colors.referenceColors.fixedWhite
    }

    @Composable
    fun rippleColor(type: ButtonType) = when (type) {
        ButtonType.FILLED -> Entriverse.colors.referenceColors.blueHover
        ButtonType.TONAL -> Entriverse.palette.blue300
        ButtonType.OUTLINED -> Entriverse.palette.blue50
        ButtonType.SECONDARY_OUTLINED -> Entriverse.colors.referenceColors.secondaryContainer
        ButtonType.DESTRUCTIVE -> Entriverse.palette.red900
        ButtonType.SUCCESS -> Entriverse.palette.green900
    }
}