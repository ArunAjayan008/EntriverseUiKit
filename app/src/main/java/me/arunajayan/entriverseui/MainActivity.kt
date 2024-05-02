package me.arunajayan.entriverseui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import me.arunajayan.entriverseui.ui.theme.EntriverseUITheme
import kotlin.reflect.KVisibility

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EntriverseTheme() {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Entriverse.colors.referenceColors.backgroundDefault)
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column {
        EntriverseText(
            text = "Arun Ajayan",
            modifier = Modifier,
            color = Entriverse.colors.referenceColors.backgroundDefault,
            fontSize = 16.sp,
        )

        EntriverseButton(
            onClick = { },
            label = "Click Now",
            fillMaxWidth = false,
            type = ButtonType.FILLED
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
            Greeting()
        }
    }
}