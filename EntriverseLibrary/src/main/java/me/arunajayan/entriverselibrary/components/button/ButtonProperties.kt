package me.arunajayan.entriverselibrary.components.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.arunajayan.entriverselibrary.Entriverse

internal class ButtonProperties {
    var startPadding by mutableStateOf(0.dp)
    var endPadding by mutableStateOf(0.dp)
    var textIconSpacerWidth by mutableStateOf(0.dp)
    var verticalPadding by mutableStateOf(0.dp)
    var buttonTextSize by mutableStateOf(0.sp)
    var iconSize by mutableStateOf(0.dp)

    @Composable
    fun FetchButtonProperties(
        hasStartIcon: Boolean,
        hasEndIcon: Boolean,
        size: ButtonSize
    ) {
        val dimens = Entriverse.entriverseDimens.referenceDimens
        when (size) {
            ButtonSize.SMALL -> {
                startPadding = if (hasStartIcon) {
                    dimens.spacingM
                } else {
                    dimens.spacingXl
                }
                endPadding = if (hasEndIcon) {
                    dimens.spacingM
                } else {
                    dimens.spacingXl
                }
                textIconSpacerWidth = dimens.spacingM
                verticalPadding = dimens.spacingM
                buttonTextSize = Entriverse.fontDimens.text14sp
                iconSize = dimens.spacingXxl
            }

            ButtonSize.REGULAR -> {
                startPadding = if (hasStartIcon) {
                    dimens.spacingXl
                } else {
                    dimens.spacingXxxl
                }
                endPadding = if (hasEndIcon) {
                    dimens.spacingXl
                } else {
                    dimens.spacingXxxl
                }
                textIconSpacerWidth = dimens.spacingXs
                verticalPadding = dimens.spacingL
                buttonTextSize = Entriverse.fontDimens.text14sp
                iconSize = dimens.spacingXxl
            }

            ButtonSize.EXTRA_SMALL -> {
                startPadding = if (hasStartIcon) {
                    dimens.spacingM
                } else {
                    dimens.spacingXl
                }
                endPadding = if (hasEndIcon) {
                    dimens.spacingM
                } else {
                    dimens.spacingXl
                }
                textIconSpacerWidth = dimens.spacingM
                verticalPadding = dimens.spacingM
                buttonTextSize = Entriverse.fontDimens.text14sp
                iconSize = dimens.spacingXl
            }
        }
    }
}


@Composable
fun calcButtonSize(size: ButtonSize) = when (size) {
    ButtonSize.REGULAR -> Modifier.fillMaxWidth()
    ButtonSize.SMALL -> Modifier.wrapContentWidth()
    ButtonSize.EXTRA_SMALL -> Modifier.wrapContentWidth()
}


@Composable
fun buttonStyleModifier(type: ButtonType,modifier: Modifier): Modifier {
    return if(type==ButtonType.OUTLINED){
        modifier.border(1.5.dp, Entriverse.colors.referenceColors.onBlue, RoundedCornerShape(120.dp))
    }else if(type==ButtonType.SECONDARY_OUTLINED){
        modifier.border(1.5.dp, Entriverse.colors.referenceColors.disabledText, RoundedCornerShape(120.dp))
    }
    else modifier
}