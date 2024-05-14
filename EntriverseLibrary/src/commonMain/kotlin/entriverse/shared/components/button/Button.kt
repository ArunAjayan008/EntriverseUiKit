package entriverse.shared.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import entriverse.shared.components.EntriverseText
import entriverse.shared.components.button.ButtonColors.calcButtonColor
import entriverse.shared.components.button.ButtonColors.calcButtonTextColor
import entriverse.shared.components.button.ButtonColors.rippleColor
import me.arunajayan.entriverselibrary.R

@Composable
fun EntriverseButton(
    modifier: Modifier,
    onClick: () -> Unit,
    label: String,
    disabled: Boolean = false,
    type: ButtonType,
    size: ButtonSize,
    icon: Int? = null,
    iconPosition: ButtonIconPosition? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    ) {
    val paddings = remember { ButtonProperties() }
    paddings.FetchButtonProperties(
        hasStartIcon = !(icon == 0 || iconPosition != ButtonIconPosition.START),
        hasEndIcon = !(icon == 0 || iconPosition != ButtonIconPosition.END),
        size = size
    )
    val backgroundColor = calcButtonColor(type = type)
    val buttonStyleModifier = buttonStyleModifier(type,modifier)
    val buttonSizeModifier = calcButtonSize(size = size)
    val buttonTextColor=calcButtonTextColor(type)
    val rippleColor = rippleColor(type)
    Box(
        modifier = buttonStyleModifier
            .wrapContentWidth()
            .layoutId("background")
            .background(color = backgroundColor, shape = RoundedCornerShape(120.dp))
            .clip(shape = RoundedCornerShape(120.dp))
            .clickable(
                onClick = onClick,
                enabled = !disabled,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = rememberRipple(color = rippleColor)
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
                style = entriverse.shared.Entriverse.typography.buttonBold,
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


enum class ButtonIconPosition { START, END, }
enum class ButtonType { FILLED, TONAL, OUTLINED, SECONDARY_OUTLINED, DESTRUCTIVE, SUCCESS }
enum class ButtonSize { REGULAR, SMALL, EXTRA_SMALL }

@Preview(showSystemUi = true)
@Composable
private fun Test() {
    EntriverseButton(
        modifier = Modifier,
        onClick = {},
        disabled = false,
        label = "Button Text",
        type = ButtonType.SECONDARY_OUTLINED,
        size = ButtonSize.REGULAR,
        icon = R.drawable.button_icon,
        iconPosition = ButtonIconPosition.START
    )
}