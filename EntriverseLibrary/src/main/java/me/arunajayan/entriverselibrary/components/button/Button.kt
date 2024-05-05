package me.arunajayan.entriverselibrary.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.arunajayan.entriverselibrary.Entriverse
import me.arunajayan.entriverselibrary.R
import me.arunajayan.entriverselibrary.components.EntriverseText

@Composable
fun EntriverseButton(
    onClick: () -> Unit,
    label: String,
    disabled: Boolean = false,
    type: ButtonType,
    size: ButtonSize,
    icon: Int? = null,
    iconPosition: ButtonIconPosition? = null
) {
    val paddings = remember { ButtonProperties() }
    paddings.CalcButtonProperties(
        hasStartIcon = !(icon == 0 || iconPosition != ButtonIconPosition.START),
        hasEndIcon = !(icon == 0 || iconPosition != ButtonIconPosition.END),
        size = size
    )
    val backgroundColor = calcButtonColor(type = type)
    val buttonStyleModifier = ButtonStyleModifier(type)
    val buttonSizeModifier = calcButtonSize(size = size)
    val buttonTextColor=calcButtonTextColor(type)
    Box(
        modifier = buttonStyleModifier
            .wrapContentWidth()
            .layoutId("background")
            .background(color = backgroundColor, shape = RoundedCornerShape(120.dp))
            .clickable(
                onClick = onClick,
                enabled = !disabled,
                role = Role.Button
            ),
    ) {
        Row(
            modifier = buttonSizeModifier
                .padding(vertical = paddings.verticalPadding)
                .padding(
                    start = paddings.startPadding,
                    end = paddings.endPadding
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (icon != null && iconPosition == ButtonIconPosition.START) {
                Icon(
                    painter = painterResource(id = icon),
                    modifier = Modifier.size(paddings.iconSize),
                    contentDescription = "Button Icon",
                    tint = buttonTextColor
                )
            }

            if (iconPosition == ButtonIconPosition.START) {
                Spacer(modifier = Modifier.width(paddings.textIconSpacerWidth))
            }

            EntriverseText(
                text = label,
                modifier = if(size==ButtonSize.REGULAR)
                        Modifier.weight(1f) else Modifier,
                color = buttonTextColor,
                style = Entriverse.typography.buttonBold,
                textAlign = TextAlign.Center
            )

            if (iconPosition == ButtonIconPosition.END) {
                Spacer(modifier = Modifier.width(paddings.textIconSpacerWidth))
            }

            if (icon != null && iconPosition == ButtonIconPosition.END) {
                Icon(
                    painter = painterResource(id = icon),
                    modifier = Modifier.size(paddings.iconSize),
                    contentDescription = "Button Icon",
                    tint = buttonTextColor
                )
            }

        }
    }
}

@Composable
fun ButtonStyleModifier(type: ButtonType): Modifier {
    return if(type==ButtonType.OUTLINED){
        Modifier.border(1.5.dp, Entriverse.colors.referenceColors.onBlueContainer, RoundedCornerShape(120.dp))
    }
     else Modifier
}

@Composable
fun calcButtonColor(type: ButtonType) = when (type) {
    ButtonType.FILLED -> Entriverse.colors.referenceColors.blueContainer
    ButtonType.TONAL -> Entriverse.colors.referenceColors.onBlueContainer
    ButtonType.OUTLINED -> Entriverse.palette.transparentColor
    ButtonType.SECONDARY_OUTLINED -> Entriverse.colors.referenceColors.primaryText
    ButtonType.DESTRUCTIVE -> Entriverse.colors.referenceColors.primaryText
    ButtonType.SUCCESS -> Entriverse.colors.referenceColors.primaryText
}

@Composable
fun calcButtonTextColor(type: ButtonType) = when (type) {
    ButtonType.FILLED -> Entriverse.colors.referenceColors.fixedWhite
    ButtonType.TONAL -> Entriverse.colors.referenceColors.onBlueContainer
    ButtonType.OUTLINED -> Entriverse.colors.referenceColors.onBlueContainer
    ButtonType.SECONDARY_OUTLINED -> Entriverse.colors.referenceColors.invertedText
    ButtonType.DESTRUCTIVE -> Entriverse.colors.referenceColors.fixedWhite
    ButtonType.SUCCESS -> Entriverse.colors.referenceColors.fixedWhite
}

@Composable
fun calcButtonSize(size: ButtonSize) = when (size) {
    ButtonSize.REGULAR -> Modifier.fillMaxWidth()
    ButtonSize.SMALL -> Modifier.wrapContentWidth()
    ButtonSize.EXTRA_SMALL -> Modifier.wrapContentWidth()
}

enum class ButtonIconPosition { START, END, }
enum class ButtonType { FILLED, TONAL, OUTLINED, SECONDARY_OUTLINED, DESTRUCTIVE, SUCCESS }
enum class ButtonSize { REGULAR, SMALL, EXTRA_SMALL }

@Preview(showSystemUi = true)
@Composable
private fun Test() {
    EntriverseButton(
        onClick = {},
        disabled = false,
        label = "Button Text",
        type = ButtonType.FILLED,
        size = ButtonSize.SMALL,
        icon = R.drawable.button_icon,
        iconPosition = ButtonIconPosition.START
    )
}