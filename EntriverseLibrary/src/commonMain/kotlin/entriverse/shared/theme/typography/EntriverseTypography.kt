package entriverse.shared.theme.typography

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

@Immutable
data class EntriverseTypography(
    val bodyDefaultRegular: TextStyle,
    val bodyDefaultMedium: TextStyle,
    val bodyDefaultBold: TextStyle,
    val bodyLargeRegular: TextStyle,
    val bodyLargeMedium: TextStyle,
    val bodyLargeBold: TextStyle,
    val bodySerifRegular: TextStyle,
    val bodySerifMedium: TextStyle,
    val bodySerifBold: TextStyle,
    val captionDefaultRegular: TextStyle,
    val captionDefaultMedium: TextStyle,
    val captionDefaultBold: TextStyle,
    val captionSmallRegular: TextStyle,
    val captionSmallMedium: TextStyle,
    val captionSmallBold: TextStyle,
    val labelText: TextStyle,
    val buttonText: TextStyle,
)
