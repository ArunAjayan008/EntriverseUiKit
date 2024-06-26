package entriverse.shared.components.textInput

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import entriverse.shared.Entriverse
import entriverse.shared.components.EvText
import me.arunajayan.entriverselibrary.R

@Composable
fun EvTextInputField(
    modifier: Modifier,
    onClick: () -> Unit,
    onValueChange:(String)->Unit,
    leadingIcon: Int? = null,
    leadingIconSize: Dp? = null,
    clearInputEnabled: Boolean = false,
    placeHolderText: String? = null,
    label: String? = null,
    supportingText: String? = null,
    supportingTextColor: Color? = null,
    textColor: Color,
    inputValue:String?=null,
    validateState: Boolean? = null,
    characterLimit:Int?=null
) {
    var textInput  by remember {
        mutableStateOf(
            inputValue
        )
    }
    var focusedState by remember {
        mutableStateOf(false)
    }

    val defaultText = Entriverse.colors.referenceColors.placeholderText
    var borderColor:Color by remember {
        mutableStateOf(defaultText)
    }

    borderColor = when (validateState) {
        true -> Entriverse.colors.referenceColors.successContainer
        false -> Entriverse.colors.referenceColors.errorHover
        else -> Entriverse.colors.referenceColors.placeholderText
    }

    OutlinedTextField(
        value = textInput?:"",
        onValueChange = {
            textInput = it
            onValueChange(it)
        },
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.Unspecified,
                RoundedCornerShape(Entriverse.entriverseDimens.referenceDimens.spacingS)
            )
            .onFocusChanged {
                focusedState = it.isFocused
            },
        enabled = true,
        label = {
            label?.let {
                EvText(
                    text = label,
                )
            }
        },
        placeholder = {
            placeHolderText?.let {
                EvText(
                    text = placeHolderText,
                    style = Entriverse.typography.buttonDefault,
                    color = Entriverse.colors.referenceColors.placeholderText
                )
            }
        },
        leadingIcon = {
            leadingIcon?.let {
                Icon(
                    painter = painterResource(id = leadingIcon),
                    modifier = Modifier.size(
                        leadingIconSize ?: Entriverse.entriverseDimens.referenceDimens.spacingXxl
                    ),
                    contentDescription = "Button Icon",
                    tint = textColor
                )
            }
        },
        trailingIcon = {
            if (clearInputEnabled && textInput?.isNotEmpty() == true && validateState==null) {
                Icon(
                    painter = painterResource(id = R.drawable.ev_close_icon),
                    modifier = Modifier
                        .size(Entriverse.entriverseDimens.referenceDimens.spacingXxl)
                        .clickable(enabled = true, onClick = {
                            textInput = ""
                        }),
                    contentDescription = "Clear input Icon",
                    tint = Entriverse.colors.referenceColors.secondaryIcon
                )
            }
            if(validateState != null ){
                val icon =
                    if (validateState)
                        R.drawable.ev_success_icon
                    else
                        R.drawable.ev_ic_text_validation_error
                Icon(
                    painter = painterResource(id = icon),
                    modifier = Modifier
                        .size(Entriverse.entriverseDimens.referenceDimens.spacingXxl),
                    contentDescription = "Clear input Icon",
                    tint = if (validateState) Entriverse.palette.green900 else Entriverse.palette.red300
                )
            }
        },
        supportingText = {
            Row(modifier=Modifier.fillMaxWidth()) {
                supportingText?.let {
                    EvText(
                        text = supportingText,
                        style = Entriverse.typography.display1,
                        color = supportingTextColor ?: Entriverse.colors.referenceColors.placeholderText,
                        modifier = Modifier.weight(1f)
                    )
                }
                characterLimit?.let { charLimit ->
                    EvText(
                        text = "${textInput?.length}/$charLimit",
                        style = Entriverse.typography.display1,
                        color = Entriverse.colors.referenceColors.placeholderText,
                    )
                }
            }
        },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Entriverse.colors.referenceColors.blueIcon,
            unfocusedBorderColor = borderColor,
            focusedTextColor =    Entriverse.colors.referenceColors.invertedText,
            unfocusedLabelColor = Entriverse.colors.referenceColors.placeholderText,
            focusedLabelColor = Entriverse.colors.referenceColors.entriBlue,
            disabledTextColor = Entriverse.colors.referenceColors.disabledText
        )
    )

}


@Preview(showSystemUi = true)
@Composable
fun OutlineTextPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {
        EvTextInputField(
            modifier = Modifier,
            onClick = { },
            textColor = Entriverse.colors.referenceColors.placeholderText,
            leadingIcon = R.drawable.ev_ic_search,
            supportingText = "Enter name",
            clearInputEnabled = false,
            validateState = false,
            label = "dflksdjfl",
            onValueChange = {},
        )
    }
}