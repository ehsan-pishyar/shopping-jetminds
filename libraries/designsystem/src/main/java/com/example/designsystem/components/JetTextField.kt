package com.example.designsystem.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
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
import com.example.designsystem.BlackColor
import com.example.designsystem.LighterGray
import com.example.designsystem.Primary
import com.example.designsystem.R
import com.example.designsystem.Yekanbakh

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JetTextField(
    modifier: Modifier = Modifier,
    title: String = "",
    height: Int = 56,
    value: String = "",
    placeholder: String,
    style: TextStyle = TextStyle(
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 13.sp,
        fontFamily = Yekanbakh,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Start
    ),
    link: String = "",
    linkOnClick: () -> Unit = {},
    singleLine: Boolean = true,
    maxLines: Int = 1,
    shape: Int = 8,
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

        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            AnimatedVisibility(visible = title.isNotEmpty()) {
                JetText(
                    text = title,
                    modifier = modifier.padding(horizontal = 10.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14,
                    textAlign = TextAlign.Start,
                    maxLines = 1
                )
            }

            AnimatedVisibility(visible = link.isNotEmpty()) {
                TextButton(
                    onClick = { linkOnClick() },
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.height(18.dp)
                ) {
                    JetText(
                        text = link,
                        modifier = modifier.padding(horizontal = 10.dp),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 13,
                        color = Primary,
                        textAlign = TextAlign.End,
                        maxLines = 1
                    )
                }
            }
        }

        AnimatedVisibility(visible = title.isNotEmpty()) {
            Spacer(modifier = Modifier.height(5.dp))
        }

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
                JetText(
                    modifier = modifier.fillMaxWidth(),
                    text = placeholder,
                    color = LighterGray
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
                containerColor = Color.White,
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
@Preview(showBackground = true)
fun Preview_JetTextField() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        JetTextField(
            title = "عنوان",
            placeholder = "نگهدارنده عنوان",
            onValueChange = {},
            link = "تغییر آدرس",
            leadingIcon = {
                Image(painter = painterResource(id = R.drawable.home), contentDescription = null)
            },
            trailingIcon = {
                Image(painter = painterResource(id = R.drawable.cart), contentDescription = null)
            }
        )
    }
}