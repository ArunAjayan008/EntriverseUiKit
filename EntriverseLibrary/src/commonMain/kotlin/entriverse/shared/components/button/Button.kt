package entriverse.shared.components.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import entriverse.shared.Entriverse
import entriverse.shared.components.EvText
import entriverse.shared.components.button.ButtonColors.buttonStyleModifier
import entriverse.shared.components.button.ButtonColors.calcButtonTextColor
import entriverse.shared.theme.utils.CustomRippleTheme

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

    var buttonState by remember { mutableStateOf(ButtonState.DEFAULT) }
    val interactionSource = remember { MutableInteractionSource() }
    val buttonTextColor = calcButtonTextColor(type)

    CompositionLocalProvider(LocalRippleTheme provides CustomRippleTheme) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(120.dp))
                .wrapContentWidth()
                .layoutId("background")
                .clickable(
                    indication = rememberRipple(),
                    interactionSource = remember { interactionSource },
                    enabled = true,
                    onClick = onClick
                )
//                .pointerInput(Unit) {
//                    detectTapGestures(
//                        onPress = { offset ->
//                            val press = PressInteraction.Press(offset)
//                            interactionSource.emit(press)
//                            buttonState = ButtonState.PRESSED
//                            onClick()
//                            try {
//                                println("Arun button pressed")
//                                awaitRelease()
//                                interactionSource.emit(PressInteraction.Release(press))
//                                buttonState = ButtonState.DEFAULT
//                            } catch (e: Exception) {
//                                println("Arun exception")
//                                buttonState = ButtonState.DEFAULT
//                            }
//                        },
//                    )
//                }
                .buttonStyleModifier(type, modifier, state = buttonState)
        ) {
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
                    color = buttonTextColor,
                    style = Entriverse.typography.buttonText,
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
}


enum class ButtonIconPosition { START, END, }
enum class ButtonType { FILLED, TONAL, OUTLINED, SECONDARY_OUTLINED, DESTRUCTIVE, SUCCESS }
enum class ButtonSize { REGULAR, SMALL, EXTRA_SMALL }
enum class ButtonState { PRESSED, DISABLED, DEFAULT }

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