package com.example.domain.use_cases.cart

import com.example.domain.repositories.CartRepository
import kotlinx.coroutines.flow.Flow

class IsInCartUseCase constructor(
    private val repository: CartRepository
) {

    operator fun invoke(productId: Int): Flow<Boolean?> =
        repository.isInCart(productId = productId)
}