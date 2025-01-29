package entriverse.shared.components.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import entriverse.shared.Entriverse
import entriverse.shared.components.EvText
import entriverse.shared.components.button.ButtonColors.buttonStyleModifier
import entriverse.shared.components.button.ButtonColors.calcButtonTextColor

@Composable
fun EvButton(
    modifier: Modifier,
    onClick: () -> Unit,
    label: String,
    disabled: Boolean = false,
    type: ButtonType,
    size: ButtonSize,
    icon: Int? = null,
    iconPosition: ButtonIconPosition? = null,
) {
    val paddings = remember { ButtonProperties() }
    paddings.FetchButtonProperties(
        hasStartIcon = !(icon == 0 || iconPosition != ButtonIconPosition.START),
        hasEndIcon = !(icon == 0 || iconPosition != ButtonIconPosition.END),
        size = size
    )

    val buttonState by remember { mutableStateOf(if (disabled) ButtonState.DISABLED else ButtonState.DEFAULT) }
    val buttonTextColor = calcButtonTextColor(type)
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(120.dp))
            .wrapContentWidth()
            .layoutId("background")) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .clickable(
                    enabled = true,
                    onClick = onClick
                )
                .buttonStyleModifier(
                    type,
                    modifier,
                    state = buttonState
                )
        )
        Row(
            modifier = Modifier
                .padding(vertical = paddings.verticalPadding)
                .padding(
                    start = paddings.startPadding,
                    end = paddings.endPadding
                )
                .calcButtonSize(size),
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

            EvText(
                text = label,
                modifier = if (size == ButtonSize.REGULAR)
                    Modifier.weight(1f) else Modifier,
                style = Entriverse.typography.buttonText,
                color = buttonTextColor,
                textAlign = TextAlign.Center,
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
enum class ButtonState { DISABLED, DEFAULT }

@Preview(showSystemUi = true)
@Composable
private fun Test() {
    Surface(modifier = Modifier.padding(10.dp)) {
        EvButton(
            modifier = Modifier,
            onClick = {},
            disabled = false,
            label = "Button Text",
            type = ButtonType.SUCCESS,
            size = ButtonSize.REGULAR,
        )
    }
}