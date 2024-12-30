package entriverse.shared.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import entriverse.shared.Entriverse.colors

internal object ButtonColors {
    @Composable
    fun Modifier.buttonStyleModifier(
        buttonType: ButtonType,
        modifier: Modifier,
        state: ButtonState,
    ): Modifier {
        val buttonColors = colors.componentColors.buttonColors
        return this.then(
            when (state) {
                ButtonState.PRESSED -> {
                    when (buttonType) {
                        ButtonType.FILLED -> {
                            modifier
                                .border(
                                    width = 4.dp,
                                    color = buttonColors.buttonFilledFocusedBorder,
                                    shape = RoundedCornerShape(120.dp)
                                )
                                .background(buttonColors.buttonFilledFocused)
                        }

                        ButtonType.TONAL -> {
                            modifier
                                .border(
                                    width = 4.dp,
                                    color = buttonColors.buttonTonalFocusedBorder,
                                    shape = RoundedCornerShape(120.dp)
                                )
                                .background(buttonColors.buttonTonalFocused)
                        }

                        ButtonType.OUTLINED -> {
                            modifier
                                .border(
                                    width = 4.dp,
                                    color = buttonColors.buttonOutlinedBorderFocused,
                                    shape = RoundedCornerShape(120.dp)
                                )
                                .background(buttonColors.buttonOutlinedFillFocused)

                        }

                        ButtonType.SECONDARY_OUTLINED -> {
                            modifier
                                .border(
                                    width = 4.dp,
                                    color = buttonColors.buttonSecondaryOutlinedBorderFocused,
                                    shape = RoundedCornerShape(120.dp)
                                )
                                .background(buttonColors.buttonSecondaryOutlinedFillFocused)
                        }

                        ButtonType.DESTRUCTIVE -> {
                            modifier
                                .border(
                                    width = 4.dp,
                                    color = buttonColors.buttonDestructiveFocusedBorder,
                                    shape = RoundedCornerShape(120.dp)
                                )
                                .background(buttonColors.buttonDestructiveFocused)
                        }

                        ButtonType.SUCCESS -> {
                            modifier
                                .border(
                                    width = 4.dp,
                                    color = buttonColors.buttonSuccessFocusedBorder,
                                    shape = RoundedCornerShape(120.dp)
                                )
                                .background(buttonColors.buttonSuccessFocused)
                        }
                    }
                }

                ButtonState.DISABLED -> {
                    when (buttonType) {
                        ButtonType.FILLED -> {
                            modifier.background(buttonColors.buttonFilledDisabled)
                        }

                        ButtonType.TONAL -> {
                            modifier.background(buttonColors.buttonTonalDisabled)
                        }

                        ButtonType.OUTLINED -> {
                            modifier
                                .border(
                                    width = 1.5.dp,
                                    color = buttonColors.buttonOutlinedBorderDisabled,
                                    shape = RoundedCornerShape(120.dp)
                                )
                        }

                        ButtonType.SECONDARY_OUTLINED -> {
                            modifier
                                .border(
                                    width = 1.5.dp,
                                    color = buttonColors.buttonSecondaryOutlinedBorderDisabled,
                                    shape = RoundedCornerShape(120.dp)
                                )
                        }

                        ButtonType.DESTRUCTIVE -> {
                            modifier.background(buttonColors.buttonDestructiveDisabled)
                        }

                        ButtonType.SUCCESS -> {
                            modifier.background(buttonColors.buttonSuccessDisabled)
                        }
                    }
                }

                ButtonState.DEFAULT -> {
                    when (buttonType) {
                        ButtonType.FILLED -> {
                            modifier.background(buttonColors.buttonFilledDefault)
                        }

                        ButtonType.TONAL -> {
                            modifier.background(buttonColors.buttonTonalDefault)
                        }

                        ButtonType.OUTLINED -> {
                            modifier
                                .border(
                                    width = 1.5.dp,
                                    color = buttonColors.buttonOutlinedBorderDefault,
                                    shape = RoundedCornerShape(120.dp)
                                )
                        }

                        ButtonType.SECONDARY_OUTLINED -> {
                            modifier
                                .border(
                                    width = 1.5.dp,
                                    color = buttonColors.buttonSecondaryOutlinedBorderDefault,
                                    shape = RoundedCornerShape(120.dp)
                                )
                        }

                        ButtonType.DESTRUCTIVE -> {
                            modifier.background(buttonColors.buttonDestructiveDefault)
                        }

                        ButtonType.SUCCESS -> {
                            modifier.background(buttonColors.buttonSuccessDefault)
                        }
                    }
                }
            }
        )
    }

    @Composable
    fun calcButtonTextColor(type: ButtonType): Color {
        val buttonColors = colors.componentColors.buttonColors
        return when (type) {
            ButtonType.FILLED -> buttonColors.buttonFilledDefaultText
            ButtonType.TONAL -> buttonColors.buttonTonalDefaultText
            ButtonType.OUTLINED -> buttonColors.buttonOutlinedDefaultText
            ButtonType.SECONDARY_OUTLINED -> buttonColors.buttonSecondaryOutlinedDefaultText
            ButtonType.DESTRUCTIVE -> buttonColors.buttonDestructiveDefaultText
            ButtonType.SUCCESS -> buttonColors.buttonSuccessDefaultText
        }
    }

    @Composable
    fun calcButtonRipple(type: ButtonType): Color {
        val buttonColors = colors.componentColors.buttonColors
        return when (type) {
            ButtonType.FILLED -> buttonColors.buttonFilledDefault
            ButtonType.TONAL -> buttonColors.buttonTonalDefault
            ButtonType.OUTLINED -> buttonColors.buttonOutlinedFillFocused
            ButtonType.SECONDARY_OUTLINED -> buttonColors.buttonSecondaryOutlinedFillFocused
            ButtonType.DESTRUCTIVE -> buttonColors.buttonDestructiveDefault
            ButtonType.SUCCESS -> buttonColors.buttonSuccessDefault
        }
    }

}