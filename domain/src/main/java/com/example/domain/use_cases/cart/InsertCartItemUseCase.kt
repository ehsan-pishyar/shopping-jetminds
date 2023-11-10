package com.example.domain.use_cases.cart

import com.example.domain.models.Cart
import com.example.domain.repositories.CartRepository

class InsertCartItemUseCase constructor(
    private val repository: CartRepository
) {

    suspend operator fun invoke(cartItem: Cart) = repository.insertItem(cartItem = cartItem)
}