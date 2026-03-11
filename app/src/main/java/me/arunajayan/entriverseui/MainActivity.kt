package me.arunajayan.entriverseui

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import entriverse.shared.Entriverse
import entriverse.shared.Entriverse.typography
import entriverse.shared.components.EvText
import entriverse.shared.components.button.ButtonIconPosition
import entriverse.shared.components.button.ButtonSize
import entriverse.shared.components.button.ButtonType
import entriverse.shared.components.button.EvButton
import entriverse.shared.components.card.EvCard
import entriverse.shared.components.card.EvCardType
import entriverse.shared.components.extendedFab.EvExtendedFAB
import entriverse.shared.components.selection.EvSelectionButton
import entriverse.shared.components.selection.IconSize
import entriverse.shared.components.selection.SelectionButtonState
import entriverse.shared.components.textInput.EvTextInputField
import entriverse.shared.composeResources.Res
import entriverse.shared.composeResources.ev_button_icon
import entriverse.shared.composeResources.ev_close_icon
import entriverse.shared.composeResources.ev_ic_search
import entriverse.shared.composeResources.ev_success_icon
import entriverse.shared.theme.EntriverseTheme
import entriverse.shared.theme.UserLocale
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.DotLottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.animateLottieCompositionAsState
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
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
        val prefs = context.getSharedPreferences("app_prefs", MODE_PRIVATE)
        prefs.edit { putString("selected_language", language.toString()) }
    }

    private fun getSavedLanguageFromPreferences(context: Context): UserLocale {
        val prefs = context.getSharedPreferences("app_prefs", MODE_PRIVATE)
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
                            DotLottieThemingExample()
                            Spacer(modifier = Modifier.height(20.dp))
                            EvButton(
                                buttonModifier = Modifier,
                                onClick = {
                                    screenItem = 2
                                },
                                label = "BUTTONS",
                                type = ButtonType.FILLED,
                                size = ButtonSize.REGULAR,
                                contentDescription = "Buttons",

                                )
                            Spacer(modifier = Modifier.height(20.dp))
                            EvButton(
                                buttonModifier = Modifier,
                                onClick = { screenItem = 3 },
                                label = "FAB",
                                type = ButtonType.FILLED,
                                size = ButtonSize.REGULAR,
                                contentDescription = "FAB",

                                )
                            Spacer(modifier = Modifier.height(20.dp))
                            EvButton(
                                buttonModifier = Modifier,
                                onClick = { screenItem = 4 },

                                label = "TEXTBOX",
                                type = ButtonType.FILLED,
                                size = ButtonSize.REGULAR,
                                contentDescription = "Textbox",
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            EvButton(
                                buttonModifier = Modifier,
                                onClick = { screenItem = 5 },

                                label = "CARD",
                                type = ButtonType.FILLED,
                                size = ButtonSize.REGULAR,
                                contentDescription = "Card",
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            EvButton(
                                buttonModifier = Modifier,
                                onClick = { screenItem = 6 },
                                label = "TYPOGRAPHY",
                                type = ButtonType.FILLED,
                                size = ButtonSize.REGULAR,
                                contentDescription = "Typography",
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            EvButton(
                                buttonModifier = Modifier,
                                onClick = { screenItem = 7 },
                                label = "SELECTION",
                                type = ButtonType.FILLED,
                                size = ButtonSize.REGULAR,
                                contentDescription = "Selection",
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
                        FAB(
                            onClickLanguage = {
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

                    6 -> {
                        HeadingTypography(onBackPressed = {
                            screenItem = 1
                        })
                    }

                    7 -> {
                        EvSelectionPreview(onBackPressed = {
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
                style = typography.buttonText,
                fontSize = 20.sp,
                contentDescription = "akjsfh"
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
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.FILLED,
                size = ButtonSize.REGULAR,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.REGULAR,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.REGULAR,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.REGULAR,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.REGULAR,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.REGULAR,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.REGULAR,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }


        //ICON END
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.REGULAR,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.REGULAR,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.REGULAR,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.REGULAR,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.REGULAR,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.REGULAR,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }

        //WITHOUT ICON
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.REGULAR,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.REGULAR,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.REGULAR,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.REGULAR,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.REGULAR,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.REGULAR,
                contentDescription = "Change Theme",

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
                style = typography.buttonText,
                fontSize = 20.sp,
                contentDescription = "akjsfh"
            )
        }


        item {
            Spacer(modifier = Modifier.height(20.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.FILLED,
                size = ButtonSize.SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }

        //ICON END
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }

        //WITHOUT ICON
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.SMALL,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.SMALL,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.SMALL,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.SMALL,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.SMALL,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.SMALL,
                contentDescription = "Change Theme",

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
                style = typography.buttonText,
                fontSize = 20.sp,
                contentDescription = "akjsfh"
            )
        }


        item {
            Spacer(modifier = Modifier.height(20.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.FILLED,
                size = ButtonSize.EXTRA_SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.EXTRA_SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.EXTRA_SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.EXTRA_SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.EXTRA_SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.EXTRA_SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.EXTRA_SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.START,
                contentDescription = "Change Theme",

                )
        }

        //ICON END
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.EXTRA_SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.EXTRA_SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.EXTRA_SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.EXTRA_SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.EXTRA_SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.EXTRA_SMALL,
                icon = Res.drawable.ev_button_icon,
                iconPosition = ButtonIconPosition.END,
                contentDescription = "Change Theme",

                )
        }

        //WITHOUT ICON
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TONAL,
                size = ButtonSize.EXTRA_SMALL,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = onClickTheme,
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.OUTLINED,
                size = ButtonSize.EXTRA_SMALL,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SECONDARY_OUTLINED,
                size = ButtonSize.EXTRA_SMALL,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.DESTRUCTIVE,
                size = ButtonSize.EXTRA_SMALL,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.SUCCESS,
                size = ButtonSize.EXTRA_SMALL,
                contentDescription = "Change Theme",

                )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvButton(
                buttonModifier = Modifier,
                onClick = {},
                enabled = true,
                label = stringResource(R.string.change_theme),
                type = ButtonType.TEXT,
                size = ButtonSize.EXTRA_SMALL,
                contentDescription = "Change Theme",

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
                style = typography.buttonText,
                fontSize = 20.sp,
                contentDescription = "akjsfh"
            )
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvExtendedFAB(
                modifier = Modifier,
                onClick = onClickLanguage,
                expanded = false,
                icon = Res.drawable.ev_button_icon,
                contentDescription = "FAB"
            )
            EvExtendedFAB(
                modifier = Modifier,
                onClick = onClickLanguage,
                label = stringResource(R.string.change_locale),
                expanded = true,
                icon = Res.drawable.ev_button_icon,
                contentDescription = "FAB"
            )
            EvExtendedFAB(
                modifier = Modifier,
                onClick = onClickLanguage,
                label = stringResource(R.string.change_locale),
                expanded = true,
                contentDescription = "FAB"
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
                style = typography.buttonText,
                fontSize = 20.sp,
                contentDescription = "akjsfh"
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvTextInputField(
                onClick = { },
                leadingIcon = Res.drawable.ev_ic_search,
                supportingTextValue = when (validation) {
                    true -> "Success"
                    false -> "Invalid email id"
                    else -> "Enter email id"
                },
                validateState = validation,
                label = stringResource(id = R.string.email),
                onValueChange = {
                    saveEmail(it)
                    checkEmailValidation()
                },
                characterLimit = 5,
                contentDescription = "Text Output Field"
            )
        }
        item {
            Spacer(Modifier.height(10.dp))
            EvTextInputField(
                modifier = Modifier,
                onClick = { },
                isEnabled = true,
                leadingIcon = Res.drawable.ev_ic_search,
                supportingTextValue = when (validation) {
                    true -> "Success"
                    false -> "Invalid email id"
                    else -> "Enter email id"
                },
                validateState = emailValidation,
                label = stringResource(id = R.string.email),
                onValueChange = {
                },
                characterLimit = 5,
                contentDescription = "Text Output Field"
            )
        }

        item {
            Spacer(Modifier.height(10.dp))
            EvTextInputField(
                modifier = Modifier,
                onClick = { },
                isEnabled = false,
                leadingIcon = Res.drawable.ev_ic_search,
                supportingTextValue = when (validation) {
                    true -> "Success"
                    false -> "Invalid email id"
                    else -> "Enter email id"
                },
                label = stringResource(id = R.string.email),
                onValueChange = {
                },
                inputValue = "asdfkjahsjfkh",
                characterLimit = 5,
                contentDescription = "Text Output Field"
            )
        }


        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvTextInputField(
                modifier = Modifier,
                onClick = { },
                label = stringResource(id = R.string.email),
                onValueChange = {
                },
                contentDescription = "Text Output Field"
            )
        }
        item {
            Spacer(Modifier.height(10.dp))
            EvTextInputField(
                modifier = Modifier,
                onClick = { },
                isEnabled = false,
                label = stringResource(id = R.string.email),
                onValueChange = {
                },
                contentDescription = "Text Output Field"
            )
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvTextInputField(
                modifier = Modifier,
                onClick = { },
                singleLine = false,
                label = stringResource(id = R.string.email),
                onValueChange = {
                },
                contentDescription = "Text Output Field"
            )
        }
        item {
            Spacer(Modifier.height(10.dp))
            EvTextInputField(
                modifier = Modifier,
                onClick = { },
                isEnabled = false,
                singleLine = false,
                validateState = emailValidation,
                label = stringResource(id = R.string.email),
                onValueChange = {
                },
                contentDescription = "Text Output Field"
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
                style = typography.buttonText,
                fontSize = 20.sp,
                contentDescription = "akjsfh"
            )
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = Res.drawable.ev_close_icon,
                isImageCard = false,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = Res.drawable.ev_button_icon,
                cardType = EvCardType.PRIMARY,
                onCardClicked = {},
                contentDescription = "EvCard"
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
                primaryCtaIcon = Res.drawable.ev_ic_search,
                cardType = EvCardType.SECONDARY,
                onCardClicked = {},
                contentDescription = "EvCard"
            )

            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = Res.drawable.ev_button_icon,
                isImageCard = false,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = Res.drawable.ev_button_icon,
                cardType = EvCardType.GOLD,
                onCardClicked = {},
                contentDescription = "EvCard"
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
                primaryCtaIcon = Res.drawable.ev_close_icon,
                cardType = EvCardType.BLUE,
                onCardClicked = {},
                contentDescription = "EvCard"
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
                primaryCtaIcon = Res.drawable.ev_button_icon,
                cardType = EvCardType.PURPLE,
                onCardClicked = {},
                contentDescription = "EvCard"
            )

            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = Res.drawable.ev_button_icon,
                isImageCard = false,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = Res.drawable.ev_close_icon,
                cardType = EvCardType.ORANGE,
                onCardClicked = {},
                contentDescription = "EvCard"
            )

            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = Res.drawable.ev_button_icon,
                isImageCard = false,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = Res.drawable.ev_success_icon,
                cardType = EvCardType.YELLOW,
                onCardClicked = {},
                contentDescription = "EvCard"
            )

            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = Res.drawable.ev_close_icon,
                isImageCard = false,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = Res.drawable.ev_button_icon,
                cardType = EvCardType.BROWN,
                onCardClicked = {},
                contentDescription = "EvCard"
            )

            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = Res.drawable.ev_close_icon,
                isImageCard = false,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = Res.drawable.ev_close_icon,
                cardType = EvCardType.SUCCESS,
                onCardClicked = {},
                contentDescription = "EvCard"
            )

            Spacer(modifier = Modifier.height(10.dp))
            EvCard(
                parentModifier = Modifier,
                titleText = stringResource(R.string.card_title),
                subTitleText = stringResource(R.string.subtitletext),
                cardIcon = Res.drawable.ev_close_icon,
                isImageCard = false,
                primaryCta = "CTA Text",
                secondaryCta = "Dismiss",
                primaryCtaIcon = Res.drawable.ev_success_icon,
                cardType = EvCardType.WARNING_ERROR,
                onCardClicked = {},
                contentDescription = "EvCard"
            )
        }
    }
}

