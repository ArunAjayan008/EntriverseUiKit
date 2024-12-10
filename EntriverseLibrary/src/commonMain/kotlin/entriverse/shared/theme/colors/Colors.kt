package entriverse.shared.theme.colors

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
internal fun ProvideEntriverseColors(colors: EntriverseColors, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalEntriverseColors provides colors, content = content)
}

internal val LocalEntriverseColors = staticCompositionLocalOf { lightColors }
internal val lightColors: EntriverseColors = createLightColors()
internal val darkColors = createDarkColors()


