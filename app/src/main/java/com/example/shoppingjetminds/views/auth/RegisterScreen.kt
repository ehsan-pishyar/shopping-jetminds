package com.example.shoppingjetminds.views.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppingjetminds.components.JetButton
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.components.JetTextField
import com.example.shoppingjetminds.ui.theme.*

@Composable
fun RegisterScreen(
    toLoginScreen: () -> Unit,
    toHomeScreen: () -> Unit
){

    var phoneNumber by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JetText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "سلام دوباره!",
                fontWeight = FontWeight.Bold,
                fontSize = 25,
                textAlign = TextAlign.Center,
                color = BlackColor
            )

            Spacer(modifier = Modifier.height(10.dp))

            JetText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "خوش اومـــــدی",
                fontSize = 16,
                textAlign = TextAlign.Center,
                color = BlackColor
            )

            JetText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "دلمون برات تنگ شده بود",
                fontSize = 16,
                textAlign = TextAlign.Center,
                color = BlackColor
            )

            Spacer(modifier = Modifier.height(30.dp))

            JetTextField(
                onValueChange = {
                    phoneNumber = it
                },
                value = phoneNumber,
                placeholder = "شماره تماس خودتو وارد کن",
                singleLine = true,
                maxLines = 1,
                maxLength = 50,
                keyboardType = KeyboardType.Email,
                title = "شماره تماس",
                style = TextStyle(
                    color = LighterGray,
                    fontFamily = Yekanbakh,
                    fontSize = 14.sp
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {  }
            ) {
                JetText(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "رمز عبورتو فراموش کردی؟",
                    textAlign = TextAlign.End,
                    fontSize = 14,
                    color = Primary
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            JetButton(
                onClick = {
//                    viewModel.getUserByEmailAndPassword(email, password)
//                    if (state.loading) {
//                        // Indicator on button
//                    } else if (state.error == null) {
//                        // Snack bar
//                    } else if (state.success) {
//                        toDashboardScreen()
//                    }
                },
                width = 0,
                text = "ورود",
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                JetText(
                    modifier = Modifier
                        .wrapContentWidth(),
                    text = "هنوز فروشنده نشدی؟",
                    fontSize = 14,
                    color = BlackColor
                )

                TextButton(
                    onClick = {  },
                ) {
                    JetText(
                        modifier = Modifier
                            .wrapContentWidth(),
                        text = "الان ثبت نام کن",
                        fontSize = 14,
                        color = Primary
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewRegisterScreen() {
    RegisterScreen(toLoginScreen = {}) {}
}