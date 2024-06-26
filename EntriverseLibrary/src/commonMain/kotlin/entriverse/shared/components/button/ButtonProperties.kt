package entriverse.shared.components.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun Modifier.calcButtonSize(size: ButtonSize) =
    this.then(
        when (size) {
            ButtonSize.REGULAR -> Modifier.fillMaxWidth()
            ButtonSize.SMALL -> Modifier.wrapContentWidth()
            ButtonSize.EXTRA_SMALL -> Modifier.wrapContentWidth()
        }
    )


@Immutable
object RedRipple : RippleTheme {
    @Composable
    override fun defaultColor() = Entriverse.palette.red900

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(1f, 1f, 1f, 1f)
}