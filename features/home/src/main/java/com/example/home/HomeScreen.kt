package com.example.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.utils.SharedViewModel
import com.example.core.utils.carouselProductsSize
import com.example.designsystem.Background
import com.example.designsystem.R
import com.example.designsystem.components.JetHomeHeading
import com.example.designsystem.components.JetIconText
import com.example.designsystem.components.JetProduct
import com.example.designsystem.components.JetText
import com.example.designsystem.components.SectionSpacer
import com.example.navigationdrawer.NavigationDialogScreen

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = SharedViewModel(),
    favoritesViewModel: FavoritesViewModel = hiltViewModel(),
    toCartScreen: () -> Unit,
    toNotificationScreen: () -> Unit,
    toProfileScreen: () -> Unit,
    toShopScreen: () -> Unit,
    toProductDetailsScreen: () -> Unit,
    toOrdersScreen: () -> Unit,
    toComparesScreen: () -> Unit,
    toFavoritesScreen: () -> Unit,
    toDownloadsScreen: () -> Unit,
    toCouponsScreen: () -> Unit
){
    val homeUiState: HomeUiState by viewModel.homeUiState.collectAsState()

    HomeContent(
        homeUiState = homeUiState,
        toCartScreen = { toCartScreen() },
        toNotificationScreen = { toNotificationScreen() },
        toProfileScreen = { toProfileScreen() },
        toShopScreen = { toShopScreen() },
        toProductDetailsScreen = {
            toProductDetailsScreen()
        },
        sharedViewModel = sharedViewModel,
        favoritesViewModel = favoritesViewModel,
        toOrdersScreen = { toOrdersScreen() },
        toComparesScreen = { toComparesScreen() },
        toFavoritesScreen = { toFavoritesScreen() },
        toDownloadsScreen = { toDownloadsScreen() },
        toNotificationsScreen = { toNotificationScreen() },
        toCouponsScreen = { toCouponsScreen() }
    )
}

@Composable
private fun HomeContent(
    homeUiState: HomeUiState?,
    toCartScreen: () -> Unit,
    toNotificationScreen: () -> Unit,
    toProfileScreen: () -> Unit,
    toShopScreen: () -> Unit,
    toProductDetailsScreen: () -> Unit,
    sharedViewModel: SharedViewModel? = null,
    favoritesViewModel: FavoritesViewModel? = null,
    toOrdersScreen: () -> Unit,
    toComparesScreen: () -> Unit,
    toFavoritesScreen: () -> Unit,
    toDownloadsScreen: () -> Unit,
    toNotificationsScreen: () -> Unit,
    toCouponsScreen: () -> Unit,
) {
    val scrollState = rememberScrollState()
    var openDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .verticalScroll(state = scrollState, enabled = true)
        ) {

            // Heading
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
                verticalArrangement = Arrangement.Top
            ) {
                JetHomeHeading(
                    toProfileScreen = {
                        openDialog = true
                    }, // TODO: Handle toProfileScreen Click
                    toCartScreen = { toCartScreen() },
                    toNotificationScreen = { toNotificationScreen() } // TODO: Handle toNotificationScreen Click
                )
            }

            // Main slider
            Image(
                painter = painterResource(id = R.drawable.jetminds_slider_1),
                contentDescription = "slider",
                modifier = Modifier.clip(shape = RoundedCornerShape(12.dp))
            )

            SectionSpacer()

            // Application UI Kit
            if (homeUiState != null) {
                AndroidSourceCodeSection(
                    homeUiState = homeUiState,
                    toShopScreen = { toShopScreen() },
                    toCartScreen = { toCartScreen() },
                    toProductDetailsScreen = { toProductDetailsScreen() },
                    sharedViewModel = sharedViewModel!!,
                    favoritesViewModel = favoritesViewModel
                )
            }

            SectionSpacer()

            // Android Source Code
            ApplicationUiKitSection(
                homeUiState = homeUiState,
                toShopScreen = { toShopScreen() },
                toCartScreen = { toCartScreen() },
                toProductDetailsScreen = { toProductDetailsScreen() }
            )

            SectionSpacer()

            // Illustration banner
            Image(
                painter = painterResource(id = R.drawable.illustrations_3d_banner),
                contentDescription = "3d illustration banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(12.dp))
            )

            SectionSpacer()

            // 3D illustration products
            Illustrations3DSection(
                homeUiState = homeUiState,
                toShopScreen = { toShopScreen() },
                toCartScreen = { toCartScreen() },
                toProductDetailsScreen = { toProductDetailsScreen() }
            )

            NavigationDialogScreen(
                openDialog = openDialog,
                onDismiss = { openDialog = false },
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
    }
}

