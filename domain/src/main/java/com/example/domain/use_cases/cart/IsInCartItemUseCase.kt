package com.example.domain.use_cases.cart

import com.example.domain.repositories.CartRepository
import kotlinx.coroutines.flow.Flow

class IsInCartItemUseCase constructor(
    private val repository: CartRepository
) {

    operator fun invoke(productId: Int): Flow<Int?> = repository.isInCart(productId = productId)
}