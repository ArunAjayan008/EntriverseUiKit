package entriverse.shared.theme.typography

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import entriverse.shared.entriverselibrary.theme.typography.interTypographyProvider
import entriverse.shared.theme.colors.lightColors

public object EntriverseTypographyManager{

    public fun provideTypography(provider: EntriverseTypographyProvider) {
        typographyProvider = provider
    }

    internal lateinit var typographyProvider: EntriverseTypographyProvider
        private set


    internal val LocalEntriverseTypography: ProvidableCompositionLocal<EntriverseTypography> =
        staticCompositionLocalOf { interTypographyProvider.invoke(lightColors) }

}