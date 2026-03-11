package entriverse.shared.components.switch

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.Alignment

@Preview
@Composable
fun SwitchPreview_AllStates() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Regular, Inactive")
        var checked1 by remember { mutableStateOf(false) }
        EvSwitch(
            props = SwitchProps(checked = checked1, size = SwitchSize.Regular),
            onCheckedChange = { checked1 = it }
        )

        Text("Regular, Active, Icon")
        var checked2 by remember { mutableStateOf(true) }
        EvSwitch(
            props = SwitchProps(checked = checked2, hasIcon = true, size = SwitchSize.Regular),
            onCheckedChange = { checked2 = it }
        )

        Text("Small, Inactive, Disabled")
        EvSwitch(
            props = SwitchProps(checked = false, enabled = false, size = SwitchSize.Small),
            onCheckedChange = null
        )

        Text("Small, Active, Icon, Disabled")
        EvSwitch(
            props = SwitchProps(checked = true, hasIcon = true, enabled = false, size = SwitchSize.Small),
            onCheckedChange = null
        )
    }
} 