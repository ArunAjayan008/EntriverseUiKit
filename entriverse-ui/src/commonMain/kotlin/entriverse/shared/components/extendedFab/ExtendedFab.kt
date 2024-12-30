package entriverse.shared.components.extendedFab

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import entriverse.shared.Entriverse
import entriverse.shared.Entriverse.colors
import entriverse.shared.components.EvText
import me.entri.entriverseui.R

@Composable
fun EvExtendedFAB(
    modifier: Modifier,
    onClick: () -> Unit,
    label: String,
    expanded: Boolean = true,
    icon: Int,
) {
    val buttonColors = colors.componentColors.fabColors
    ExtendedFloatingActionButton(
        modifier = modifier,
        expanded = expanded,
        icon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Floating action button",
                tint = buttonColors.fabIconColor,
                modifier = Modifier.size(Entriverse.entriverseDimens.referenceDimens.spacingXl)
            )
        },
        text = {
            EvText(
                text = label,
                color = buttonColors.fabTextColor,
                style = Entriverse.typography.buttonText,
                textAlign = TextAlign.Center
            )
        },
        onClick = onClick,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = Entriverse.entriverseDimens.referenceDimens.spacingXl,
            pressedElevation = Entriverse.entriverseDimens.referenceDimens.spacingXxl,
            hoveredElevation = Entriverse.entriverseDimens.referenceDimens.spacingXl
        ),
        containerColor = buttonColors.fabContainerColor,
        interactionSource = remember { MutableInteractionSource() },
    )
}


@Preview(showSystemUi = true)
@Composable
private fun Test() {
    Column(modifier = Modifier.fillMaxSize()) {
        EvExtendedFAB(
            modifier = Modifier,
            onClick = {},
            label = "Ask Eva",
            expanded = true,
            icon = R.drawable.ev_button_icon
        )
    }
}