package me.entri.entriverseui

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import entriverse.shared.Entriverse
import entriverse.shared.components.EvText
import entriverse.shared.components.button.ButtonIconPosition
import entriverse.shared.components.button.ButtonSize
import entriverse.shared.components.button.ButtonType
import entriverse.shared.components.button.EvButton
import entriverse.shared.components.extendedFab.EvExtendedFAB
import entriverse.shared.components.textInput.EvTextInputField
import entriverse.shared.theme.EntriverseTheme
import entriverse.shared.theme.UserLocale
import java.util.Locale

class MainActivity : ComponentActivity() {
    private var lang: UserLocale = UserLocale.EN
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLocale(this, lang)
        enableEdgeToEdge()
        setContent {
            SetAppTheme(userLocale = lang, onClick = {
                if (lang == UserLocale.EN) {
                    setLocale(this, UserLocale.ML)
                    lang = UserLocale.ML
                } else {
                    setLocale(this, UserLocale.EN)
                    lang = UserLocale.EN
                }
            })
        }
    }
}

fun setLocale(context: Context, languageCode: UserLocale) {
    val locale = Locale(languageCode.toString())
    Locale.setDefault(locale)
    val configuration = Configuration(context.resources.configuration)
    configuration.setLocale(locale)
    context.resources.updateConfiguration(configuration, context.resources.displayMetrics)
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

    EntriverseTheme(darkTheme = darkTheme, userLocale = locale) {
        Surface(modifier = Modifier.fillMaxSize().background(Entriverse.colors.materialColors.surface)
          ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Entriverse.colors.materialColors.background)
                    .padding(top = 120.dp)
            ) {
                Greeting(
                    onClickTheme = {
                        darkTheme = !darkTheme
                    },
                    onClickLanguage = {
                        setLangVal()
                        onClick()
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(onClickTheme: () -> Unit, onClickLanguage: () -> Unit) {
    Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        EvText(
            text = stringResource(R.string.infoText),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Entriverse.colors.referenceColors.primaryText,
            style = Entriverse.typography.buttonText,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        EvButton(
            modifier = Modifier,
            onClick = onClickTheme,
            disabled = false,
            label = stringResource(R.string.change_theme),
            type = ButtonType.FILLED,
            size = ButtonSize.REGULAR,
            icon = R.drawable.ev_button_icon,
            iconPosition = ButtonIconPosition.START
        )
        Spacer(modifier = Modifier.height(10.dp))
        EvButton(
            modifier = Modifier,
            onClick = onClickTheme,
            disabled = false,
            label = stringResource(R.string.change_theme),
            type = ButtonType.TONAL,
            size = ButtonSize.REGULAR,
            icon = R.drawable.ev_button_icon,
            iconPosition = ButtonIconPosition.START
        )
        Spacer(modifier = Modifier.height(10.dp))
        EvButton(
            modifier = Modifier,
            onClick = onClickTheme,
            disabled = false,
            label = stringResource(R.string.change_theme),
            type = ButtonType.OUTLINED,
            size = ButtonSize.REGULAR,
            icon = R.drawable.ev_button_icon,
            iconPosition = ButtonIconPosition.START
        )
        Spacer(modifier = Modifier.height(10.dp))

        EvButton(
            modifier = Modifier,
            onClick = {},
            disabled = false,
            label = stringResource(R.string.change_theme),
            type = ButtonType.SECONDARY_OUTLINED,
            size = ButtonSize.REGULAR,
            icon = R.drawable.ev_button_icon,
            iconPosition = ButtonIconPosition.START
        )
        Spacer(modifier = Modifier.height(10.dp))

        EvButton(
            modifier = Modifier,
            onClick = {},
            disabled = false,
            label = stringResource(R.string.change_theme),
            type = ButtonType.DESTRUCTIVE,
            size = ButtonSize.SMALL,
            icon = R.drawable.ev_button_icon,
            iconPosition = ButtonIconPosition.START
        )
        Spacer(modifier = Modifier.height(10.dp))

        EvButton(
            modifier = Modifier,
            onClick = {},
            disabled = false,
            label = stringResource(R.string.change_theme),
            type = ButtonType.SUCCESS,
            size = ButtonSize.SMALL,
            icon = R.drawable.ev_button_icon,
            iconPosition = ButtonIconPosition.START
        )
        Spacer(modifier = Modifier.height(10.dp))

        EvExtendedFAB(
            modifier = Modifier,
            onClick = onClickLanguage,
            label = stringResource(R.string.change_locale),
            expanded = true,
            icon = R.drawable.ev_button_icon,
        )

        var stateVal: Boolean? by remember {
            mutableStateOf(null)
        }
        var emailValidation: Boolean? by remember {
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
        Spacer(modifier = Modifier.height(30.dp))
        EvTextInputField(
            modifier = Modifier,
            onClick = { },
            leadingIcon = R.drawable.ev_ic_search,
            supportingText = when (validation) {
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
        Spacer(Modifier.height(25.dp))
        EvTextInputField(
            modifier = Modifier,
            onClick = { },
            leadingIcon = R.drawable.ev_ic_search,
            supportingText = when (validation) {
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
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    EntriverseTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Greeting(onClickTheme = {}, onClickLanguage = {})
        }
    }
}