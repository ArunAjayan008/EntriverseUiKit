package me.arunajayan.entriverseui

import android.content.Context
import android.content.Intent
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
import me.arunajayan.entriverselibrary.theme.EntriverseTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SetAppTheme(onClick = {
                setLocale(this, "ml")
                startActivity(Intent(this, MainActivity::class.java))
            })
        }
    }
}

fun setLocale(context: Context, languageCode: String) {
    val locale = Locale(languageCode)
    Locale.setDefault(locale)
    val configuration = Configuration(context.resources.configuration)
    configuration.setLocale(locale)
    context.resources.updateConfiguration(configuration, context.resources.displayMetrics)
}

@Composable
fun SetAppTheme(onClick: () -> Unit) {
    var darkTheme by remember { mutableStateOf(true) }

    EntriverseTheme(darkTheme = darkTheme) {
        Surface {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Entriverse.colors.referenceColors.primaryText)
                    .padding(top = 120.dp)
            ) {
                Greeting(
                    onClick =
//                    darkTheme = !darkTheme
                    onClick
                )
            }
        }
    }
}

@Composable
fun Greeting(onClick: () -> Unit) {
    Column {
        EntriverseText(
            text = stringResource(R.string.infoText),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Entriverse.colors.referenceColors.backgroundDefault,
            style = Entriverse.typography.buttonDefault,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(50.dp))
        EntriverseButton(
            onClick = onClick,
            label = stringResource(R.string.are_you_sure),
            fillMaxWidth = false,
            type = ButtonType.FILLED
        )
    }
}

fun setAppLang(context: Context) {
    val locale = Locale("ml")
    Locale.setDefault(locale)
    val config = context.resources.configuration
    config.setLocale(locale)
    context.createConfigurationContext(config)
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    EntriverseTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Greeting(onClick = {})
        }
    }
}