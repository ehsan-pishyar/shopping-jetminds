package com.example.productdetails.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.cart.UpdateCartItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val updateCartItemUseCase: UpdateCartItemUseCase
): ViewModel() {

    fun updateCart(productId: Int, inCart: Boolean, addedToCartDate: String) {
        viewModelScope.launch {
            updateCartItemUseCase.invoke(
                productId = productId,
                inCart = inCart,
                addedToCartDate = addedToCartDate
            )
        }
    }
}