package com.example.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.designsystem.R
import com.example.designsystem.RedColor

@Composable
fun JetHeading(
    title: String,
    hasCartIcon: Boolean,
    toCartScreen: () -> Unit = {},
    cartItemSize: Int = 0
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(40.dp)
        .background(Color.Transparent)
    ) {

        Box(modifier = Modifier
            .background(Color.Transparent)
            .fillMaxHeight()
            .weight(1f),
            contentAlignment = Alignment.CenterStart
        ) {
            if(hasCartIcon) {
                IconButton(
                    onClick = { toCartScreen() }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cart),
                        contentDescription = null,
                        modifier = Modifier
                            .size(25.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                if (cartItemSize > 0) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent)
                        .padding(top = 10.dp, start = 5.dp),
                        contentAlignment = Alignment.TopStart
                    ) {
                        // Red dot for notification
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "",
                            colorFilter = ColorFilter.tint(RedColor),
                            modifier = Modifier
                                // Set image size to 4 dp
                                .size(9.dp)
                                // Clip image to be shaped as a circle
                                .clip(CircleShape)
                        )
                    }
                }
            }
        }

        // Title
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(8f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JetText(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20
            )
        }

        // Back button
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = null
            )
        }
    }
}

@Composable
fun JetHomeHeading(
    toProfileScreen: () -> Unit,
    toCartScreen: () -> Unit,
    toNotificationScreen: () -> Unit,
    cartItemSize: Int = 0,
    notificationSize: Int = 0
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(40.dp)
        .background(Color.Transparent)
    ) {
        Box(modifier = Modifier
            .background(Color.Transparent)
            .fillMaxHeight()
            .weight(1f),
            contentAlignment = Alignment.CenterStart
        ) {
            IconButton(
                onClick = { toCartScreen() }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp),
                    contentScale = ContentScale.Crop
                )
            }
            if (cartItemSize > 0) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
                    .padding(top = 10.dp, start = 5.dp),
                    contentAlignment = Alignment.TopStart
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_background),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(RedColor),
                        modifier = Modifier
                            // Set image size to 4 dp
                            .size(8.dp)
                            // Clip image to be shaped as a circle
                            .clip(CircleShape)
                    )
                }
            }
        }

        Box(modifier = Modifier
            .background(Color.Transparent)
            .fillMaxHeight()
            .weight(1f),
            contentAlignment = Alignment.CenterStart
        ) {
            IconButton(
                onClick = { toNotificationScreen() }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp),
                    contentScale = ContentScale.Crop
                )

                if (notificationSize > 0) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent)
                        .padding(top = 10.dp, start = 5.dp),
                        contentAlignment = Alignment.TopStart
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "",
                            colorFilter = ColorFilter.tint(RedColor),
                            modifier = Modifier
                                // Set image size to 4 dp
                                .size(8.dp)
                                // Clip image to be shaped as a circle
                                .clip(CircleShape)
                        )
                    }
                }
            }
        }

        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(7f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JetText(
                text = "جت مایندز",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20
            )
        }

        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(2f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            IconButton(
                onClick = {
                    toProfileScreen()
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .clip(shape = RoundedCornerShape(50.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun JetShopHeading(
    toSearchScreen: () -> Unit,
    toCartScreen: () -> Unit,
    toNotificationScreen: () -> Unit,
    cartItemSize: Int = 0,
    notificationSize: Int = 0
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(40.dp)
        .background(Color.Transparent)
    ) {
        Box(modifier = Modifier
            .background(Color.Transparent)
            .fillMaxHeight()
            .weight(1f),
            contentAlignment = Alignment.CenterStart
        ) {
            IconButton(
                onClick = { toCartScreen() }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp),
                    contentScale = ContentScale.Crop
                )
            }
            if (cartItemSize > 0) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
                    .padding(top = 10.dp, start = 5.dp),
                    contentAlignment = Alignment.TopStart
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_background),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(RedColor),
                        modifier = Modifier
                            // Set image size to 4 dp
                            .size(8.dp)
                            // Clip image to be shaped as a circle
                            .clip(CircleShape)
                    )
                }
            }

        }

        Box(modifier = Modifier
            .background(Color.Transparent)
            .fillMaxHeight()
            .weight(1f),
            contentAlignment = Alignment.CenterStart
        ) {
            IconButton(
                onClick = { toNotificationScreen() }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp),
                    contentScale = ContentScale.Crop
                )
                if (notificationSize > 0) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent)
                        .padding(top = 10.dp, start = 5.dp),
                        contentAlignment = Alignment.TopStart
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "",
                            colorFilter = ColorFilter.tint(RedColor),
                            modifier = Modifier
                                // Set image size to 4 dp
                                .size(8.dp)
                                // Clip image to be shaped as a circle
                                .clip(CircleShape)
                        )
                    }
                }
            }
        }

        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(7f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JetText(
                text = "فروشگاه جت مایندز",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18
            )
        }

        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(2f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            IconButton(
                onClick = { toSearchScreen() }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview_JetShopHeading() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        JetShopHeading(
            toSearchScreen = {},
            toCartScreen = {},
            toNotificationScreen = {}
        )
    }
}

@Preview
@Composable
private fun Preview_JetHeading() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        JetHeading(
            title = "جت مایندز",
            hasCartIcon = true,
            toCartScreen = {}
        )
    }
}

@Preview
@Composable
private fun Preview_JetHomeHeading() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        JetHomeHeading(
            toProfileScreen = {},
            toCartScreen = {},
            toNotificationScreen = {},
            cartItemSize = 1,
            notificationSize = 1
        )
    }
}