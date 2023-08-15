package com.example.shoppingjetminds.views.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.designsystem.Background
import com.example.designsystem.R
import com.example.designsystem.components.JetHeading
import com.example.designsystem.components.JetTextField

@Composable
fun UserInformationScreen() {
    UserInformationContent()
}

@Composable
private fun UserInformationContent() {
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
                .weight(2f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(shape = RoundedCornerShape(50.dp))
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(9f)
            ) {
                InformationSection()
            }
        }
    }
}

@Composable
private fun InformationSection() {
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
            title = "آدرس ایمیل",
            value = "ehsan.pishyar@gmail.com",
            height = 50
        )
        JetTextField(
            placeholder = "",
            onValueChange = {},
            readOnly = true,
            title = "بیوگرافی",
            value = "برنامه نویس اندروید و طراح وب با وردپرس",
            singleLine = false,
            maxLines = 4,
            height = 200
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
                    title = "آدرس وب سایت",
                    value = "https://jetminds.ir",
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
                    title = "تاریخ عضویت",
                    value = "1401/04/31",
                    height = 50
                )
            }
        }
        JetTextField(
            placeholder = "",
            onValueChange = {},
            readOnly = true,
            title = "آدرس",
            value = "تهران، ایران",
            height = 50
        )
    }
}

@Preview
@Composable
private fun Preview_UserInformationScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        UserInformationContent()
    }
}