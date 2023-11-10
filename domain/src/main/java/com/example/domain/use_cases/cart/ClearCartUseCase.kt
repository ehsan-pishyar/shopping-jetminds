package com.example.domain.use_cases.cart

import com.example.domain.repositories.CartRepository

class ClearCartUseCase constructor(
    private val repository: CartRepository
) {

//    suspend operator fun invoke() = repository.clearCart()
}