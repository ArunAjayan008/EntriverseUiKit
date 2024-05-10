package me.arunajayan.entriverseui

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
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
import me.arunajayan.entriverselibrary.Entriverse
import me.arunajayan.entriverselibrary.components.button.ButtonType
import me.arunajayan.entriverselibrary.components.button.EntriverseButton
import me.arunajayan.entriverselibrary.components.EntriverseText
import me.arunajayan.entriverselibrary.components.button.ButtonIconPosition
import me.arunajayan.entriverselibrary.components.button.ButtonSize
import me.arunajayan.entriverselibrary.components.extendedFab.EntriverseExtendedFAB
import me.arunajayan.entriverselibrary.components.textInput.EntriverseTextInputField
import me.arunajayan.entriverselibrary.theme.EntriverseTheme
import me.arunajayan.entriverselibrary.theme.UserLocale
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
    var darkTheme by remember { mutableStateOf(false) }
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
        Surface(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Entriverse.colors.referenceColors.primaryText)
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
        EntriverseText(
            text = stringResource(R.string.infoText),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Entriverse.colors.referenceColors.backgroundDefault,
            style = Entriverse.typography.buttonDefault,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(50.dp))
        EntriverseButton(
            modifier = Modifier,
            onClick = onClickTheme,
            disabled = false,
            label = stringResource(R.string.change_theme),
            type = ButtonType.SECONDARY_OUTLINED,
            size = ButtonSize.REGULAR,
            icon = me.arunajayan.entriverselibrary.R.drawable.button_icon,
            iconPosition = ButtonIconPosition.START
        )
        Spacer(modifier = Modifier.height(50.dp))
        EntriverseExtendedFAB(
            modifier = Modifier,
            onClick = onClickLanguage,
            label = stringResource(R.string.change_locale),
            expanded = true,
            icon = me.arunajayan.entriverselibrary.R.drawable.button_icon,
            buttonColor = Entriverse.palette.fabColor,
            textColor = Entriverse.palette.brown800
        )
        Spacer(modifier = Modifier.height(50.dp))
        EntriverseTextInputField(
            modifier = Modifier,
            onClick = { },
            textColor = Entriverse.colors.referenceColors.placeholderText,
            leadingIcon = me.arunajayan.entriverselibrary.R.drawable.entriverse_ic_search,
            supportingText = stringResource(R.string.enter_name),
            clearInputEnabled = true,
            label = stringResource(id = R.string.full_name),
            onValueChange = {}
        )
        var stateVal  by remember {
            mutableStateOf(
                true
            )
        }
        fun checkstate(state:String){
            if(state.length>3){
                stateVal=false
            }
        }
        EntriverseTextInputField(
            modifier = Modifier,
            onClick = { },
            textColor = Entriverse.colors.referenceColors.placeholderText,
            leadingIcon = me.arunajayan.entriverselibrary.R.drawable.entriverse_ic_search,
            supportingText = "Enter name",
            clearInputEnabled = true,
            validateState = stateVal,
            label = stringResource(id = R.string.full_name),
            onValueChange = {
                checkstate(it)
            }
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