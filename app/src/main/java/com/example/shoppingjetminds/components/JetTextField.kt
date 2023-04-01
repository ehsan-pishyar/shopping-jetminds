package com.example.shoppingjetminds.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppingjetminds.ui.theme.BlackColor
import com.example.shoppingjetminds.ui.theme.Primary
import com.example.shoppingjetminds.ui.theme.Yekanbakh

@Composable
fun JetTextField(
    modifier: Modifier = Modifier,
    title: String = "",
    height: Int = 66,
    value: String = "",
    placeholder: String,
    style: TextStyle = TextStyle(
        color = MaterialTheme.colors.onBackground,
        fontSize = 14.sp,
        fontFamily = Yekanbakh,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Start
    ),
    singleLine: Boolean = true,
    maxLines: Int = 1,
    shape: Int = 100,
    readOnly: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    isPasswordVisible: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit
){
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {

        if (title.isNotEmpty()) {
            JetText(
                text = title,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                fontFamily = Yekanbakh,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14,
                color = BlackColor
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .height(height.dp)
                .semantics {
                    testTag = "Text field"
                },
            value = value,
            onValueChange = { onValueChange(it) },
            shape = RoundedCornerShape(shape.dp),
            maxLines = maxLines,
            textStyle = style,
            readOnly = readOnly,
            placeholder = {
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = placeholder,
                    style = style,
                )
            },
//            if (onValueChange.toString().length > maxLength) {
//                isError = error
//            } else {
//                isError = ""
//            }
//            isError = error != "",
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            visualTransformation = if (!isPasswordVisible && isPasswordToggleDisplayed) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            singleLine = singleLine,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                cursorColor = BlackColor,
                focusedIndicatorColor = Primary,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
    }
}

@Composable
@Preview
fun PreviewJetTextField() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        JetTextField(
            title = "عنوان",
            placeholder = "نگهدارنده عنوان",
            onValueChange = {}
        )
    }
}