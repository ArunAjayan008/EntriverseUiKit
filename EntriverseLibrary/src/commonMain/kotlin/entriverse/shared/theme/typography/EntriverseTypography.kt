package entriverse.shared.theme.typography

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import entriverse.shared.theme.colors.EntriverseColors

@Immutable
 data class EntriverseTypography(
    private val colors: EntriverseColors,
     val h1:TextStyle,
     val h1Bold:TextStyle,
     val h2:TextStyle,
     val h2Bold:TextStyle,
     val h3:TextStyle,
     val h3Bold:TextStyle,
     val h4:TextStyle,
     val h4Bold:TextStyle,
     val display1: TextStyle,
     val buttonDefault: TextStyle,
     val buttonBold: TextStyle,
     val buttonItalic: TextStyle,
)