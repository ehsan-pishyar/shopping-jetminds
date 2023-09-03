package com.example.navigationdrawer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.designsystem.BlackColor
import com.example.designsystem.LighterBlack
import com.example.designsystem.LighterGray
import com.example.designsystem.Primary
import com.example.designsystem.components.JetText
import com.example.designsystem.R
import com.example.designsystem.components.SectionSpacer

@Composable
fun NavigationDialogScreen(
    viewModel: NavigationDialogViewModel = hiltViewModel(),
    openDialog: Boolean,
    onDismiss: () -> Unit,
    toShopScreen: () -> Unit,
    toOrdersScreen: () -> Unit,
    toCartScreen: () -> Unit,
    toComparesScreen: () -> Unit,
    toFavoritesScreen: () -> Unit,
    toDownloadsScreen: () -> Unit,
    toNotificationsScreen: () -> Unit,
    toCouponsScreen: () -> Unit,
    toProfileScreen: () -> Unit
) {
    val ordersUiState: MainNavigationDialogOrdersUiState by viewModel.ordersState.collectAsState()
    val cartUiState = viewModel.cartState.collectAsState()
    val compareUiState = viewModel.comparesState.collectAsState()
    val favoritesUiState = viewModel.favoritesState.collectAsState()
    val downloadsUiState = viewModel.downloadsState.collectAsState()
    val notificationsUiState = viewModel.notificationsState.collectAsState()
    val couponsUiState: MainNavigationDialogCouponsUiState by viewModel.couponsState.collectAsState()

    NavigationDialogContent(
        ordersUiState = ordersUiState,
        cartUiState = cartUiState,
        compareUiState = compareUiState,
        favoritesUiState = favoritesUiState,
        downloadsUiState = downloadsUiState,
        notificationsUiState = notificationsUiState,
        couponsUiState = couponsUiState,
        openDialog = openDialog,
        onDismiss = { onDismiss() },
        toShopScreen = { toShopScreen() },
        toOrdersScreen = { toOrdersScreen() },
        toCartScreen = { toCartScreen() },
        toComparesScreen = { toComparesScreen() },
        toFavoritesScreen = { toFavoritesScreen() },
        toDownloadsScreen = { toDownloadsScreen() },
        toNotificationsScreen = { toNotificationsScreen() },
        toCouponsScreen = { toCouponsScreen() },
        toProfileScreen = { toProfileScreen() }
    )
}

@Composable
private fun NavigationDialogContent(
    ordersUiState: MainNavigationDialogOrdersUiState? = null,
    cartUiState: State<Int>? = null,
    compareUiState: State<Int>? = null,
    favoritesUiState: State<Int>? = null,
    downloadsUiState: State<Int>? = null,
    notificationsUiState: State<Int>? = null,
    couponsUiState: MainNavigationDialogCouponsUiState? = null,
    openDialog: Boolean,
    onDismiss: () -> Unit,
    toShopScreen: () -> Unit,
    toOrdersScreen: () -> Unit,
    toCartScreen: () -> Unit,
    toComparesScreen: () -> Unit,
    toFavoritesScreen: () -> Unit,
    toDownloadsScreen: () -> Unit,
    toNotificationsScreen: () -> Unit,
    toCouponsScreen: () -> Unit,
    toProfileScreen: () -> Unit
) {
    if (openDialog) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE7EEF4)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 0.dp
                )
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(5.dp)
                ) {
                    DialogHeaderSection(
                        onDismiss = { onDismiss() }
                    )
                    DialogMainSection(
                        ordersUiState = ordersUiState,
                        cartUiState = cartUiState,
                        compareUiState = compareUiState,
                        favoritesUiState = favoritesUiState,
                        downloadsUiState = downloadsUiState,
                        notificationsUiState = notificationsUiState,
                        couponsUiState = couponsUiState,
                        toOrdersScreen = { toOrdersScreen() },
                        toCartScreen = { toCartScreen() },
                        toComparesScreen = { toComparesScreen() },
                        toFavoritesScreen = { toFavoritesScreen() },
                        toDownloadsScreen = { toDownloadsScreen() },
                        toNotificationsScreen = { toNotificationsScreen() },
                        toCouponsScreen = { toCouponsScreen() },
                        toProfileScreen = { toProfileScreen() }
                    )
                    DialogBottomSection(
                        toShopScreen = { toShopScreen() }
                    )
                }
            }
        }
    }
}

