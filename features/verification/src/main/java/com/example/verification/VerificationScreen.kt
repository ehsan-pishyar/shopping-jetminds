package com.example.verification

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
import com.example.designsystem.Background
import com.example.designsystem.BlackColor
import com.example.designsystem.LighterBlack
import com.example.designsystem.R
import com.example.designsystem.Yekanbakh
import com.example.designsystem.components.JetSimpleButton
import com.example.designsystem.components.JetText
import com.example.designsystem.components.JetTextField

@Composable
fun VerificationScreen() {

    var number1 by remember{ mutableStateOf("") }
    var number2 by remember{ mutableStateOf("") }
    var number3 by remember{ mutableStateOf("") }
    var number4 by remember{ mutableStateOf("") }
    var numbers by remember{ mutableStateOf("$number1$number2$number3$number4") }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ) {
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
                    text = "رمز 4 رقمی که دریافت کردی رو وارد کن",
                    fontSize = 16,
                    textAlign = TextAlign.Center,
                    color = BlackColor,
                    maxLines = 1,
                    lineHeight = 0.0
                )

                Spacer(modifier = Modifier.height(40.dp))

                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)) {
                    JetTextField(
                        onValueChange = {
                            number1 = it
                        },
                        value = number1,
                        placeholder = "1",
                        singleLine = true,
                        maxLines = 1,
                        keyboardType = KeyboardType.Number,
                        style = TextStyle(
                            color = LighterBlack,
                            fontFamily = Yekanbakh,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                        shape = 8,
                        modifier = Modifier.weight(1f).height(75.dp)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    JetTextField(
                        onValueChange = {
                            number2 = it
                        },
                        value = number2,
                        placeholder = "2",
                        singleLine = true,
                        maxLines = 1,
                        keyboardType = KeyboardType.Number,
                        style = TextStyle(
                            color = LighterBlack,
                            fontFamily = Yekanbakh,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                        shape = 8,
                        modifier = Modifier.weight(1f).height(75.dp)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    JetTextField(
                        onValueChange = {
                            number3 = it
                        },
                        value = number3,
                        placeholder = "3",
                        singleLine = true,
                        maxLines = 1,
                        keyboardType = KeyboardType.Number,
                        style = TextStyle(
                            color = LighterBlack,
                            fontFamily = Yekanbakh,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                        shape = 8,
                        modifier = Modifier.weight(1f).height(75.dp)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    JetTextField(
                        onValueChange = {
                            number4 = it
                        },
                        value = number4,
                        placeholder = "4",
                        singleLine = true,
                        maxLines = 1,
                        keyboardType = KeyboardType.Number,
                        style = TextStyle(
                            color = LighterBlack,
                            fontFamily = Yekanbakh,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                        shape = 8,
                        modifier = Modifier.weight(1f).height(75.dp)
                    )
                }

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
                    text = "ورود"
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewVerificationScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ) {
        VerificationScreen()
    }
}