package com.example.domain.use_cases.cart_item

import com.example.domain.models.Cart
import com.example.domain.repositories.CartItemRepository

class InsertCartItemUseCase constructor(
    private val repository: CartItemRepository
) {

    suspend operator fun invoke(cartItem: Cart) = repository.insertItem(cartItem = cartItem)
}