@Composable
private fun DialogHeaderSection(
    onDismiss: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(40.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
        ) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
            ) {}
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(4f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                JetText(
                    text = "جت مایندز",
                    fontSize = 16,
                    fontWeight = FontWeight.SemiBold,
                    color = Primary
                )
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = BlackColor,
                    modifier = Modifier
                        .size(22.dp)
                        .clickable { onDismiss() }
                )
            }
        }
    }
}

@Composable
private fun DialogMainSection(
    ordersUiState: MainNavigationDialogOrdersUiState? = null,
    cartUiState: State<Int>? = null,
    compareUiState: State<Int>? = null,
    favoritesUiState: State<Int>? = null,
    downloadsUiState: State<Int>? = null,
    notificationsUiState: State<Int>? = null,
    couponsUiState: MainNavigationDialogCouponsUiState? = null,
    toOrdersScreen: () -> Unit,
    toCartScreen: () -> Unit,
    toComparesScreen: () -> Unit,
    toFavoritesScreen: () -> Unit,
    toDownloadsScreen: () -> Unit,
    toNotificationsScreen: () -> Unit,
    toCouponsScreen: () -> Unit,
    toProfileScreen: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(15.dp),
            verticalArrangement = Arrangement.Top
        ) {
            DialogMainSectionHeader(
                toProfileScreen = { toProfileScreen() }
            )
            SectionSpacer(10)
            Divider(color = Color(0xFFE7EEF4))
            SectionSpacer(30)
            DialogMainSectionContent(
                ordersUiState = ordersUiState,
                cartUiState = cartUiState,
                compareUiState = compareUiState,
                favoritesUiState = favoritesUiState,
                downloadsUiState = downloadsUiState,
                notificationsUiState = notificationsUiState,
                couponsUiState = couponsUiState,
                toOrdersScreen = { toOrdersScreen() },
                toCartScreen = { toCartScreen() },
                toComparesScreen = { toComparesScreen() },
                toFavoritesScreen = { toFavoritesScreen() },
                toDownloadsScreen = { toDownloadsScreen() },
                toNotificationsScreen = { toNotificationsScreen() },
                toCouponsScreen = { toCouponsScreen() }
            )
            SectionSpacer(20)
        }
    }
}

@Composable
private fun DialogMainSectionHeader(
    toProfileScreen: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp),
        verticalArrangement = Arrangement.Top
    ) {
        // Avatar, Title and Email
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(3f)
            .clickable(enabled = true, onClick = { toProfileScreen() }),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            // User Avatar -------------------------------------------------------------------------
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(45.dp)
                        .clip(shape = RoundedCornerShape(50.dp))
                )
            }
            // User Title and Email ----------------------------------------------------------------
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(4f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                // User title ----------------------------------------------------------------------
                JetText(
                    text = "احسان پیش یار",
                    fontSize = 13,
                    fontWeight = FontWeight.Medium,
                    color = BlackColor
                )
                // User email ----------------------------------------------------------------------
                JetText(
                    text = "ehsan.pishyar@gmail.com",
                    fontSize = 11,
                    fontWeight = FontWeight.Normal,
                    color = LighterGray
                )
            }
        }
        // User role -------------------------------------------------------------------------------
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End
        ) {
            Card(
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Primary.copy(alpha = 0.2f)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 0.dp
                )
            ) {
                Column(modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 2.dp)
                ) {
                    JetText(
                        text = "مدیر کل",
                        fontSize = 10,
                        fontWeight = FontWeight.Normal,
                        color = BlackColor
                    )
                }
            }
        }
    }
}

