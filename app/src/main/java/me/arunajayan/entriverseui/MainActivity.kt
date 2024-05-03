package me.arunajayan.entriverseui

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.flamingo.Flamingo
import com.flamingo.components.SkeletonShape
import com.flamingo.components.topappbar.EdgeItem
import com.flamingo.loremIpsum
import com.flamingo.roboto.initRobotoTypography
import com.flamingo.theme.FlamingoIcon
import com.flamingo.theme.FlamingoTheme
import com.flamingo.theme.typography.FlamingoTypography
import me.arunajayan.entriverselibrary.Entriverse
import me.arunajayan.entriverselibrary.components.ButtonType
import me.arunajayan.entriverselibrary.components.EntriverseButton
import me.arunajayan.entriverselibrary.components.EntriverseText
import me.arunajayan.entriverselibrary.theme.EntriverseTheme
import me.arunajayan.entriverselibrary.theme.colors.EntriverseColors
import me.arunajayan.entriverselibrary.theme.colors.ReferenceColors
import me.arunajayan.entriverselibrary.theme.typography.initTypography
import me.arunajayan.entriverseui.ui.theme.EntriverseUITheme
import java.util.Locale
import kotlin.reflect.KVisibility

class MainActivity : ComponentActivity() {
    val viewmodel: EntriverseViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
//        initTypography()
//        setAppLang()
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            println("chkrsdfj ${viewmodel.a}")
            SetAppTheme(onClick = {
                setLocale(this, "ml")
                viewmodel.a = "new"
                startActivity(Intent(this, MainActivity::class.java))
            })
        }
    }
//
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
    val context = LocalContext.current

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