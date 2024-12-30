package entriverse.shared.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import entriverse.shared.Entriverse
import entriverse.shared.Entriverse.entriverseDimens

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
        val spacingDimens = entriverseDimens.referenceDimens
        val fontDimens = entriverseDimens.fontDimens
        val sizeDimens = entriverseDimens.sizeDimens
        when (size) {
            ButtonSize.SMALL -> {
                startPadding = if (hasStartIcon) {
                    spacingDimens.spacingM
                } else {
                    spacingDimens.spacingXl
                }
                endPadding = if (hasEndIcon) {
                    spacingDimens.spacingM
                } else {
                    spacingDimens.spacingXl
                }
                textIconSpacerWidth = spacingDimens.spacingM
                verticalPadding = spacingDimens.spacingM
                buttonTextSize = fontDimens.fontSize400
                iconSize = sizeDimens.dimen20dp
            }

            ButtonSize.REGULAR -> {
                startPadding = if (hasStartIcon) {
                    spacingDimens.spacingXl
                } else {
                    spacingDimens.spacingXxxl
                }
                endPadding = if (hasEndIcon) {
                    spacingDimens.spacingXl
                } else {
                    spacingDimens.spacingXxxl
                }
                textIconSpacerWidth = spacingDimens.spacingXs
                verticalPadding = spacingDimens.spacingL
                buttonTextSize = fontDimens.fontSize400
                iconSize = sizeDimens.dimen24dp
            }

            ButtonSize.EXTRA_SMALL -> {
                startPadding = if (hasStartIcon) {
                    spacingDimens.spacingM
                } else {
                    spacingDimens.spacingXl
                }
                endPadding = if (hasEndIcon) {
                    spacingDimens.spacingM
                } else {
                    spacingDimens.spacingXl
                }
                textIconSpacerWidth = spacingDimens.spacingM
                verticalPadding = spacingDimens.spacingM
                buttonTextSize = fontDimens.fontSize400
                iconSize = sizeDimens.dimen16dp
            }
        }
    }
}

@Composable
fun Modifier.calcButtonSize(size: ButtonSize) =
    this.then(
        when (size) {
            ButtonSize.REGULAR -> Modifier.fillMaxWidth()
            ButtonSize.SMALL -> Modifier.wrapContentWidth()
            ButtonSize.EXTRA_SMALL -> Modifier.wrapContentWidth()
        }
    )
