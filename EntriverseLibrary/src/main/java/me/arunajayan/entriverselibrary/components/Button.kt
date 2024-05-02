package me.arunajayan.entriverselibrary.components

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.arunajayan.entriverselibrary.Entriverse
import me.arunajayan.entriverselibrary.theme.colors.EntriverseColors

@Composable
public fun EntriverseButton(
    onClick: () -> Unit,
    label: String,
    disabled: Boolean = false,
    fillMaxWidth: Boolean = false,
    type: ButtonType
) {

    val backgroundColor = buttonColorCalc(type = type)
    Box(
        modifier = Modifier
            .layoutId("background")
            .fillMaxWidth(
                if (fillMaxWidth) {
                    0.0f
                } else {
                    1f
                }
            )
            .background(color = backgroundColor, shape = RoundedCornerShape(120.dp))
            .clickable(
                onClick = onClick,
                enabled = !disabled,
                role = Role.Button
            )
    ) {
        Column(
            modifier = Modifier
                .padding(
                    vertical = Entriverse.entriverseDimens.referenceDimens.spacingL,
                    horizontal = Entriverse.entriverseDimens.referenceDimens.spacingXl
                )
                .fillMaxWidth()
        ) {
            EntriverseText(
                text = label,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Entriverse.colors.referenceColors.defaultIcon
            )
        }
    }
}

@Composable
fun buttonColorCalc(type: ButtonType) = when (type) {
    ButtonType.FILLED -> Entriverse.colors.referenceColors.blueContainer
    ButtonType.TONAL -> Entriverse.colors.referenceColors.primaryText
    ButtonType.OUTLINED -> Entriverse.colors.referenceColors.primaryText
    ButtonType.SECONDARY_OUTLINED -> Entriverse.colors.referenceColors.primaryText
    ButtonType.DESTRUCTIVE -> Entriverse.colors.referenceColors.primaryText
    ButtonType.SUCCESS -> Entriverse.colors.referenceColors.primaryText
}

public enum class ButtonType { FILLED, TONAL, OUTLINED, SECONDARY_OUTLINED, DESTRUCTIVE, SUCCESS }

@Preview(showSystemUi = true)
@Composable
private fun Test() {
    EntriverseButton(
        onClick = {}, disabled = false, fillMaxWidth = false,
        label = "Button Text", type = ButtonType.FILLED
    )
}