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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.utils.SharedViewModel
import com.example.core.utils.carouselProductsSize
import com.example.core.utils.getCurrentDate
import com.example.designsystem.Background
import com.example.designsystem.R
import com.example.designsystem.components.JetHomeHeading
import com.example.designsystem.components.JetIconText
import com.example.designsystem.components.JetProduct
import com.example.designsystem.components.JetText
import com.example.designsystem.components.SectionSpacer
import com.example.domain.models.ProductsResponse
import com.example.navigationdrawer.NavigationDialogScreen

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = SharedViewModel(),
    favoritesViewModel: FavoritesViewModel = hiltViewModel(),
    cartViewModel: CartViewModel = hiltViewModel(),
    toCartScreen: () -> Unit,
    toNotificationScreen: () -> Unit,
    toProfileScreen: () -> Unit,
    toShopScreen: () -> Unit,
    toProductDetailsScreen: () -> Unit,
    toOrdersScreen: () -> Unit,
    toComparesScreen: () -> Unit,
    toFavoritesScreen: () -> Unit,
    toDownloadsScreen: () -> Unit,
    toCouponsScreen: () -> Unit,
    toLoginScreen: () -> Unit
){
    val homeUiState: HomeUiState by viewModel.homeUiState.collectAsState()
    val isFavoriteState by favoritesViewModel.isFavorite.collectAsState()
    val cartTotalCountState by cartViewModel.totalCartCount.collectAsState()

    HomeContent(
        homeUiState = homeUiState,
        cartViewModel = cartViewModel,
        sharedViewModel = sharedViewModel,
        favoritesViewModel = favoritesViewModel,
        cartTotalCount = cartTotalCountState,
        toCartScreen = { toCartScreen() },
        toNotificationScreen = { toNotificationScreen() },
        toProfileScreen = { toProfileScreen() },
        toShopScreen = { toShopScreen() },
        toProductDetailsScreen = { toProductDetailsScreen() },
        toOrdersScreen = { toOrdersScreen() },
        toComparesScreen = { toComparesScreen() },
        toFavoritesScreen = { toFavoritesScreen() },
        toDownloadsScreen = { toDownloadsScreen() },
        toNotificationsScreen = { toNotificationScreen() },
        toCouponsScreen = { toCouponsScreen() },
        toLoginScreen = { toLoginScreen() },
        isFavoriteState = isFavoriteState
    )
}

@Composable
private fun HomeContent(
    homeUiState: HomeUiState?,
    sharedViewModel: SharedViewModel? = null,
    favoritesViewModel: FavoritesViewModel? = null,
    cartViewModel: CartViewModel,
    cartTotalCount: Int = 0,
    toCartScreen: () -> Unit,
    toNotificationScreen: () -> Unit,
    toProfileScreen: () -> Unit,
    toShopScreen: () -> Unit,
    toProductDetailsScreen: () -> Unit,
    toOrdersScreen: () -> Unit,
    toComparesScreen: () -> Unit,
    toFavoritesScreen: () -> Unit,
    toDownloadsScreen: () -> Unit,
    toNotificationsScreen: () -> Unit,
    toCouponsScreen: () -> Unit,
    toLoginScreen: () -> Unit,
    isFavoriteState: Boolean = false
) {
    val scrollState = rememberScrollState()
    var openDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 15.dp,
                start = 15.dp,
                end = 15.dp,
                bottom = 70.dp
            )
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
                    },
                    toCartScreen = { toCartScreen() },
                    toNotificationScreen = { toNotificationScreen() }, // TODO: Handle toNotificationScreen Click
                    cartItemSize = cartTotalCount
                )
            }

            // Application UI Kit
            if (homeUiState != null) {
                MainContentSection(
                    homeUiState = homeUiState,
                    sharedViewModel = sharedViewModel,
                    favoritesViewModel = favoritesViewModel,
                    cartViewModel = cartViewModel,
                    toShopScreen = { toShopScreen() },
                    toProductDetailsScreen = { toProductDetailsScreen() }
                )
            }

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
                toProfileScreen = { toProfileScreen() },
                toLoginScreen = { toLoginScreen() }
            )
        }
    }
}