@Composable
fun HeadingTypography(onBackPressed: () -> Unit) {
    BackHandler(enabled = true) {
        onBackPressed()
    }
    EntriverseTheme {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                EvText(
                    text = "Heading S - Regular",
                    style = typography.headingSRegular,
                    contentDescription = "Heading S - Regular"
                )
                EvText(
                    text = "Heading S - Bold",
                    style = typography.headingSBold,
                    contentDescription = "Heading S - Bold"
                )
                EvText(
                    text = "Heading L - Regular",
                    style = typography.headingLRegular,
                    contentDescription = "Heading L - Regular"
                )
                EvText(
                    text = "Heading L - Bold",
                    style = typography.headingLBold,
                    contentDescription = "Heading L - Bold"
                )
                EvText(
                    text = "Heading XL - Regular",
                    style = typography.headingXLRegular,
                    contentDescription = "Heading XL - Regular"
                )
                EvText(
                    text = "Heading XL - Bold",
                    style = typography.headingXLBold,
                    contentDescription = "Heading XL - Bold"
                )
                EvText(
                    text = "Display S - Regular",
                    style = typography.displaySRegular,
                    contentDescription = "Display S - Regular"
                )
                EvText(
                    text = "Display S - Bold",
                    style = typography.displaySBold,
                    contentDescription = "Display S - Bold"
                )
                EvText(
                    text = "Display L - Regular",
                    style = typography.displayLRegular,
                    contentDescription = "Display L - Regular"
                )
                EvText(
                    text = "Display L - Bold",
                    style = typography.displayLBold,
                    contentDescription = "Display L - Bold"
                )
                EvText(
                    text = "Display XL - Regular",
                    style = typography.displayXLRegular,
                    contentDescription = "Display XL - Regular"
                )
                EvText(
                    text = "Display XL - Bold",
                    style = typography.displayXLBold,
                    contentDescription = "Display XL - Bold"
                )
            }
        }
    }
}

