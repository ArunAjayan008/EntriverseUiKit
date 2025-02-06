package me.arunajayan.entriverseui

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import entriverse.shared.Entriverse
import entriverse.shared.components.EvText
import entriverse.shared.components.button.ButtonIconPosition
import entriverse.shared.components.button.ButtonSize
import entriverse.shared.components.button.ButtonType
import entriverse.shared.components.button.EvButton
import entriverse.shared.components.card.EvCard
import entriverse.shared.components.card.EvCardType
import entriverse.shared.components.extendedFab.EvExtendedFAB
import entriverse.shared.components.textInput.EvTextInputField
import entriverse.shared.theme.EntriverseTheme
import entriverse.shared.theme.UserLocale
import java.util.Locale

class MainActivity : ComponentActivity() {
    private var lang: UserLocale = UserLocale.EN
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lang = getSavedLanguageFromPreferences(this)
        setContent {
            SetAppTheme(userLocale = lang, onClick = {
                lang = if (lang == UserLocale.EN) {
                    UserLocale.ML
                } else {
                    UserLocale.EN
                }
                saveLanguageToPreferences(this, lang)
                restartActivity()
            })
        }
    }

    override fun attachBaseContext(newBase: Context) {
        val savedLang = getSavedLanguageFromPreferences(newBase)
        val newContext = setLocale(newBase, savedLang)
        super.attachBaseContext(newContext)
    }

    private fun restartActivity() {
        finish()
        startActivity(intent)
    }

    private fun saveLanguageToPreferences(context: Context, language: UserLocale) {
        val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        prefs.edit().putString("selected_language", language.toString()).apply()
    }

    private fun getSavedLanguageFromPreferences(context: Context): UserLocale {
        val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        return UserLocale.valueOf(
            prefs.getString("selected_language", UserLocale.EN.toString())
                ?: UserLocale.EN.toString()
        )
    }

}

fun setLocale(context: Context, languageCode: UserLocale): Context {
    val locale = Locale(languageCode.toString())
    Locale.setDefault(locale)
    val configuration = Configuration(context.resources.configuration)
    configuration.setLocale(locale)
    return context.createConfigurationContext(configuration)
}

@Composable
fun SetAppTheme(onClick: () -> Unit, userLocale: UserLocale) {
    val isDarkTheme = isSystemInDarkTheme()
    var darkTheme by remember { mutableStateOf(isDarkTheme) }
    var locale by remember {
        mutableStateOf(userLocale)
    }

    fun setLangVal() {
        locale = if (locale == UserLocale.EN) {
            UserLocale.ML
        } else {
            UserLocale.EN
        }
    }

    val imeInsets = WindowInsets.ime.getBottom(LocalDensity.current)
    val navigationBarsInsets = WindowInsets.navigationBars.getBottom(LocalDensity.current)

    var screenItem by remember { mutableIntStateOf(1) }

    EntriverseTheme(darkTheme = darkTheme, userLocale = locale) {
        Surface(
            modifier = Modifier
                .padding(bottom = with(LocalDensity.current) { imeInsets.toDp() + navigationBarsInsets.toDp() })
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Entriverse.colors.materialColors.background)
                    .navigationBarsPadding()
                    .padding(top = 40.dp)
            ) {
                when (screenItem) {
                    1 -> {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Spacer(modifier = Modifier.height(20.dp))
                            EvButton(
                                modifier = Modifier,
                                onClick = {
                                    screenItem = 2
                                },
                                label = "BUTTONS",
                                type = ButtonType.FILLED,
                                size = ButtonSize.REGULAR
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            EvButton(
                                modifier = Modifier,
                                onClick = { screenItem = 3 },
                                label = "FAB",
                                type = ButtonType.FILLED,
                                size = ButtonSize.REGULAR
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            EvButton(
                                modifier = Modifier,
                                onClick = { screenItem = 4 },

                                label = "TEXTBOX",
                                type = ButtonType.FILLED,
                                size = ButtonSize.REGULAR
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            EvButton(
                                modifier = Modifier,
                                onClick = { screenItem = 5 },

                                label = "CARD",
                                type = ButtonType.FILLED,
                                size = ButtonSize.REGULAR
                            )
                        }
                    }

                    2 -> {
                        Buttons(
                            onClickTheme = {
                                darkTheme = !darkTheme
                            },
                            onBackPressed = {
                                screenItem = 1
                            }
                        )
                    }

                    3 -> {
                        FAB(onClickLanguage = {
                            setLangVal()
                            onClick()
                        },
                            onBackPressed = {
                                screenItem = 1
                            })
                    }

                    4 -> {
                        TextField(onBackPressed = {
                            screenItem = 1
                        })
                    }

                    5 -> {
                        EvCard(onBackPressed = {
                            screenItem = 1
                        })
                    }
                }
            }
        }
    }
}

