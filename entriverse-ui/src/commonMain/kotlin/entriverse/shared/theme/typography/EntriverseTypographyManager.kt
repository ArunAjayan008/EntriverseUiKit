package entriverse.shared.theme.typography

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import entriverse.shared.theme.UserLocale
import entriverse.shared.theme.dimen.dimenValue

object EntriverseTypographyManager{

    fun provideTypography(provider: EntriverseTypographyProvider) {
        typographyProvider = provider
    }

    internal lateinit var typographyProvider: EntriverseTypographyProvider
        private set

    fun provideUserLocale(locale: UserLocale){
        userLocale = locale
    }

    private lateinit var userLocale: UserLocale
        private set


    internal val LocalEntriverseTypography: ProvidableCompositionLocal<EntriverseTypography> =
        staticCompositionLocalOf { typographyProvider.invoke(userLocale, dimenValue)}

}