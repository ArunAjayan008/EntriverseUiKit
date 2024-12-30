package entriverse.shared.components.textInput

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import entriverse.shared.Entriverse
import entriverse.shared.components.EvText
import me.entri.entriverseui.R

@Composable
fun EvTextInputField(
    modifier: Modifier,
    onClick: () -> Unit,
    onValueChange: (String) -> Unit,
    leadingIcon: Int? = null,
    isEnabled: Boolean = true,
    clearInputEnabled: Boolean = false,
    placeHolderText: String? = null,
    label: String? = null,
    supportingText: String? = null,
    inputValue: String? = null,
    validateState: Boolean? = null,
    characterLimit: Int? = null
) {
    var textInput by remember {
        mutableStateOf(
            inputValue
        )
    }

    var focusedState by remember {
        mutableStateOf(false)
    }

    val enabledState by remember {
        mutableStateOf(isEnabled)
    }

    val scrollState = rememberScrollState()
    val textFieldColors = Entriverse.colors.componentColors
    OutlinedTextField(
        value = textInput ?: "",
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
                if (it.isFocused) {
                    println("compose focused ${it.isFocused}")
                } else {
                    println("compose unfocus ${it.isFocused}")
                }
            }
            .verticalScroll(scrollState),
        enabled = enabledState,
        label = {
            label?.let {
                EvText(
                    text = label,
/*
                    color = with(textFieldColors) {
                        when {
                            enabledState && focusedState && validateState == true -> {
                                println("compose success")
                                labelColors.labelTextSuccess
                            }

                            enabledState && focusedState && validateState == false -> {
                                println("compose error")
                                labelColors.labelTextError
                            }

                            enabledState && focusedState -> {
                                println("compose focused")
                                labelColors.labelTextFocused
                            }

                            enabledState -> {
                                println("compose active")
                                inputColors.inputTextActive
                            }

                            else -> {
                                println("compose placeholder")
                                inputColors.inputTextPlaceholder
                            }
                        }
                    }
*/
                )
            }
        },
        placeholder = {
            placeHolderText?.let {
                EvText(
                    text = placeHolderText,
                    style = Entriverse.typography.bodyDefaultRegular,
                    color = textFieldColors.inputColors.inputTextPlaceholder
                )
            }
        },
        leadingIcon = {
            leadingIcon?.let {
                Icon(
                    painter = painterResource(id = leadingIcon),
                    modifier = Modifier.size(
                        Entriverse.entriverseDimens.referenceDimens.spacingXxl
                    ),
                    contentDescription = "Button Icon",
                    tint = if (enabledState)
                        textFieldColors.iconColors.leadingIcon
                    else
                        textFieldColors.iconColors.leadingIconPlaceholder
                )
            }
        },
        trailingIcon = {
            if (clearInputEnabled && textInput?.isNotEmpty() == true && validateState == null) {
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
            if (validateState != null) {
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
                    tint = with(textFieldColors) {
                        if (validateState) iconColors.trailingIconSuccess
                        else iconColors.trailingIconError
                    }
                )
            }
        },
        supportingText = {
            Row(modifier = Modifier.fillMaxWidth()) {
                supportingText?.let {
                    EvText(
                        text = supportingText,
                        style = Entriverse.typography.captionDefaultRegular,
                        color = when (validateState) {
                            true -> textFieldColors.supportingTextColors.supportingTextSuccess
                            false -> textFieldColors.supportingTextColors.supportingTextError
                            else -> textFieldColors.supportingTextColors.supportingText
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
                characterLimit?.let { charLimit ->
                    EvText(
                        text = "${textInput?.length ?: "0"}/$charLimit",
                        style = Entriverse.typography.captionDefaultRegular,
                        color = textFieldColors.supportingTextColors.supportingText,
                    )
                }
            }
        },
        singleLine = false,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = when (validateState) {
                true -> textFieldColors.inputColors.inputContainerSuccess
                false -> textFieldColors.inputColors.inputContainerError
                else -> textFieldColors.inputColors.inputContainerFocused
            },
            unfocusedBorderColor = textFieldColors.inputColors.inputContainerOutline,
            focusedTextColor = textFieldColors.inputColors.inputTextActive,
            unfocusedLabelColor = textFieldColors.inputColors.inputTextActive,
            focusedLabelColor = with(textFieldColors) {
                when {
                    enabledState && focusedState && validateState == true -> {
                        println("aruncompose success")
                        labelColors.labelTextSuccess
                    }

                    enabledState && focusedState && validateState == false -> {
                        println("aruncompose error")
                        labelColors.labelTextError
                    }

                    enabledState && focusedState -> {
                        println("aruncompose focused")
                        labelColors.labelTextFocused
                    }

                    enabledState -> {
                        println("aruncompose active")
                        inputColors.inputTextActive
                    }

                    else -> {
                        println("aruncompose placeholder")
                        inputColors.inputTextPlaceholder
                    }
                }
            },
            disabledTextColor = textFieldColors.inputColors.inputTextPlaceholder,
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
            leadingIcon = R.drawable.ev_ic_search,
            supportingText = "Enter name",
            clearInputEnabled = false,
            validateState = false,
            label = "dflksdjfl",
            onValueChange = {},
        )
    }
}