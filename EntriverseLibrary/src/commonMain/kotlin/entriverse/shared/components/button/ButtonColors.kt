package entriverse.shared.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import entriverse.shared.Entriverse


internal object ButtonColors {
    @Composable
    fun Modifier.buttonStyleModifier(buttonType: ButtonType, modifier: Modifier, state: ButtonState): Modifier =
        this.then(when (state) {
            ButtonState.PRESSED -> {
                when (buttonType) {
                    ButtonType.FILLED -> {
                        modifier
                            .border(
                                width = 4.dp,
                                color = Entriverse.colors.referenceColors.onBlueContainer,
                                shape = RoundedCornerShape(120.dp)
                            )
                            .background(Entriverse.colors.referenceColors.onBlue)
                    }

                    ButtonType.TONAL -> {
                        modifier
                            .border(
                                width = 4.dp,
                                color = Entriverse.colors.referenceColors.onBlueContainer,
                                shape = RoundedCornerShape(120.dp)
                            )
                            .background(Entriverse.palette.blue100)
                    }

                    ButtonType.OUTLINED -> {
                        modifier
                            .border(
                                width = 4.dp,
                                color = Entriverse.colors.referenceColors.onBlueContainer,
                                shape = RoundedCornerShape(120.dp)
                            )
                            .background(Entriverse.palette.blue300)
                    }

                    ButtonType.SECONDARY_OUTLINED -> {
                        modifier
                            .border(
                                width = 4.dp,
                                color = Entriverse.colors.referenceColors.onBlueContainer,
                                shape = RoundedCornerShape(120.dp)
                            )
                            .background(Entriverse.colors.referenceColors.secondaryIcon)
                    }

                    ButtonType.DESTRUCTIVE -> {
                        modifier
                            .border(
                                width = 4.dp,
                                color = Entriverse.colors.referenceColors.errorColor,
                                shape = RoundedCornerShape(120.dp)
                            )
                            .background(Entriverse.colors.referenceColors.errorHover)
                    }

                    ButtonType.SUCCESS -> {
                        modifier
                            .border(
                                width = 4.dp,
                                color = Entriverse.colors.referenceColors.successColor,
                                shape = RoundedCornerShape(120.dp)
                            )
                            .background(Entriverse.colors.referenceColors.errorHover)
                    }
                }
            }

            ButtonState.DISABLED -> {
                when (buttonType) {
                    ButtonType.FILLED -> {
                        modifier.background(Entriverse.colors.referenceColors.disabledIcon)
                    }

                    ButtonType.TONAL -> {
                        modifier.background(Entriverse.colors.referenceColors.disabledIcon)
                    }

                    ButtonType.OUTLINED -> {
                        modifier
                            .border(
                                width = 1.5.dp,
                                color = Entriverse.colors.referenceColors.onBlue,
                                shape = RoundedCornerShape(120.dp)
                            )
                            .background(Entriverse.colors.referenceColors.disabledText)
                    }

                    ButtonType.SECONDARY_OUTLINED -> {
                        modifier
                            .border(
                                width = 1.5.dp,
                                color = Entriverse.colors.referenceColors.onBlue,
                                shape = RoundedCornerShape(120.dp)
                            )
                            .background(Entriverse.colors.referenceColors.disabledText)
                    }

                    ButtonType.DESTRUCTIVE -> {
                        modifier.background(Entriverse.colors.referenceColors.disabledIcon)
                    }
                    ButtonType.SUCCESS -> {
                        modifier.background(Entriverse.colors.referenceColors.disabledIcon)
                    }
                }
            }

            ButtonState.DEFAULT -> {
                when (buttonType) {
                    ButtonType.FILLED -> {
                        modifier.background(Entriverse.colors.referenceColors.onBlue)
                    }

                    ButtonType.TONAL -> {
                        modifier.background(Entriverse.colors.referenceColors.onBlueContainer)
                    }

                    ButtonType.OUTLINED -> {
                        modifier
                            .border(
                                width = 1.5.dp,
                                color = Entriverse.colors.referenceColors.onBlue,
                                shape = RoundedCornerShape(120.dp)
                            )
                            .background(Entriverse.palette.transparentColor)
                    }

                    ButtonType.SECONDARY_OUTLINED -> {
                        modifier
                            .border(
                                width = 1.5.dp,
                                color = Entriverse.colors.referenceColors.onBlue,
                                shape = RoundedCornerShape(120.dp)
                            )
                            .background(Entriverse.colors.referenceColors.primaryText)
                    }

                    ButtonType.DESTRUCTIVE -> {
                        modifier.background(Entriverse.colors.referenceColors.errorColor)
                    }

                    ButtonType.SUCCESS -> {
                        modifier.background(Entriverse.colors.referenceColors.successColor)
                    }
                }
            }
        })

    @Composable
    fun calcButtonTextColor(type: ButtonType) = when (type) {
        ButtonType.FILLED -> Entriverse.colors.referenceColors.onBlueContainer
        ButtonType.TONAL -> Entriverse.colors.referenceColors.onBlue
        ButtonType.OUTLINED -> Entriverse.colors.referenceColors.onBlue
        ButtonType.SECONDARY_OUTLINED -> Entriverse.colors.referenceColors.invertedText
        ButtonType.DESTRUCTIVE -> Entriverse.colors.referenceColors.fixedWhite
        ButtonType.SUCCESS -> Entriverse.colors.referenceColors.fixedWhite
    }
}