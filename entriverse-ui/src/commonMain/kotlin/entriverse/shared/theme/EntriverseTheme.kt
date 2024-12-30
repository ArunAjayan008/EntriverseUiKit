package entriverse.shared.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import entriverse.shared.theme.colors.ProvideEntriverseColors
import entriverse.shared.theme.colors.darkColors
import entriverse.shared.theme.colors.lightColors
import entriverse.shared.theme.dimen.dimenValue
import entriverse.shared.theme.typography.EntriverseTypographyManager
import entriverse.shared.theme.typography.EntriverseTypographyManager.LocalEntriverseTypography
import entriverse.shared.theme.typography.evTypographyProvider

@Composable
 fun EntriverseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    userLocale: UserLocale = UserLocale.ML,
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) darkColors else lightColors

  /* val localeTypographyProvider= when(userLocale){
        UserLocale.EN -> evTypographyProvider
        UserLocale.ML -> notoSerifTypographyProvider
        UserLocale.HI -> notoSerifTypographyProvider
        UserLocale.KA -> notoSerifTypographyProvider
        UserLocale.TE -> notoSerifTypographyProvider
    }*/

    EntriverseTypographyManager.provideUserLocale(userLocale)
    EntriverseTypographyManager.provideTypography(evTypographyProvider)
    val typography = runCatching {
        EntriverseTypographyManager.typographyProvider(userLocale,dimenValue)
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
            " called before using Theme."
 enum class UserLocale { EN, ML, HI, KA, TE}
