package me.arunajayan.entriverselibrary.theme.typography

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import me.arunajayan.entriverselibrary.theme.colors.lightColors

public object EntriverseTypographyManager{
    public fun provideTypography(provider: EntriverseTypographyProvider) {
        if (::typographyProvider.isInitialized) return
        typographyProvider = provider
    }
    internal lateinit var typographyProvider: EntriverseTypographyProvider
        private set

    internal val LocalEntriverseTypography: ProvidableCompositionLocal<EntriverseTypography> =
        staticCompositionLocalOf { interTypographyProvider.invoke(lightColors) }

}