@Composable
fun MainContentSection(
    homeUiState: HomeUiState?,
    sharedViewModel: SharedViewModel?,
    favoritesViewModel: FavoritesViewModel?,
    cartViewModel: CartViewModel,
    toShopScreen: () -> Unit,
    toProductDetailsScreen: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {

        // Main slider
        Image(
            painter = painterResource(id = R.drawable.jetminds_slider_1),
            contentDescription = "slider",
            modifier = Modifier.clip(shape = RoundedCornerShape(12.dp))
        )

        SectionSpacer()

        // Android source code section
        ProductsHeadingSection(
            title = stringResource(id = R.string.category_title_android_ui_kit),
            toShopScreen = { toShopScreen() }
        )
        when (val androidUiState = homeUiState?.androidUiState) {
            AndroidUiState.Loading -> {
                JetText(text = stringResource(id = R.string.loading))
            }
            is AndroidUiState.Success -> {
                ProductsRow(
                    sharedViewModel = sharedViewModel,
                    favoritesViewModel = favoritesViewModel,
                    products = androidUiState.androidSourceCodes,
                    toProductDetailsScreen = { toProductDetailsScreen() },
                    cartViewModel = cartViewModel
                )
            }
            is AndroidUiState.Error -> {
                JetText(text = "${androidUiState.message}")
            }
            else -> Unit
        }

        SectionSpacer()

        // Application section
        ProductsHeadingSection(
            title = stringResource(id = R.string.category_title_application_ui_kit),
            toShopScreen = { toShopScreen() }
        )
        when (val applicationUiKitUiState = homeUiState?.applicationUiKitUiState) {
            ApplicationUiKitUiState.Loading -> {
                JetText(text = stringResource(id = R.string.loading))
            }
            is ApplicationUiKitUiState.Success -> {
                ProductsRow(
                    sharedViewModel = sharedViewModel,
                    favoritesViewModel = favoritesViewModel,
                    products = applicationUiKitUiState.applicationUiKits,
                    toProductDetailsScreen = { toProductDetailsScreen() },
                    cartViewModel = cartViewModel
                )
            }
            is ApplicationUiKitUiState.Error -> {
                JetText(text = "${applicationUiKitUiState.message}")
            }
            else -> Unit
        }

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

        // 3D illustration section
        ProductsHeadingSection(
            title = stringResource(id = R.string.category_title_illustration_ui_lit),
            toShopScreen = { toShopScreen() }
        )
        when (val illustrations3DUiState = homeUiState?.illustrations3DUiState) {
            Illustrations3DUiState.Loading -> {
                JetText(text = stringResource(id = R.string.loading))
            }
            is Illustrations3DUiState.Success -> {
                ProductsRow(
                    sharedViewModel = sharedViewModel,
                    favoritesViewModel = favoritesViewModel,
                    products = illustrations3DUiState.illustration3Ds,
                    toProductDetailsScreen = { toProductDetailsScreen() },
                    cartViewModel = cartViewModel
                )
            }
            is Illustrations3DUiState.Error -> {
                JetText(text = "${illustrations3DUiState.message}")
            }
            else -> Unit
        }
    }
}

@Composable
private fun ProductsRow(
    products: List<ProductsResponse>,
    cartViewModel: CartViewModel,
    toProductDetailsScreen: () -> Unit,
    sharedViewModel: SharedViewModel? = null,
    favoritesViewModel: FavoritesViewModel? = null
) {
    val cartItemCountUiState by cartViewModel.cartItemCount.collectAsState()
    val isInCartUiState by cartViewModel.isInCartUiState.collectAsState()
    var count by remember { mutableIntStateOf(0) }

    LazyRow(
        contentPadding = PaddingValues(0.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        userScrollEnabled = true,
        content = {
            items(count = carouselProductsSize(
                size = products.size
            )) { position ->
                JetProduct(
                    title = "${products[position].name}",
                    image = products[position].images?.get(0)?.src,
                    price = products[position].price,
                    rating = products[position].averageRating,
                    category = products[position].categories?.get(0)?.name,
                    onAddToCartClick = {
                        count = cartItemCountUiState
                        if (isInCartUiState == 0) {
                            cartViewModel?.insertCartItem(
                                productId = products[position].id!!,
                                productTitle = products[position].name!!,
                                productImage = products[position].images?.get(0)?.src!!,
                                productCategory = products[position].categories?.get(0)?.name!!,
                                productPrice = products[position].price!!.toInt(),
                                count = (count + 1),
                                dateAdded = getCurrentDate()
                            )
                        } else {
                            cartViewModel?.updateCart(
                                productId = products[position].id!!,
                                productPrice = products[position].price!!.toInt(),
                                count = (count + 1)
                            )
                        }
                    },
                    onProductClick = {
                        sharedViewModel?.addProductId(id = products[position].id!!)
                        toProductDetailsScreen()
                    },
                    onFavoriteBtnClick = {
                        if (products[position].isFavorite == false) {
                            favoritesViewModel?.updateFavoriteProduct(
                                productId = products[position].id!!,
                                isFavorite = true
                            )
                        } else {
                            favoritesViewModel?.updateFavoriteProduct(
                                productId = products[position].id!!,
                                isFavorite = false
                            )
                        }
                    },
                    isFavorite = products[position].isFavorite!!
                )
            }
        }
    )
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
        JetIconText { toShopScreen() }
    }
}