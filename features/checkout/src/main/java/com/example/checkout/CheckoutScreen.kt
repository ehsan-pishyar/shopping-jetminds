package com.example.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.designsystem.Background
import com.example.designsystem.R
import com.example.designsystem.components.JetHeading
import com.example.designsystem.components.JetRadioGroup
import com.example.designsystem.components.JetSimpleButton
import com.example.designsystem.components.JetText
import com.example.designsystem.components.JetTextField

@Composable
fun CheckoutScreen(
    viewModel: CheckoutViewModel = hiltViewModel()
) {
    val paymentGatewaysUiState: MainPaymentGatewaysUiState by viewModel.gatewaysUiState.collectAsState()

    CheckoutContent(
        paymentGatewaysUiState = paymentGatewaysUiState
    )
}

@Composable
fun CheckoutContent(
    paymentGatewaysUiState: MainPaymentGatewaysUiState? = null
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ) {
                JetHeading(
                    title = stringResource(id = R.string.heading_checkout),
                    hasCartIcon = true
                )
            }

            // Address
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1.7f),
                verticalArrangement = Arrangement.Top
            ) {
                AddressSection()
                Spacer(modifier = Modifier.height(10.dp))
                Divider()
            }

            // Payment methods
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(4.3f),
                verticalArrangement = Arrangement.Top
            ) {
                JetText(
                    text = "روش های پرداخت",
                    fontSize = 15,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                JetRadioGroup(items = listOf("زرین پال", "درگاه بانک ملت", "پرداخت درب منزل"))
                Spacer(modifier = Modifier.height(10.dp))
                Divider()
            }

            // Checkout
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(4f),
                verticalArrangement = Arrangement.Top
            ) {
                PaymentTotalSection()
            }
        }
    }
}

@Composable
fun AddressSection() {
    JetTextField(
        placeholder = "آدرس خود را وارد نمائید",
        onValueChange = {},
        title = "آدرس",
        link = "انتخاب از روی نقشه",
        linkOnClick = {},
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.location),
                contentDescription = ""
            )
        }
    )
}

@Composable
fun PaymentTotalSection() {
    Column(modifier = Modifier
        .wrapContentSize()
    ) {
        JetText(
            text = "هزینه قابل پرداخت",
            fontSize = 15,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        JetText(
                            text = "جمع کل",
                            fontSize = 14,
                            fontWeight = FontWeight.SemiBold
                        )
                        JetText(
                            text = "53.000 تومان",
                            fontSize = 14,
                            fontWeight = FontWeight.Normal
                        )
                    }

                    Divider()

                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        JetText(
                            text = "هزینه ارسال",
                            fontSize = 14,
                            fontWeight = FontWeight.SemiBold
                        )
                        JetText(
                            text = "15.000 تومان",
                            fontSize = 14,
                            fontWeight = FontWeight.Normal
                        )
                    }

                    Divider()

                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        JetText(
                            text = "مبلغ قابل پرداخت",
                            fontSize = 14,
                            fontWeight = FontWeight.SemiBold
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            JetText(
                                text = "68.000 تومان",
                                fontSize = 14,
                                fontWeight = FontWeight.Normal
                            )
                        }
                    }
                }

                Column {
                    JetSimpleButton(
                        onClick = { /*TODO*/ },
                        text = "پرداخت"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview_CheckoutScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        CheckoutContent()
    }
}