// Android carousel section
@Composable
private fun AndroidSourceCodeSection(
    homeUiState: HomeUiState?,
    toShopScreen: () -> Unit,
    toCartScreen: () -> Unit,
    toProductDetailsScreen: () -> Unit,
    sharedViewModel: SharedViewModel? = null,
    favoritesViewModel: FavoritesViewModel? = null
) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ProductsHeadingSection(
            title = "سورس کد اندروید",
            toShopScreen = { toShopScreen() }
        )
        when (val androidUiState = homeUiState?.androidUiState) {
            AndroidUiState.Loading -> {
                JetText(text = "در حال باگذاری ...")
            }
            is AndroidUiState.Success -> {
                LazyRow(
                    contentPadding = PaddingValues(0.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true,
                    content = {
                        items(count = carouselProductsSize(
                            size = androidUiState.androidSourceCodes.size
                        )) { position ->
                            favoritesViewModel?.isFavoriteProduct(androidUiState.androidSourceCodes[position].id!!)
                            JetProduct(
                                title = "${androidUiState.androidSourceCodes[position].name}",
                                image = androidUiState.androidSourceCodes[position].images?.get(0)?.src,
                                price = androidUiState.androidSourceCodes[position].price,
                                rating = androidUiState.androidSourceCodes[position].averageRating,
                                category = androidUiState.androidSourceCodes[position].categories?.get(0)?.name,
                                onAddToCartClick = { toCartScreen() },
                                onProductClick = {
                                    sharedViewModel?.addProduct(androidUiState.androidSourceCodes[position])
                                    toProductDetailsScreen()
                                },
                                onFavoriteBtnClick = {
                                    if (androidUiState.androidSourceCodes[position].isFavorite == false) {
                                        favoritesViewModel?.updateFavoriteProduct(
                                            productId = androidUiState.androidSourceCodes[position].id!!,
                                            isFavorite = true
                                        )
                                    } else {
                                        favoritesViewModel?.updateFavoriteProduct(
                                            productId = androidUiState.androidSourceCodes[position].id!!,
                                            isFavorite = false
                                        )
                                    }
                                },
                                isFavorite = false // todo: fix this shit
                            )
                        }
                    }
                )
            }
            is AndroidUiState.Error -> {
                JetText(text = "${androidUiState.message}")
            }
            else -> {}
        }
    }
}

// Application ui kits carousel section
@Composable
private fun ApplicationUiKitSection(
    homeUiState: HomeUiState?,
    toShopScreen: () -> Unit,
    toCartScreen: () -> Unit,
    toProductDetailsScreen: () -> Unit,
    sharedViewModel: SharedViewModel? = null,
    favoritesViewModel: FavoritesViewModel? = null
) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ProductsHeadingSection(
            title = "رابط کاربری اپلیکیشن",
            toShopScreen = { toShopScreen() }
        )
        when (val applicationUiKitUiState = homeUiState?.applicationUiKitUiState) {
            ApplicationUiKitUiState.Loading -> {
                JetText(text = "در حال باگذاری ...")
            }
            is ApplicationUiKitUiState.Success -> {
                LazyRow(
                    contentPadding = PaddingValues(0.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true,
                    content = {
                        items(count = carouselProductsSize(
                            size = applicationUiKitUiState.applicationUiKits.size
                        )) { position ->
                            favoritesViewModel?.isFavoriteProduct(applicationUiKitUiState.applicationUiKits[position].id!!)
                            JetProduct(
                                title = "${applicationUiKitUiState.applicationUiKits[position].name}",
                                image = applicationUiKitUiState.applicationUiKits[position].images?.get(0)?.src,
                                price = applicationUiKitUiState.applicationUiKits[position].price,
                                rating = applicationUiKitUiState.applicationUiKits[position].averageRating,
                                category = applicationUiKitUiState.applicationUiKits[position].categories?.get(0)?.name,
                                onAddToCartClick = { toCartScreen() },
                                onProductClick = {
                                    sharedViewModel?.addProduct(applicationUiKitUiState.applicationUiKits[position])
                                    toProductDetailsScreen()
                                },
                                onFavoriteBtnClick = {
                                    if (applicationUiKitUiState.applicationUiKits[position].isFavorite == false) {
                                        favoritesViewModel?.updateFavoriteProduct(
                                            productId = applicationUiKitUiState.applicationUiKits[position].id!!,
                                            isFavorite = true
                                        )
                                    } else {
                                        favoritesViewModel?.updateFavoriteProduct(
                                            productId = applicationUiKitUiState.applicationUiKits[position].id!!,
                                            isFavorite = false
                                        )
                                    }
                                },
                                isFavorite = false // todo: fix this shit
                            )
                        }
                    }
                )
            }
            is ApplicationUiKitUiState.Error -> {
                JetText(text = "${applicationUiKitUiState.message}")
            }
            else -> {}
        }
    }
}

