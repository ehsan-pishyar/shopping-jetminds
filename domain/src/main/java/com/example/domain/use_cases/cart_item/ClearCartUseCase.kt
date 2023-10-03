package com.example.domain.use_cases.cart_item

import com.example.domain.repositories.CartItemRepository

class ClearCartUseCase constructor(
    private val repository: CartItemRepository
) {

//    suspend operator fun invoke() = repository.clearCart()
}