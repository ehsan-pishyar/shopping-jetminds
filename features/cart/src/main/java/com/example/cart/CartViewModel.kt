package com.example.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.cart.GetCartItemsUseCase
import com.example.domain.use_cases.cart.IsInCartUseCase
import com.example.domain.use_cases.cart.ItemCountInCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val isInCartUseCase: IsInCartUseCase,
    private val itemCountInCartUseCase: ItemCountInCartUseCase
): ViewModel() {

    private var _cartUiState = MutableStateFlow(MainCartUiState(emptyList()))
    val cartUiState = _cartUiState.asStateFlow()

    private var _isInCartState = MutableStateFlow(false)
    val isInCartState = _isInCartState.asStateFlow()

    private var _cartItemCountState = MutableStateFlow(0)
    val cartItemCountState = _cartItemCountState.asStateFlow()

    private var _totalPrice = MutableStateFlow(0)
    val totalPrice = _totalPrice.asStateFlow()

    init {
        getCartItems()
        itemCountInCart()
        getTotalPrice()
    }

    private fun getCartItems() {
        viewModelScope.launch {
            getCartItemsUseCase.invoke().collect { cartItems ->
                _cartUiState.value = MainCartUiState(
                    cartUiState = cartItems
                )
            }
        }
    }

    private fun getTotalPrice() {
        viewModelScope.launch {
            getCartItemsUseCase.invoke().collect { cartItems ->
                cartItems.forEach {
                    _totalPrice.value = it.price?.toInt()!!
                }
            }
        }
    }

    fun isInCart(productId: Int) {
        viewModelScope.launch {
            isInCartUseCase.invoke(productId = productId).collect {
                _isInCartState.value = it!!
            }
        }
    }

    private fun itemCountInCart() {
        viewModelScope.launch {
            itemCountInCartUseCase.invoke().collect {
                _cartItemCountState.value = it!!
            }
        }
    }
}