// 3D illustrations carousel section
@Composable
private fun Illustrations3DSection(
    homeUiState: HomeUiState?,
    toShopScreen: () -> Unit,
    toCartScreen: () -> Unit,
    toProductDetailsScreen: () -> Unit,
    sharedViewModel: SharedViewModel? = null,
    favoritesViewModel: FavoritesViewModel? = null
) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ProductsHeadingSection(
            title = "طرح های سه بعدی",
            toShopScreen = { toShopScreen() }
        )
        when (val illustrations3DUiState = homeUiState?.illustrations3DUiState) {
            Illustrations3DUiState.Loading -> {
                JetText(text = "در حال باگذاری ...")
            }
            is Illustrations3DUiState.Success -> {
                LazyRow(
                    contentPadding = PaddingValues(0.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true,
                    content = {
                        items(count = carouselProductsSize(
                            size = illustrations3DUiState.illustration3Ds.size)
                        ) { position ->
                            JetProduct(
                                title = "${illustrations3DUiState.illustration3Ds[position].name}",
                                image = illustrations3DUiState.illustration3Ds[position].images?.get(0)?.src,
                                price = illustrations3DUiState.illustration3Ds[position].price,
                                rating = illustrations3DUiState.illustration3Ds[position].averageRating,
                                category = illustrations3DUiState.illustration3Ds[position].categories?.get(0)?.name,
                                onAddToCartClick = { toCartScreen() },
                                onProductClick = {
                                    sharedViewModel?.addProduct(illustrations3DUiState.illustration3Ds[position])
                                    toProductDetailsScreen()
                                },
                                onFavoriteBtnClick = {
                                    if (illustrations3DUiState.illustration3Ds[position].isFavorite == false) {
                                        favoritesViewModel?.updateFavoriteProduct(
                                            productId = illustrations3DUiState.illustration3Ds[position].id!!,
                                            isFavorite = true
                                        )
                                    } else {
                                        favoritesViewModel?.updateFavoriteProduct(
                                            productId = illustrations3DUiState.illustration3Ds[position].id!!,
                                            isFavorite = false
                                        )
                                    }
                                },
                                isFavorite = false // todo: fix this shit
                            )
                        }
                    }
                )
            }
            is Illustrations3DUiState.Error -> {
                JetText(text = "${illustrations3DUiState.message}")
            }
            else -> {}
        }
    }
}

@Composable
private fun ProductsHeadingSection(
    title: String,
    toShopScreen: () -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        JetText(text = title)
        JetIconText {
            toShopScreen()
        }
    }
}

@Preview
@Composable
fun Preview_HomeScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        HomeContent(
            homeUiState = null,
            toCartScreen = {},
            toNotificationScreen = {},
            toProfileScreen = {},
            toShopScreen = {},
            toProductDetailsScreen = {},
            toOrdersScreen = {},
            toComparesScreen = {},
            toFavoritesScreen = {},
            toDownloadsScreen = {},
            toNotificationsScreen = {},
            toCouponsScreen = {}
        )
    }
}