package entriverse.shared

import EntriverseColorPalette
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import entriverse.shared.theme.typography.EntriverseTypography
import entriverse.shared.theme.typography.EntriverseTypographyManager.LocalEntriverseTypography
import entriverse.shared.theme.colors.EntriverseColors
import entriverse.shared.theme.colors.LocalEntriverseColors
import entriverse.shared.theme.dimen.EntriverseDimens
import entriverse.shared.theme.dimen.EntriverseDimensValues
import entriverse.shared.theme.dimen.EntriverseFontDimens
import entriverse.shared.theme.dimen.LocalDimens

 object Entriverse {
     val colors: EntriverseColors
        @Composable
        @ReadOnlyComposable
        get() = LocalEntriverseColors.current

     val typography: EntriverseTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalEntriverseTypography.current


     val palette: EntriverseColorPalette = EntriverseColorPalette()

     val entriverseDimens: EntriverseDimens
        @Composable
        @ReadOnlyComposable
        get() = LocalDimens.current

     val dimens: EntriverseDimensValues = EntriverseDimensValues()
     val fontDimens: EntriverseFontDimens = EntriverseFontDimens()
}