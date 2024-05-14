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
import entriverse.shared.components.EntriverseText
import me.arunajayan.entriverselibrary.R

@Composable
fun EntriverseExtendedFAB(
    modifier: Modifier,
    onClick: () -> Unit,
    label: String,
    expanded: Boolean = true,
    buttonColor: Color,
    textColor: Color,
    icon: Int,
) {

    /* Box(
         modifier = modifier
             .wrapContentWidth()
             .shadow(
                 color = Color.Black,
                 borderRadius = 0.dp,
                 blurRadius = 8.dp,
                 offsetY = 40.dp,
                 offsetX = 0.dp,
                 spread = 0.dp,
                 modifier = Modifier
             )
             .layoutId("background")
             .background(color = buttonColor, shape = RoundedCornerShape(16.dp))
             .clip(shape = RoundedCornerShape(16.dp))
             .clickable(
                 onClick = onClick,
                 enabled = !disabled,
                 role = Role.Button,
                 interactionSource = interactionSource,
                 indication = rememberRipple(color = textColor)
             ),
         contentAlignment = Alignment.Center
     ) {
         Row(
             modifier = Modifier.padding(
                 vertical = Entriverse.entriverseDimens.referenceDimens.spacingXl,
                 horizontal = Entriverse.entriverseDimens.referenceDimens.spacingXl
             ),
             verticalAlignment = Alignment.CenterVertically
         ) {

             if (icon != null) {
                 Icon(
                     painter = painterResource(id = icon),
                     contentDescription = "Button Icon",
                     tint = textColor,
                     modifier = Modifier.size(Entriverse.entriverseDimens.referenceDimens.spacingXl)
                 )
             }

             if (expanded) {
                 Spacer(modifier = Modifier.width(Entriverse.entriverseDimens.referenceDimens.spacingM))
                 EntriverseText(
                     text = label,
                     color = textColor,
                     style = Entriverse.typography.buttonBold,
                     textAlign = TextAlign.Center
                 )
             }
         }
     }
  */

    ExtendedFloatingActionButton(
        modifier = modifier,
        expanded = expanded,
        icon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Floating action button",
                tint = textColor,
                modifier = Modifier.size(Entriverse.entriverseDimens.referenceDimens.spacingXl)
            )
        },
        text = {
            EntriverseText(
                text = label,
                color = textColor,
                style = Entriverse.typography.buttonBold,
                textAlign = TextAlign.Center
            )
        },
        onClick = onClick,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = Entriverse.entriverseDimens.referenceDimens.spacingXl,
            pressedElevation = Entriverse.entriverseDimens.referenceDimens.spacingXxl,
            hoveredElevation = Entriverse.entriverseDimens.referenceDimens.spacingXl
        ),
        containerColor = buttonColor,
        interactionSource = remember { MutableInteractionSource() },
        )
}

/*fun Modifier.shadow(
    color: Color = Color.Black,
    borderRadius: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    spread: Dp = 0f.dp,
    modifier: Modifier = Modifier
) = this.then(
    modifier.drawBehind {
        this.drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            val spreadPixel = spread.toPx()
            val leftPixel = (0f - spreadPixel) + offsetX.toPx() + 10
            val topPixel = (0f - spreadPixel) + offsetY.toPx() + 15
            val rightPixel = (this.size.width + spreadPixel - 10)
            val bottomPixel = (this.size.height + spreadPixel - 5)

            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter =
                    (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
            }

            frameworkPaint.color = color.toArgb()
            it.drawRoundRect(
                left = leftPixel,
                top = topPixel,
                right = rightPixel,
                bottom = bottomPixel,
                radiusX = borderRadius.toPx(),
                radiusY = borderRadius.toPx(),
                paint
            )
        }
    }
)*/


@Preview(showSystemUi = true)
@Composable
private fun Test() {
    Column(modifier = Modifier.fillMaxSize()) {
        EntriverseExtendedFAB(
            modifier = Modifier,
            onClick = {},
            label = "Ask Eva",
            expanded = true,
            icon = R.drawable.button_icon,
            buttonColor = Entriverse.palette.fabColor,
            textColor = Entriverse.palette.brown800
        )
    }
}