@Composable
private fun DialogMainSectionContent(
    ordersUiState: MainNavigationDialogOrdersUiState? = null,
    cartUiState: State<Int>? = null,
    compareUiState: State<Int>? = null,
    favoritesUiState: State<Int>? = null,
    downloadsUiState: State<Int>? = null,
    notificationsUiState: State<Int>? = null,
    couponsUiState: MainNavigationDialogCouponsUiState? = null,
    toOrdersScreen: () -> Unit,
    toCartScreen: () -> Unit,
    toComparesScreen: () -> Unit,
    toFavoritesScreen: () -> Unit,
    toDownloadsScreen: () -> Unit,
    toNotificationsScreen: () -> Unit,
    toCouponsScreen: () -> Unit,
) {
    val ordersBadge = remember { mutableIntStateOf(0) }
    val couponsBadge = remember { mutableIntStateOf(0) }

    // Get badge from web service ------------------------------------------------------------------
    when (val orderState = ordersUiState?.response) {
        NavigationDialogOrdersUiState.Loading -> Unit
        is NavigationDialogOrdersUiState.Success -> {
            ordersBadge.value = orderState.size
        }
        is NavigationDialogOrdersUiState.Error -> Unit
        else -> Unit
    }

    // Get badge from web service ------------------------------------------------------------------
    when (val couponsState = couponsUiState?.response) {
        NavigationDialogCouponsUiState.Loading -> Unit
        is NavigationDialogCouponsUiState.Success -> {
            couponsBadge.value = couponsState.size
        }
        is NavigationDialogCouponsUiState.Error -> Unit
        else -> Unit
    }

    // List of items -------------------------------------------------------------------------------
    val items = listOf(
        NavigationDialogItem(
            icon = R.drawable.orders_icon,
            title = "سفارشات",
            badge = ordersBadge.value,
            onClick = { toOrdersScreen() }
        ),
        NavigationDialogItem(
            icon = R.drawable.cart,
            title = "سبد بخیر",
            badge = cartUiState?.value!!,
            onClick = { toCartScreen() }
        ),
        NavigationDialogItem(
            icon = R.drawable.compare,
            title = "مقایسه ها",
            badge = compareUiState?.value!!,
            onClick = { toComparesScreen() }
        ),
        NavigationDialogItem(
            icon = R.drawable.favorite,
            title = "مورد علاقه ها",
            badge = favoritesUiState?.value!!,
            onClick = { toFavoritesScreen() }
        ),
        NavigationDialogItem(
            icon = R.drawable.download_icon,
            title = "دانلود ها",
            badge = downloadsUiState?.value!!,
            onClick = { toDownloadsScreen() }
        ),
        NavigationDialogItem(
            icon = R.drawable.notification,
            title = "اعلان ها",
            badge = notificationsUiState?.value!!,
            onClick = { toNotificationsScreen() }
        ),
        NavigationDialogItem(
            icon = R.drawable.discount,
            title = "کد های تخفیف",
            badge = couponsBadge.value,
            onClick = { toCouponsScreen() }
        )
    )

    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
    ) {
        items(count = items.size) { position ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .clickable(
                    enabled = true,
                    onClick = { items[position].onClick() }
                )
            ) {
                // Screen icon ---------------------------------------------------------------------
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = items[position].icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(16.dp),
                        colorFilter = ColorFilter.tint(LighterGray)
                    )
                }
                // Screen title --------------------------------------------------------------------
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .weight(5f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    JetText(
                        text = items[position].title,
                        fontSize = 12,
                        fontWeight = FontWeight.Normal
                    )
                }
                // Screen badge --------------------------------------------------------------------
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    AnimatedVisibility(visible = items[position].badge > 0) {
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Primary.copy(alpha = 0.1f)
                            ),
                            shape = RoundedCornerShape(20.dp),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 0.dp
                            )
                        ) {
                            Column(modifier = Modifier
                                .wrapContentSize()
                                .padding(horizontal = 5.dp)
                            ) {
                                JetText(
                                    text = "${items[position].badge}",
                                    fontSize = 9,
                                    fontWeight = FontWeight.Normal,
                                    color = LighterBlack
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DialogBottomSection(
    toShopScreen: () -> Unit
) {
    val items = listOf(
        NavigationDialogBottomItem(
            icon = R.drawable.settings,
            title = "تنظیمات",
            onClick = { toShopScreen() }
        ),
        NavigationDialogBottomItem(
            icon = R.drawable.user_icon,
            title = "درباره ما",
            onClick = { toShopScreen() }
        )
    )

    SectionSpacer(20)

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 15.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(count = items.size) { position ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable(enabled = true, onClick = {
                    items[position].onClick()
                })
            ) {
                // Screen icon
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = items[position].icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(16.dp),
                        colorFilter = ColorFilter.tint(LighterGray)
                    )
                }
                // Screen title
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(5f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    JetText(
                        text = items[position].title,
                        fontSize = 12,
                        fontWeight = FontWeight.Normal
                    )
                }
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {}
            }
        }
    }

    SectionSpacer(20)
}


@Preview
@Composable
private fun Preview_NavigationDialogScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        NavigationDialogContent(
            openDialog = true,
            onDismiss = {},
            toShopScreen = {},
            toOrdersScreen = {},
            toCartScreen = {},
            toComparesScreen = {},
            toFavoritesScreen = {},
            toDownloadsScreen = {},
            toNotificationsScreen = {},
            toCouponsScreen = {},
            toProfileScreen = {}
        )
    }
}