@Composable
fun Buttons(onClickTheme: () -> Unit, onBackPressed: () -> Unit) {
    BackHandler(enabled = true) {
        onBackPressed()
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            EvText(
                text = "Regular Button",
                color = Entriverse.colors.referenceColors.primaryText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                style = Entriverse.typography.buttonText,
                fontSize = 20.sp
            )
        }

        //REGULAR

        //ICON START
        item {
            Spacer(
                modifier = Modifier
                    .height(2.dp)
                    .background(Color.Gray)
            )
            Spacer(modifier = Modifier.height(20.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.FILLED,
                size = ButtonSize.REGULAR,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.REGULAR,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.REGULAR,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.REGULAR,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.REGULAR,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.REGULAR,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.REGULAR,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }


        //ICON END
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.REGULAR,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.REGULAR,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.REGULAR,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.REGULAR,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.REGULAR,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.REGULAR,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }

        //WITHOUT ICON
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.REGULAR,
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.REGULAR
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.REGULAR
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.REGULAR
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.REGULAR,
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.REGULAR
            )
        }


        //SMALL

        //ICON START
        item {
            Spacer(
                modifier = Modifier
                    .height(2.dp)
                    .fillMaxWidth()
                    .background(Color.Gray)
            )

            EvText(
                text = "SMALL BUTTON",
                color = Entriverse.colors.referenceColors.primaryText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                style = Entriverse.typography.buttonText,
                fontSize = 20.sp
            )
        }


        item {
            Spacer(modifier = Modifier.height(20.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.FILLED,
                size = ButtonSize.SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }

        //ICON END
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }

        //WITHOUT ICON
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.SMALL,
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.SMALL,
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.SMALL,
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.SMALL,
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.SMALL,
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.SMALL,
            )
        }


        //EXTRA SMALL

        //ICON START

        item {
            Spacer(
                modifier = Modifier
                    .height(2.dp)
                    .fillMaxWidth()
                    .background(Color.Gray)
            )
            EvText(
                text = "EXTRA SMALL BUTTON",
                color = Entriverse.colors.referenceColors.primaryText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                style = Entriverse.typography.buttonText,
                fontSize = 20.sp
            )
        }


        item {
            Spacer(modifier = Modifier.height(20.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.FILLED,
                size = ButtonSize.EXTRA_SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.EXTRA_SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.EXTRA_SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.EXTRA_SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.EXTRA_SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.EXTRA_SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.EXTRA_SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START
            )
        }

        //ICON END
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.EXTRA_SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.EXTRA_SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.EXTRA_SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.EXTRA_SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.EXTRA_SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.EXTRA_SMALL,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END
            )
        }

        //WITHOUT ICON
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.EXTRA_SMALL,
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = onClickTheme,
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.EXTRA_SMALL,
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.EXTRA_SMALL,
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.EXTRA_SMALL
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.EXTRA_SMALL,
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                modifier = Modifier,
                onClick = {},
                disabled = false,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.EXTRA_SMALL
            )
        }
    }
}

@Composable
fun FAB(onBackPressed: () -> Unit, onClickLanguage: () -> Unit) {
    BackHandler(enabled = true) {
        onBackPressed()
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            EvText(
                text = "FAB",
                color = Entriverse.colors.referenceColors.primaryText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                style = Entriverse.typography.buttonText,
                fontSize = 20.sp
            )
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvExtendedFAB(
                modifier = Modifier,
                onClick = onClickLanguage,
                expanded = false,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
            )
            EvExtendedFAB(
                modifier = Modifier,
                onClick = onClickLanguage,
                label = stringResource(R.string.change_locale),
                expanded = true,
                icon = me.entri.entriverseui.R.drawable.ev_button_icon,
            )
            EvExtendedFAB(
                modifier = Modifier,
                onClick = onClickLanguage,
                label = stringResource(R.string.change_locale),
                expanded = true,
            )
        }
    }
}

