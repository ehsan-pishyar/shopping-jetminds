package com.example.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
    viewModel: LoginViewModel = hiltViewModel(),
    toHomeScreen: () -> Unit
){
    val wordpressUserUiState: MainWordpressUserUiState by viewModel.wordpressUserUiState.collectAsState()

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var token by remember { mutableStateOf("") }

    var testText by remember { mutableStateOf("") }

    var loaderState by remember { mutableStateOf(false) }

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

            LogoSection()
            SectionSpacer(40)
            WelcomeSection()
            SectionSpacer(40)
            InputFieldsSection(
                username = username,
                password = password,
                onUsernameChange = { username = it },
                onPasswordChange = { password = it }
            )

            SectionSpacer(30)

//            when (val tokenState = tokenUiState.response) {
//                UserTokenUiState.Loading -> {
//                    println("*** Token Loading ...")
//                }
//                is UserTokenUiState.Success -> {
//                    token = tokenState.userTokenResponse.jwtToken!!
//                    viewModel.saveTokenToDataStore(token = token)
//                    viewModel.validateToken()
//                }
//                is UserTokenUiState.Error -> {
//                    println("*** Token Error: ${tokenState.throwable.message}")
//                }
//            }

            when (val wordpressUserState = wordpressUserUiState.response) {
                WordpressUserUiState.Loading -> {
                    println("*** Validation Token ...")
                    viewModel.getWordpressUser(token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjEwLCJuYW1lIjoiY3VzdG9tZXIiLCJpYXQiOjE2OTkzODk4MjAsImV4cCI6MTg1NzA2OTgyMH0.2AXy6tRzvHi4sKX_bTGqNwpBWy7oM1xkXUJrIcNj2yA")
                }
                is WordpressUserUiState.Success -> {
                    println("*** Validation Token was successful: ${wordpressUserState.wordpressUser.name}")
                    testText = wordpressUserState.wordpressUser.name!!
                }
                is WordpressUserUiState.Error -> {
                    println("*** Validation Token was error: ${wordpressUserState.throwable.message}")
                }
            }

            JetText(text = testText)

            JetSimpleButton(
                onClick = {
//                    viewModel.getUserToken(username = username, password = password)
//                          viewModel.validateToken()
                },
                text = "ورود",
                height = 50,
                hasLoader = false
            )
        }
    }
}

@Composable
private fun LogoSection() {
    Image(
        painter = painterResource(id = R.drawable.jetminds_logo),
        contentDescription = null,
        modifier = Modifier.width(200.dp)
    )
}

@Composable
private fun WelcomeSection() {
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
}

@Composable
fun InputFieldsSection(
    username: String,
    password: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit
) {
    JetTextField(
        onValueChange = onUsernameChange,
        value = username,
        placeholder = "نام کاربری یا ایمیل",
        singleLine = true,
        maxLines = 1,
        keyboardType = KeyboardType.Text,
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
        onValueChange = onPasswordChange,
        value = password,
        placeholder = "رمز عبور خودتو وارد کن",
        singleLine = true,
        maxLines = 1,
        keyboardType = KeyboardType.Text,
        title = "رمز عبور",
        style = TextStyle(
            color = LighterBlack,
            fontFamily = Yekanbakh,
            fontSize = 14.sp
        ),
        height = 50
    )
}