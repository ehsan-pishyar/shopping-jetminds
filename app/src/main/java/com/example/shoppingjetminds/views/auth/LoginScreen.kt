package com.example.shoppingjetminds.views.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
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
fun LoginScreen(
    toHomeScreen: () -> Unit,
    toVerificationScreen: () -> Unit
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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            JetText(
                text = "Anaram",
                fontSize = 35,
                textAlign = TextAlign.Center,
                color = BlackColor,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            JetText(
                text = "خوش اومـــــدی",
                fontSize = 16,
                textAlign = TextAlign.Center,
                color = BlackColor
            )

            JetText(
                text = "ورود فقط با یه شماره همراه",
                fontSize = 16,
                textAlign = TextAlign.Center,
                color = BlackColor
            )

            Spacer(modifier = Modifier.height(40.dp))

            JetTextField(
                onValueChange = {
                    phoneNumber = it
                },
                value = phoneNumber,
                placeholder = "شماره همراه خودتو وارد کن",
                singleLine = true,
                maxLines = 1,
                maxLength = 50,
                keyboardType = KeyboardType.Email,
                title = "شماره همراه",
                style = TextStyle(
                    color = LighterGray,
                    fontFamily = Yekanbakh,
                    fontSize = 14.sp
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

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
                text = "دریافت کد",
            )
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen(toHomeScreen = {}) {}
}