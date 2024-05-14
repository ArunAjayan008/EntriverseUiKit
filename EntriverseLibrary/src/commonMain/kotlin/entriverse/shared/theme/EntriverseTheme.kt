package entriverse.shared.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import entriverse.shared.theme.typography.EntriverseTypographyManager
import entriverse.shared.theme.typography.EntriverseTypographyManager.LocalEntriverseTypography
import entriverse.shared.entriverselibrary.theme.typography.interTypographyProvider
import entriverse.shared.theme.colors.ProvideEntriverseColors
import entriverse.shared.theme.colors.darkColors
import entriverse.shared.theme.colors.lightColors
import entriverse.shared.theme.typography.notoSerifTypographyProvider

@Composable
 fun EntriverseTheme(
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
        EntriverseTypographyManager.typographyProvider(colors)
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
 enum class UserLocale { EN, ML, HI, KA, TE}
