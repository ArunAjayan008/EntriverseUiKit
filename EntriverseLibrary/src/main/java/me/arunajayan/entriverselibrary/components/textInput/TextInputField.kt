package me.arunajayan.entriverselibrary.components.textInput

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.arunajayan.entriverselibrary.Entriverse
import me.arunajayan.entriverselibrary.R
import me.arunajayan.entriverselibrary.components.EntriverseText
import me.arunajayan.entriverselibrary.theme.fonts.InterNormal

@Composable
fun EntriverseTextInputField(
    modifier: Modifier,
    onClick: () -> Unit,
    onValueChange:(String)->Unit,
    leadingIcon: Int? = null,
    leadingIconSize: Dp? = null,
    clearInputEnabled: Boolean = false,
    placeHolderText: String? = null,
    label: String? = null,
    supportingText: String? = null,
    textColor: Color,
    inputValue:String?=null,
    validateState: Boolean? = null
) {
    var inputValue  by remember {
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

    borderColor = if (validateState == false) {
        Entriverse.colors.referenceColors.errorHover
    } else {
        Entriverse.colors.referenceColors.placeholderText
    }

    OutlinedTextField(
        value = inputValue?:"",
        onValueChange = {
            inputValue = it
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
                EntriverseText(
                    text = label,
                )
            }
        },
        placeholder = {
            placeHolderText?.let {
                EntriverseText(
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
            if (clearInputEnabled && inputValue?.isNotEmpty() == true && validateState==null) {
                Icon(
                    painter = painterResource(id = R.drawable.entriverse_close_icon),
                    modifier = Modifier
                        .size(Entriverse.entriverseDimens.referenceDimens.spacingXxl)
                        .clickable(enabled = true, onClick = {
                            inputValue = ""
                        }),
                    contentDescription = "Clear input Icon",
                    tint = Entriverse.colors.referenceColors.secondaryIcon
                )
            }
            if(validateState !=null){
                val icon =
                    if (validateState)
                        R.drawable.button_icon
                    else
                        R.drawable.entriverse_ic_text_validation_error
                Icon(
                    painter = painterResource(id = icon),
                    modifier = Modifier
                        .size(Entriverse.entriverseDimens.referenceDimens.spacingXxl),
                    contentDescription = "Clear input Icon",
                    tint = Entriverse.palette.red700
                )
            }
        },
        supportingText = {
            supportingText?.let {
                EntriverseText(
                    text = supportingText,
                    style = Entriverse.typography.display1,
                    color = Entriverse.colors.referenceColors.placeholderText
                )

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
        val input = "abc"
        EntriverseTextInputField(
            modifier = Modifier,
            onClick = { },
            textColor = Entriverse.colors.referenceColors.placeholderText,
            leadingIcon = R.drawable.entriverse_ic_search,
            supportingText = "Enter name",
            clearInputEnabled = false,
            validateState = false,
            label = "dflksdjfl",
            onValueChange = {}
        )
    }
}