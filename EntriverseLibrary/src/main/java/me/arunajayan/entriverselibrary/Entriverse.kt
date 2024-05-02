package me.arunajayan.entriverselibrary

import EntriverseColorPalette
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import me.arunajayan.entriverselibrary.theme.colors.EntriverseColors
import me.arunajayan.entriverselibrary.theme.colors.LocalEntriverseColors
import me.arunajayan.entriverselibrary.theme.dimen.EntriverseDimens
import me.arunajayan.entriverselibrary.theme.dimen.EntriverseDimensValues
import me.arunajayan.entriverselibrary.theme.dimen.LocalDimens
import me.arunajayan.entriverselibrary.theme.typography.EntriverseTypography
import me.arunajayan.entriverselibrary.theme.typography.EntriverseTypographyManager.LocalEntriverseTypography

public object Entriverse {
    public val colors: EntriverseColors
        @Composable
        @ReadOnlyComposable
        get() = LocalEntriverseColors.current

    public val typography: EntriverseTypography
    @Composable
    @ReadOnlyComposable
    get()=LocalEntriverseTypography.current


    public val palette: EntriverseColorPalette = EntriverseColorPalette()

    public val entriverseDimens:EntriverseDimens
    @Composable
    @ReadOnlyComposable
    get() = LocalDimens.current

    public val dimens:EntriverseDimensValues= EntriverseDimensValues()

}