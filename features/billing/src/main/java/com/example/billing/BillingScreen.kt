package com.example.billing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.designsystem.Background
import com.example.designsystem.components.JetHeading
import com.example.designsystem.components.JetTextField

@Composable
fun BillingScreen() {
    BillingContent()
}

@Composable
private fun BillingContent() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ) {
                JetHeading(title = "مشخصات کاربر", hasCartIcon = true)
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(11f)
            ) {
                BillingSection()
            }
        }
    }
}

@Composable
private fun BillingSection() {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.Top
        ) {
            Column(modifier = Modifier
                .wrapContentHeight()
                .weight(1f)
            ) {
                JetTextField(
                    placeholder = "",
                    onValueChange = {},
                    readOnly = true,
                    title = "نام",
                    value = "احسان",
                    height = 50
                )
            }
            Column(modifier = Modifier
                .wrapContentHeight()
                .weight(1f)
            ) {
                JetTextField(
                    placeholder = "",
                    onValueChange = {},
                    readOnly = true,
                    title = "نام خانوادگی",
                    value = "پیش یار",
                    height = 50
                )
            }
        }
        JetTextField(
            placeholder = "",
            onValueChange = {},
            readOnly = true,
            title = "شرکت",
            value = "داناپیوست کوشا",
            height = 50
        )
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.Top
        ) {
            Column(modifier = Modifier
                .wrapContentHeight()
                .weight(1f)
            ) {
                JetTextField(
                    placeholder = "",
                    onValueChange = {},
                    readOnly = true,
                    title = "کشور",
                    value = "ایران",
                    height = 50
                )
            }
            Column(modifier = Modifier
                .wrapContentHeight()
                .weight(1f)
            ) {
                JetTextField(
                    placeholder = "",
                    onValueChange = {},
                    readOnly = true,
                    title = "استان",
                    value = "تهران",
                    height = 50
                )
            }
        }
        JetTextField(
            placeholder = "",
            onValueChange = {},
            readOnly = true,
            title = "شهر",
            value = "تهران",
            height = 50
        )
        JetTextField(
            placeholder = "",
            onValueChange = {},
            readOnly = true,
            title = "آدرس",
            value = "تهران، ایران",
            height = 100,
            maxLines = 2,
            singleLine = false
        )
        JetTextField(
            placeholder = "",
            onValueChange = {},
            readOnly = true,
            title = "تلفن",
            value = "09385241257",
            height = 50
        )
        JetTextField(
            placeholder = "",
            onValueChange = {},
            readOnly = true,
            title = "کد پستی",
            value = "1234567890",
            height = 50
        )
        JetTextField(
            placeholder = "",
            onValueChange = {},
            readOnly = true,
            title = "ایمیل",
            value = "ehsan.pishyar@gmail.com",
            height = 50
        )
    }
}

@Preview
@Composable
fun Preview_BillingScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        BillingContent()
    }
}