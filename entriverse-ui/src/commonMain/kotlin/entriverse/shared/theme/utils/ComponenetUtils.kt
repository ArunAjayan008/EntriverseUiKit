package entriverse.shared.theme.utils

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object CustomRippleTheme : RippleTheme {
    private var customRippleColor: Color = Color.Gray

    fun setRippleColor(color: Color) {
        println("arunentri $color")
        customRippleColor = color
    }

    @Composable
    override fun defaultColor() = customRippleColor

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(
        pressedAlpha = 0.5f,
        draggedAlpha = 0.0f,
        focusedAlpha = 0.0f,
        hoveredAlpha = 0.0f
    )
}
