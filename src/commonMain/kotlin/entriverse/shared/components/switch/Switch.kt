package entriverse.shared.components.switch

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.vector.ImageVector
import entriverse.shared.theme.Entriverse

/**
 * Switch component based on Figma spec:
 * - Size: Regular (52x32), Small (40x24)
 * - State: Inactive, Active, Pressed, Disabled
 * - Icon: Optional (Check or Clear)
 * - Colors and border radius as per Figma
 */

enum class SwitchSize(val width: Dp, val height: Dp, val knob: Dp, val iconSize: Dp) {
    Regular(width = 52.dp, height = 32.dp, knob = 24.dp, iconSize = 16.dp),
    Small(width = 40.dp, height = 24.dp, knob = 20.dp, iconSize = 12.dp)
}

enum class SwitchState {
    Inactive, Active, PressedInactive, PressedActive, DisabledInactive, DisabledActive
}

data class SwitchVisuals(
    val trackColor: Color,
    val knobColor: Color,
    val borderColor: Color,
    val icon: ImageVector?
)

@Composable
fun EvSwitch(
    props: SwitchProps,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier
) {
    val state = props.visualState
    val size = props.size
    val hasIcon = props.hasIcon
    val enabled = props.enabled
    val checked = props.checked

    val visuals = when (state) {
        SwitchVisualState.Inactive ->
            SwitchVisuals(
                trackColor = Entriverse.colors.referenceColors.blueContainer,
                knobColor = Entriverse.colors.referenceColors.subtext,
                borderColor = Entriverse.colors.referenceColors.subtext,
                icon = null
            )
        SwitchVisualState.Active ->
            SwitchVisuals(
                trackColor = Entriverse.colors.referenceColors.entriBlue,
                knobColor = Entriverse.colors.referenceColors.fixedWhite,
                borderColor = Entriverse.colors.referenceColors.entriBlue,
                icon = Icons.Filled.Check
            )
        SwitchVisualState.PressedInactive ->
            SwitchVisuals(
                trackColor = Entriverse.colors.referenceColors.blueContainer,
                knobColor = Entriverse.palette.grey100, // #4A4A4A
                borderColor = Entriverse.colors.referenceColors.subtext,
                icon = null
            )
        SwitchVisualState.PressedActive ->
            SwitchVisuals(
                trackColor = Entriverse.colors.referenceColors.onBlueContainer,
                knobColor = Entriverse.colors.referenceColors.fixedWhite,
                borderColor = Entriverse.colors.referenceColors.onBlueContainer,
                icon = Icons.Filled.Check
            )
        SwitchVisualState.DisabledInactive ->
            SwitchVisuals(
                trackColor = Entriverse.colors.referenceColors.disabledText,
                knobColor = Entriverse.colors.referenceColors.timestampText,
                borderColor = Entriverse.colors.referenceColors.disabledText,
                icon = null
            )
        SwitchVisualState.DisabledActive ->
            SwitchVisuals(
                trackColor = Entriverse.colors.referenceColors.blueContainer,
                knobColor = Entriverse.colors.referenceColors.fixedWhite,
                borderColor = Entriverse.colors.referenceColors.blueContainer,
                icon = Icons.Filled.Check
            )
    }

    val (trackColor, knobColor, borderColor, icon) = visuals

    Box(
        modifier = modifier
            .width(size.width)
            .height(size.height)
            .clip(CircleShape)
            .background(trackColor)
            .clickable(enabled = enabled, onClick = { onCheckedChange?.invoke(!checked) })
            .padding(horizontal = if (size == SwitchSize.Regular) 4.dp else 2.dp),
        contentAlignment = if (checked) Alignment.CenterEnd else Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .size(size.knob)
                .clip(CircleShape)
                .background(knobColor),
            contentAlignment = Alignment.Center
        ) {
            if (hasIcon && icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = if (checked) Entriverse.colors.referenceColors.entriBlue else Entriverse.colors.referenceColors.subtext,
                    modifier = Modifier.size(size.iconSize)
                )
            }
        }
    }
} 