package com.example.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Cart
import com.example.domain.use_cases.cart_item.GetCartItemCountUseCase
import com.example.domain.use_cases.cart_item.InsertCartItemUseCase
import com.example.domain.use_cases.cart_item.IsInCartItemUseCase
import com.example.domain.use_cases.cart_item.UpdateCartItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getCartItemCountUseCase: GetCartItemCountUseCase,
    private val insertCartItemUseCase: InsertCartItemUseCase,
    private val updateCartItemUseCase: UpdateCartItemUseCase,
    private val isInCartItemUseCase: IsInCartItemUseCase
): ViewModel() {

    private var _cartItemCount = MutableStateFlow(0)
    val cartItemCount = _cartItemCount.asStateFlow()

    private var _isInCartUiState = MutableStateFlow(0)
    val isInCartUiState = _isInCartUiState.asStateFlow()

    fun getCartItemCount(productId: Int) {
        viewModelScope.launch {
            getCartItemCountUseCase.invoke(productId = productId).collect {
                it?.let { count ->
                    _cartItemCount.value = count
                }
            }
        }
    }

    fun insertCartItem(
        productId: Int,
        productTitle: String,
        productImage: String,
        productCategory: String,
        productPrice: Int,
        count: Int,
        dateAdded: String
    ) {
        viewModelScope.launch {
            insertCartItemUseCase.invoke(cartItem = Cart(
                productId = productId,
                productTitle = productTitle,
                productImage = productImage,
                productCategory = productCategory,
                productPrice = productPrice,
                dateAdded = dateAdded,
                itemCount = count
            )
            )
        }
    }

    fun updateCart(
        productId: Int,
        productPrice: Int,
        count: Int
    ) {
        viewModelScope.launch {
            updateCartItemUseCase.invoke(
                productId = productId,
                count = count,
                price = productPrice
            )
        }
    }

    fun isInCartItem(productId: Int) {
        viewModelScope.launch {
            isInCartItemUseCase.invoke(productId = productId).collect {
                _isInCartUiState.value = it!!
            }
        }
    }
}