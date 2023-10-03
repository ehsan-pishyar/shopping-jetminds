package com.example.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.cart_item.GetCartItemCountUseCase
import com.example.domain.use_cases.cart_item.GetCartItemsUseCase
import com.example.domain.use_cases.cart_item.GetCartTotalCountsUseCase
import com.example.domain.use_cases.cart_item.GetCartTotalPricesUseCase
import com.example.domain.use_cases.cart_item.IsInCartItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getItemsInCartUseCase: GetCartItemsUseCase,
    private val isInCartUseCase: IsInCartItemUseCase,
    private val getCartTotalCountsUseCase: GetCartTotalCountsUseCase,
    private val getCartItemCountUseCase: GetCartItemCountUseCase,
    private val getCartTotalPricesUseCase: GetCartTotalPricesUseCase
): ViewModel() {

    private var _cartUiState = MutableStateFlow(MainCartUiState(emptyList()))
    val cartUiState = _cartUiState.asStateFlow()

    private var _isInCartState = MutableStateFlow(0)
    val isInCartState = _isInCartState.asStateFlow()

    private var _cartTotalCountState = MutableStateFlow(0)
    val cartTotalCountState = _cartTotalCountState.asStateFlow()

    private var _totalPrice = MutableStateFlow(0)
    val totalPrice = _totalPrice.asStateFlow()

    private var _cartItemCount = MutableStateFlow(0)
    val cartItemCount = _cartItemCount.asStateFlow()

    init {
        getCartItems()
        getCartTotalCount()
        getTotalPrice()
    }

    private fun getCartItems() {
        viewModelScope.launch {
            getItemsInCartUseCase.invoke().collect { cartItems ->
                _cartUiState.value = MainCartUiState(
                    cartUiState = cartItems
                )
            }
        }
    }

    private fun getTotalPrice() {
        viewModelScope.launch {
            getCartTotalPricesUseCase.invoke().collect { cartItems ->
                cartItems?.let {
                    _totalPrice.value = it
                }
            }
        }
    }

    private fun getCartTotalCount() {
        viewModelScope.launch {
            getCartTotalCountsUseCase.invoke().collect { totalCounts ->
                _cartTotalCountState.value = totalCounts!!
            }
        }
    }

    fun getCartItemCount(productId: Int) {
        viewModelScope.launch {
            getCartItemCountUseCase.invoke(productId = productId).collect { itemCount ->
                _cartItemCount.value = itemCount!!
            }
        }
    }

    fun isItemInCart(productId: Int) {
        viewModelScope.launch {
            isInCartUseCase.invoke(productId = productId).collect {
                _isInCartState.value = it!!
            }
        }
    }
}