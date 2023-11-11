package com.example.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.cart.CalculateTaxUseCase
import com.example.domain.use_cases.cart.CalculateTotalPriceUseCase
import com.example.domain.use_cases.cart.DeleteCartItemUseCase
import com.example.domain.use_cases.cart.GetCartItemCountUseCase
import com.example.domain.use_cases.cart.GetCartItemsUseCase
import com.example.domain.use_cases.cart.GetCartTotalCountsUseCase
import com.example.domain.use_cases.cart.GetCartSubTotalUseCase
import com.example.domain.use_cases.cart.IsInCartItemUseCase
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
    private val getCartSubTotalUseCase: GetCartSubTotalUseCase,
    private val deleteCartItemUseCase: DeleteCartItemUseCase,
    private val calculateTaxUseCase: CalculateTaxUseCase,
    private val calculateTotalPriceUseCase: CalculateTotalPriceUseCase
): ViewModel() {

    private var _cartUiState = MutableStateFlow(MainCartUiState(emptyList()))
    val cartUiState = _cartUiState.asStateFlow()

    private var _isInCartState = MutableStateFlow(0)
    val isInCartState = _isInCartState.asStateFlow()

    private var _cartTotalCountState = MutableStateFlow(0)
    val cartTotalCountState = _cartTotalCountState.asStateFlow()

    private var _subTotalPrice = MutableStateFlow(0)
    val subTotalPrice = _subTotalPrice.asStateFlow()

    private var _cartItemCount = MutableStateFlow(0)
    val cartItemCount = _cartItemCount.asStateFlow()

    private val _calculateTaxState = MutableStateFlow(0)
    val calculateTaxState = _calculateTaxState.asStateFlow()

    private val _calculateTotalPriceState = MutableStateFlow(0)
    val calculateTotalPriceState = _calculateTotalPriceState.asStateFlow()

    init {
        getCartItems()
        getCartTotalCount()
        getSubTotal()
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

    private fun getSubTotal() {
        viewModelScope.launch {
            getCartSubTotalUseCase.invoke().collect { result ->
                result?.let {
                    _subTotalPrice.value = it
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

    fun deleteCartItem(productId: Int) {
        viewModelScope.launch {
            deleteCartItemUseCase.invoke(productId = productId)
        }
    }

    fun calculateTax(subTotal: Int) {
        viewModelScope.launch {
            calculateTaxUseCase.invoke(subTotal = subTotal).collect {
                _calculateTaxState.value = it!!
            }
        }
    }

    fun calculateTotalPrice(subTotal: Int, tax: Int) {
        viewModelScope.launch {
            calculateTotalPriceUseCase.invoke(
                subTotal = subTotal,
                tax = tax
            ).collect {
                _calculateTotalPriceState.value = it!!
            }
        }
    }
}