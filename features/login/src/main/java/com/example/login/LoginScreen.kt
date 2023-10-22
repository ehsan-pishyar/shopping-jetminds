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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    viewModel: UserViewModel = hiltViewModel(),
    toHomeScreen: () -> Unit
){
    val tokenUiState: MainUserTokenUiState by viewModel.tokenState.collectAsState()
    val validateTokenUiState: MainValidateTokenUiState by viewModel.validateTokenUiState.collectAsState()

    LoginContent(
        tokenUiState = tokenUiState,
        viewModel = viewModel,
        toHomeScreen = { toHomeScreen() }
    )
}

@Composable
fun LoginContent(
    tokenUiState: MainUserTokenUiState? = null,
    validateTokenUiState: MainValidateTokenUiState? = null,
    viewModel: UserViewModel? = null,
    toHomeScreen: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val coroutineScope = CoroutineScope(SupervisorJob())

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
                onValueChange = {
                    password = it
                },
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

            SectionSpacer(30)

            JetSimpleButton(
                onClick = {
                    val job1 = coroutineScope.async {
                        viewModel?.getUserToken(username = username, password = password)
                    }
                    val job2 = coroutineScope.async {
                        when(val tokenState = tokenUiState?.response) {
                            UserTokenUiState.Loading -> {
                                println("Loading Token ...")
                            }
                            is UserTokenUiState.Success -> {
                                viewModel?.addToken(token = tokenState.token.jwtToken)
                            }
                            is UserTokenUiState.Error -> {
                                println("Token Error: ${tokenState.throwable.message}")
                            }
                            else -> Unit
                        }
                    }
                    val job3 = coroutineScope.async {
//                        viewModel?.validateToken()
                        toHomeScreen()
//                        delay(1000)
                    }
//                    val job4 = coroutineScope.async {
//                        when(val validateTokenState = validateTokenUiState?.response) {
//                            ValidateTokenUiState.Loading -> {
//                                println("Validating Token ...")
//                            }
//                            is ValidateTokenUiState.Success -> {
//                                toHomeScreen()
//                            }
//                            is ValidateTokenUiState.Error -> {
//                                println("Validation Error: ${validateTokenState.throwable.message}")
//                            }
//                            else -> Unit
//                        }
//                        delay(1000)
//                    }

                    coroutineScope.launch {
                        awaitAll(job1, job2, job3)
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