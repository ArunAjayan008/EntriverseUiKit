package me.arunajayan.entriverselibrary.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import me.arunajayan.entriverselibrary.Entriverse
import me.arunajayan.entriverselibrary.theme.colors.ProvideEntriverseColors
import me.arunajayan.entriverselibrary.theme.colors.darkColors
import me.arunajayan.entriverselibrary.theme.colors.lightColors
import me.arunajayan.entriverselibrary.theme.typography.EntriverseTypographyManager
import me.arunajayan.entriverselibrary.theme.typography.EntriverseTypographyManager.LocalEntriverseTypography
import me.arunajayan.entriverselibrary.theme.typography.interTypographyProvider
import me.arunajayan.entriverselibrary.theme.typography.notoSerifTypographyProvider

@Composable
public fun EntriverseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    userLocale: UserLocale = UserLocale.ML,
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) darkColors else lightColors

   val localeTypography= when(userLocale){
        UserLocale.EN -> interTypographyProvider
        UserLocale.ML -> notoSerifTypographyProvider
        UserLocale.HI -> notoSerifTypographyProvider
        UserLocale.KA -> notoSerifTypographyProvider
        UserLocale.TE -> notoSerifTypographyProvider
    }

    EntriverseTypographyManager.provideTypography(localeTypography)
    val typography = runCatching {
        EntriverseTypographyManager.typographyProvider(Entriverse.colors)
    }.getOrElse { error(NO_TYPOGRAPHY_PROVIDER) }

    MaterialTheme {
        ProvideEntriverseColors(colors) {
            CompositionLocalProvider(
                LocalEntriverseTypography.provides(typography),
                content = content
            )
        }
    }
}
private const val NO_TYPOGRAPHY_PROVIDER =
    "Cannot obtain typographyProvider. initInterTypography() or notosansTypography() must be" +
            " called before using FlamingoTheme."
public enum class UserLocale { EN, ML, HI, KA, TE}