@Composable
fun TextField(onBackPressed: () -> Unit) {
    BackHandler(enabled = true) {
        onBackPressed()
    }
    val emailValidation: Boolean? by remember {
        mutableStateOf(null)
    }
    var validation: Boolean? by remember {
        mutableStateOf(null)
    }
    var emailIdText by remember {
        mutableStateOf(
            ""
        )
    }

    fun checkEmailValidation() {
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
        validation = if (emailIdText.isBlank()) {
            null
        } else {
            emailIdText.matches(emailRegex)
        }
    }

    fun saveEmail(email: String) {
        emailIdText = email
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            EvText(
                text = "Text Output Field",
                color = Entriverse.colors.referenceColors.primaryText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                style = Entriverse.typography.buttonText,
                fontSize = 20.sp
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvTextInputField(
                modifier = Modifier,
                onClick = { },
                leadingIcon = me.entri.entriverseui.R.drawable.ev_ic_search,
                supportingTextValue = when (validation) {
                    true -> "Success"
                    false -> "Invalid email id"
                    else -> "Enter email id"
                },
                clearInputEnabled = true,
                validateState = validation,
                label = stringResource(id = R.string.email),
                onValueChange = {
                    saveEmail(it)
                    checkEmailValidation()
                },
                characterLimit = 5
            )
        }
        item {
            Spacer(Modifier.height(10.dp))
            EvTextInputField(
                modifier = Modifier,
                onClick = { },
                isEnabled = true,
                leadingIcon = me.entri.entriverseui.R.drawable.ev_ic_search,
                supportingTextValue = when (validation) {
                    true -> "Success"
                    false -> "Invalid email id"
                    else -> "Enter email id"
                },
                clearInputEnabled = true,
                validateState = emailValidation,
                label = stringResource(id = R.string.email),
                onValueChange = {
                },
                characterLimit = 5
            )
        }

        item {
            Spacer(Modifier.height(10.dp))
            EvTextInputField(
                modifier = Modifier,
                onClick = { },
                isEnabled = false,
                leadingIcon = me.entri.entriverseui.R.drawable.ev_ic_search,
                supportingTextValue = when (validation) {
                    true -> "Success"
                    false -> "Invalid email id"
                    else -> "Enter email id"
                },
                label = stringResource(id = R.string.email),
                onValueChange = {
                },
                characterLimit = 5
            )
        }


        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvTextInputField(
                modifier = Modifier,
                onClick = { },
                clearInputEnabled = false,
                label = stringResource(id = R.string.email),
                onValueChange = {
                },
            )
        }
        item {
            Spacer(Modifier.height(10.dp))
            EvTextInputField(
                modifier = Modifier,
                onClick = { },
                isEnabled = false,
                clearInputEnabled = false,
                label = stringResource(id = R.string.email),
                onValueChange = {
                },
            )
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvTextInputField(
                modifier = Modifier,
                onClick = { },
                clearInputEnabled = false,
                singleLine = false,
                label = stringResource(id = R.string.email),
                onValueChange = {
                },
            )
        }
        item {
            Spacer(Modifier.height(10.dp))
            EvTextInputField(
                modifier = Modifier,
                onClick = { },
                isEnabled = false,
                singleLine = false,
                clearInputEnabled = false,
                validateState = emailValidation,
                label = stringResource(id = R.string.email),
                onValueChange = {
                },
            )
        }
    }
}

@Composable
fun EvCard(onBackPressed: () -> Unit) {
    BackHandler(enabled = true) {
        onBackPressed()
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            EvText(
                text = "CARD",
                color = Entriverse.colors.referenceColors.primaryText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                style = Entriverse.typography.buttonText,
                fontSize = 20.sp
            )
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = R.drawable.ic_card,
                isImageCard = false,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = R.drawable.ic_share,
                cardType = EvCardType.PRIMARY,
                onCardClicked = {}
            )
            Spacer(modifier = Modifier.height(10.dp))

            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = "https://images.unsplash.com/photo-1544005313-94ddf0286df2?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8cG9ydHJhaXR8ZW58MHx8MHx8fDA%3D",
                isImageCard = true,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = R.drawable.ic_share,
                cardType = EvCardType.SECONDARY,
                onCardClicked = {}
            )

            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = R.drawable.ic_card,
                isImageCard = false,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = R.drawable.ic_share,
                cardType = EvCardType.GOLD,
                onCardClicked = {}
            )

            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = "https://images.unsplash.com/photo-1544005313-94ddf0286df2?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8cG9ydHJhaXR8ZW58MHx8MHx8fDA%3D",
                isImageCard = true,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = R.drawable.ic_share,
                cardType = EvCardType.BLUE,
                onCardClicked = {}
            )

            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = "https://images.unsplash.com/photo-1544005313-94ddf0286df2?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8cG9ydHJhaXR8ZW58MHx8MHx8fDA%3D",
                isImageCard = true,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = R.drawable.ic_share,
                cardType = EvCardType.PURPLE,
                onCardClicked = {}
            )

            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = R.drawable.ic_card,
                isImageCard = false,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = R.drawable.ic_share,
                cardType = EvCardType.ORANGE,
                onCardClicked = {}
            )

            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = R.drawable.ic_card,
                isImageCard = false,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = R.drawable.ic_share,
                cardType = EvCardType.YELLOW,
                onCardClicked = {}
            )

            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = R.drawable.ic_card,
                isImageCard = false,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = R.drawable.ic_share,
                cardType = EvCardType.BROWN,
                onCardClicked = {}
            )

            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = R.drawable.ic_card,
                isImageCard = false,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = R.drawable.ic_share,
                cardType = EvCardType.SUCCESS,
                onCardClicked = {}
            )

            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = R.drawable.ic_card,
                isImageCard = false,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = R.drawable.ic_share,
                cardType = EvCardType.WARNING_ERROR,
                onCardClicked = {}
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    EntriverseTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            FAB(onBackPressed = {}, onClickLanguage = {})
        }
    }
}