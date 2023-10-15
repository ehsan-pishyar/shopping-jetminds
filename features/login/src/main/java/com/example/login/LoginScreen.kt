package com.example.login

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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.designsystem.Background
import com.example.designsystem.BlackColor
import com.example.designsystem.LighterBlack
import com.example.designsystem.Yekanbakh
import com.example.designsystem.components.JetSimpleButton
import com.example.designsystem.components.JetText
import com.example.designsystem.components.JetTextField
import com.example.designsystem.R
import com.example.designsystem.components.SectionSpacer

@Composable
fun LoginScreen(
    viewModel: UserViewModel = hiltViewModel(),
    toHomeScreen: () -> Unit
){
    val tokenUiState: MainUserTokenUiState by viewModel.tokenState.collectAsState()

    LoginContent(
        tokenUiState = tokenUiState,
        viewModel = viewModel,
        toHomeScreen = { toHomeScreen() }
    )
}

@Composable
fun LoginContent(
    tokenUiState: MainUserTokenUiState? = null,
    viewModel: UserViewModel? = null,
    toHomeScreen: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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

            SectionSpacer(40)

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

            SectionSpacer(40)

            JetTextField(
                onValueChange = {
                    username = it
                },
                value = username,
                placeholder = "نام کاربری یا ایمیل",
                singleLine = true,
                maxLines = 1,
                keyboardType = KeyboardType.Number,
                title = "نام کاربری یا ایمیل",
                style = TextStyle(
                    color = LighterBlack,
                    fontFamily = Yekanbakh,
                    fontSize = 14.sp
                ),
                height = 50
            )

            SectionSpacer(10)

            JetTextField(
                onValueChange = {
                    password = it
                },
                value = password,
                placeholder = "رمز عبور خودتو وارد کن",
                singleLine = true,
                maxLines = 1,
                keyboardType = KeyboardType.Number,
                title = "رمز عبور",
                style = TextStyle(
                    color = LighterBlack,
                    fontFamily = Yekanbakh,
                    fontSize = 14.sp
                ),
                height = 50
            )

            SectionSpacer(30)

            JetSimpleButton(
                onClick = {
                    viewModel?.getUserToken(username = username, password = password)
                    when(val tokenState = tokenUiState?.response) {
                        UserTokenUiState.Loading -> {
                            println("Loading Token ...")
                        }
                        is UserTokenUiState.Success -> {
                            println("Token: ${tokenState.token.jwtToken}")
                        }
                        is UserTokenUiState.Error -> {
                            println("Error: ${tokenState.throwable.message}")
                        }
                        else -> Unit
                    }
                },
                text = "ورود",
                height = 50
            )
        }
    }
}

@Preview
@Composable
fun Preview_LoginScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        LoginContent(
            tokenUiState = null,
            toHomeScreen = {}
        )
    }
}