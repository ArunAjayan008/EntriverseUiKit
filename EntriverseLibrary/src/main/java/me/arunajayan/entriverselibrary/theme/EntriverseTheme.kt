package me.arunajayan.entriverselibrary.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import me.arunajayan.entriverselibrary.theme.colors.ProvideEntriverseColors
import me.arunajayan.entriverselibrary.theme.colors.darkColors
import me.arunajayan.entriverselibrary.theme.colors.lightColors

@Composable
public fun EntriverseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) darkColors else lightColors

    MaterialTheme(
    ) {
        ProvideEntriverseColors(colors) {
            CompositionLocalProvider(
                content = content
            )
        }
    }
}