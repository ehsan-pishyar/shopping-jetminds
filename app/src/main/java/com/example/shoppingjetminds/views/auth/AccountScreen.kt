package com.example.shoppingjetminds.views.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.components.JetHeading
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.ui.theme.BlueColor
import com.example.shoppingjetminds.ui.theme.LighterGray
import com.example.shoppingjetminds.ui.theme.Primary
import com.example.shoppingjetminds.ui.theme.Secondary
import com.example.shoppingjetminds.uistates.MainAccountUiState
import com.example.shoppingjetminds.viewmodels.AccountViewModel

@Composable
fun AccountScreen(
    viewModel: AccountViewModel = hiltViewModel()
) {
    val uiState: MainAccountUiState by viewModel.accountUiState.collectAsState()
    AccountContent(
        uiState = uiState
    )
}

@Composable
private fun AccountContent(
    uiState: MainAccountUiState? = null
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ) {
                JetHeading(title = "پنل کاربری", hasCartIcon = true)
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
            ) {
                UserSection(
                    uiState = uiState
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(5f)
            ) {
                MainMenuSection()
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
            ) {
                Row(modifier = Modifier
                    .fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                    ) {
                        CouponSection()
                    }
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                    ) {
                        NotificationSection()
                    }
                }
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
            ) {
                UserLastBuying()
            }
        }
    }
}

@Composable
private fun UserSection(
    uiState: MainAccountUiState? = null
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(120.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Primary
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
            )
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                JetText(
                    text = "احسان پیش یار",
                    fontSize = 15,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                JetText(
                    text = "ehsan.pishyar@gmail.com",
                    fontSize = 12,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
                Card(modifier = Modifier
                    .wrapContentSize(),
                    shape = RoundedCornerShape(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White.copy(alpha = 0.5f)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 0.dp
                    )
                ) {
                    Column(modifier = Modifier
                        .wrapContentSize()
                        .padding(horizontal = 5.dp, vertical = 2.dp)
                    ) {
                        JetText(
                            text = "مدیر کل",
                            fontSize = 10,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.End
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.size(20.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logout_icon),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(color = Color.White),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun MainMenuSection() {
    Card(modifier = Modifier
        .fillMaxSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            MainMenuItemSection(
                icon = R.drawable.user_icon,
                title = "مشاهده اطلاعات"
            ) {

            }
            Divider(color = Background)
            MainMenuItemSection(
                icon = R.drawable.orders_icon,
                title = "سفارشات من"
            ) {

            }
            Divider(color = Background)
            MainMenuItemSection(
                icon = R.drawable.download_icon,
                title = "دانلود های من"
            ) {
                
            }
            Divider(color = Background)
            MainMenuItemSection(
                icon = R.drawable.billing_icon,
                title = "جزئیات صورت حساب"
            ) {

            }
            Divider(color = Background)
            MainMenuItemSection(
                icon = R.drawable.location,
                title = "آدرس من"
            ) {
                
            }
            Divider(color = Background)
            MainMenuItemSection(
                icon = R.drawable.favorite,
                title = "علاقه مندی های من"
            ) {

            }
        }
    }
}

@Composable
private fun MainMenuItemSection(
    icon: Int,
    title: String,
    onClick: () -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .clickable(enabled = true, onClick = { onClick() }),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier
            .wrapContentHeight()
            .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(15.dp),
                colorFilter = ColorFilter.tint(LighterGray)
            )
            JetText(
                text = title,
                fontWeight = FontWeight.Normal,
                fontSize = 13
            )
        }
        Image(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = null,
            modifier = Modifier.size(15.dp),
            colorFilter = ColorFilter.tint(LighterGray)
        )
    }
}

@Composable
private fun CouponSection() {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        JetText(
            text = "کدهای تخفیف",
            fontSize = 13,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Card(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 0.dp
            )
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Secondary,
                            Secondary.copy(alpha = 0.5f)
                        )
                    )
                ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Column(modifier = Modifier
                    .padding(horizontal = 20.dp)
                ) {
                    JetText(
                        text = "First50",
                        fontSize = 18,
                        fontWeight = FontWeight.SemiBold
                    )
                    JetText(
                        text = "تخفیف ۵۰% ویژه اولین خرید",
                        fontSize = 12,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}

@Composable
private fun NotificationSection() {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        JetText(
            text = "اعلان ها",
            fontSize = 13,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Card(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 0.dp
            )
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            BlueColor,
                            BlueColor.copy(alpha = 0.5f)
                        )
                    )
                ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Column(modifier = Modifier
                    .padding(horizontal = 20.dp)
                ) {
                    JetText(
                        text = "عنوان اعلان",
                        fontSize = 15,
                        fontWeight = FontWeight.SemiBold
                    )
                    JetText(
                        text = "توضیحات اعلان، توضیحات اعلان",
                        fontSize = 12,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}

@Composable
private fun UserLastBuying() {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        JetText(
            text = "آخرین خرید های من",
            fontSize = 13,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Card(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 0.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(modifier = Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Column(modifier = Modifier
                    .padding(horizontal = 20.dp)
                ) {
                    JetText(
                        text = "عنوان اعلان",
                        fontSize = 15,
                        fontWeight = FontWeight.SemiBold
                    )
                    JetText(
                        text = "توضیحات اعلان، توضیحات اعلان",
                        fontSize = 12,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview_AccountContent() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        AccountContent()
    }
}