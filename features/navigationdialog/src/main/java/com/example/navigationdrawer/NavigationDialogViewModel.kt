package com.example.navigationdrawer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.cart.GetCartTotalCountsUseCase
import com.example.domain.use_cases.coupons.GetCouponsUseCase
import com.example.domain.use_cases.downloads.GetDownloadedProductsUseCase
import com.example.domain.use_cases.orders.GetOrdersUseCase
import com.example.domain.use_cases.favorites.GetFavoriteProductsUseCase
import com.example.domain.use_cases.user.GetUserTokenUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavigationDialogViewModel @Inject constructor(
    private val getOrdersUseCase: GetOrdersUseCase,
    private val getCartTotalCountUseCase: GetCartTotalCountsUseCase,
    private val getFavoritesUseCase: GetFavoriteProductsUseCase,
    private val getDownloadedUseCase: GetDownloadedProductsUseCase,
    private val getCouponsUseCase: GetCouponsUseCase,
    private val readUserTokenUseCase: GetUserTokenUseCase
): ViewModel() {

    private var _ordersState = MutableStateFlow(MainNavigationDialogOrdersUiState(NavigationDialogOrdersUiState.Loading))
    val ordersState = _ordersState.asStateFlow()

    private var _cartState = MutableStateFlow(0)
    val cartState = _cartState.asStateFlow()

    private var _comparesState = MutableStateFlow(0)
    val comparesState = _comparesState.asStateFlow()

    private var _favoritesState = MutableStateFlow(0)
    val favoritesState = _favoritesState.asStateFlow()

    private var _downloadsState = MutableStateFlow(0)
    val downloadsState = _downloadsState.asStateFlow()

    private var _notificationsState = MutableStateFlow(0)
    val notificationsState = _notificationsState.asStateFlow()

    private var _couponsState = MutableStateFlow(MainNavigationDialogCouponsUiState(NavigationDialogCouponsUiState.Loading))
    val couponsState = _couponsState.asStateFlow()

    private var _dataStoreUserToken = MutableStateFlow("")
    val dataStoreUserToken = _dataStoreUserToken.asStateFlow()

    init {
        getOrdersSize()
        getCartSize()
        getCompareSize()
        getFavoritesSize()
        getDownloadsSize()
        getNotificationsSize()
        getCouponsSize()
        readUserTokenFromDataStore()
    }

    private fun getOrdersSize() {
        viewModelScope.launch {
            getOrdersUseCase.invoke().collect { ordersResult ->
                val ordersUiStateResul = when (ordersResult) {
                    ServiceResult.Loading -> NavigationDialogOrdersUiState.Loading
                    is ServiceResult.Success -> NavigationDialogOrdersUiState.Success(
                        size = ordersResult.data.size
                    )
                    is ServiceResult.Error -> NavigationDialogOrdersUiState.Error(
                        throwable = ordersResult.throwable!!
                    )
                }
                _ordersState.value = MainNavigationDialogOrdersUiState(
                    response = ordersUiStateResul
                )
            }
        }
    }

    private fun getCartSize() {
        viewModelScope.launch {
            getCartTotalCountUseCase.invoke().collect { cartResult ->
                _cartState.value = cartResult!!
            }
        }
    }

    private fun getCompareSize() {
        viewModelScope.launch {
        }
    }

    private fun getFavoritesSize() {
        viewModelScope.launch {
            getFavoritesUseCase.invoke().collect { favoriteResult ->
                _favoritesState.value = favoriteResult.size
            }
        }
    }

    private fun getDownloadsSize() {
        viewModelScope.launch {
            getDownloadedUseCase.invoke().collect { downloadResult ->
                _downloadsState.value = downloadResult.size
            }
        }
    }

    private fun getNotificationsSize() {
        viewModelScope.launch {
        }
    }

    private fun getCouponsSize() {
        viewModelScope.launch {
            getCouponsUseCase.invoke().collect { couponsResult ->
                val couponsUiStateResult = when (couponsResult) {
                    ServiceResult.Loading -> NavigationDialogCouponsUiState.Loading
                    is ServiceResult.Success -> NavigationDialogCouponsUiState.Success(
                        size = couponsResult.data.size
                    )
                    is ServiceResult.Error -> NavigationDialogCouponsUiState.Error(
                        throwable = couponsResult.throwable!!
                    )
                }
                _couponsState.value = MainNavigationDialogCouponsUiState(
                    response = couponsUiStateResult
                )
            }
        }
    }

    private fun readUserTokenFromDataStore() {
        viewModelScope.launch {
            readUserTokenUseCase.invoke().collect {
                _dataStoreUserToken.value = it
            }
        }
    }
}