@Composable
fun EvSelectionPreview(onBackPressed: () -> Unit) {

    BackHandler(enabled = true) {
        onBackPressed()
    }
    EntriverseTheme {
        Column(modifier = Modifier.padding(20.dp)) {
            EvSelectionButton(
                label = "Active State",
                buttonState = SelectionButtonState.ActiveEnabled(
                    icon = Res.drawable.ev_button_icon,
                    iconSize = IconSize.Size24
                ),
                onClick = {},
                contentDescription = "EvSelectionActive"
            )
            Spacer(Modifier.height(20.dp))
            EvSelectionButton(
                label = "Inactive State",
                buttonState = SelectionButtonState.InactiveEnabled(),
                onClick = {},
                contentDescription = "EvSelectionInactive"
            )
            Spacer(Modifier.height(20.dp))
            EvSelectionButton(
                label = "Disabled State",
                buttonState = SelectionButtonState.InactiveDisabled(),
                onClick = {},
                contentDescription = "EvSelectionDisabled"
            )
            Spacer(Modifier.height(20.dp))
            EvSelectionButton(
                label = "Disabled State",
                buttonState = SelectionButtonState.Gold(),
                onClick = {},
                contentDescription = "EvSelectionDisabled"
            )
            Spacer(Modifier.height(20.dp))
            EvSelectionButton(
                label = "Disabled State",
                buttonState = SelectionButtonState.ActiveDisabled(),
                onClick = {},
                contentDescription = "EvSelectionDisabled"
            )
        }
    }
}

//private val dotLottieThemes = listOf("sunset", "night", "midnight", "day", "winter")
private val dotLottieThemes = listOf("Dark", "Light")

@Composable
private fun DotLottieThemingExample() {
    val context = LocalContext.current
    var selectedTheme by remember { mutableStateOf(dotLottieThemes.first()) }

    val composition by rememberLottieComposition {
        LottieCompositionSpec.DotLottie(
            context.assets.open("theme2.lottie").readBytes()
        )
    }

    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = Compottie.IterateForever
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberLottiePainter(
                composition = composition,
                progress = { progress },
                theme = selectedTheme
            ),
            contentDescription = "DotLottie themed animation",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            dotLottieThemes.forEach { theme ->
                EvButton(
                    buttonModifier = Modifier.weight(1f),
                    onClick = { selectedTheme = theme },
                    label = theme.replaceFirstChar { it.uppercase() },
                    type = if (selectedTheme == theme) ButtonType.FILLED else ButtonType.OUTLINED,
                    size = ButtonSize.SMALL,
                    contentDescription = theme
                )
            }
        }
    }
}
