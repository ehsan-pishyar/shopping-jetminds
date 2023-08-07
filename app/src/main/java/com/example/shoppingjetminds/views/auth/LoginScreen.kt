package com.example.shoppingjetminds.views.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.components.JetSimpleButton
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

            Image(
                painter = painterResource(id = R.drawable.jetminds_logo),
                contentDescription = null,
                modifier = Modifier.width(200.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            JetText(
                text = "خوش اومـــــدی",
                fontSize = 16,
                textAlign = TextAlign.Center,
                color = BlackColor,
                maxLines = 1,
                lineHeight = 0.0
            )

            JetText(
                text = "ورود فقط با یه شماره همراه",
                fontSize = 16,
                textAlign = TextAlign.Center,
                color = BlackColor,
                maxLines = 1,
                lineHeight = 0.0
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
                keyboardType = KeyboardType.Number,
                title = "شماره همراه",
                style = TextStyle(
                    color = LighterBlack,
                    fontFamily = Yekanbakh,
                    fontSize = 14.sp
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            JetSimpleButton(
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
                text = "دریافت کد"
            )
        }
    }
}

@Composable
fun LoginContent(
    phoneNumber: String,
    toHomeScreen: () -> Unit,
    toVerificationScreen: () -> Unit
) {

}

@Preview
@Composable
fun Preview_LoginScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        LoginScreen(toHomeScreen = {}) {}
    }
}