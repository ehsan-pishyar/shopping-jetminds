package com.example.domain.use_cases.cart_item

import com.example.domain.repositories.CartItemRepository
import kotlinx.coroutines.flow.Flow

class IsInCartItemUseCase constructor(
    private val repository: CartItemRepository
) {

    operator fun invoke(productId: Int): Flow<Int?> = repository.isInCart(productId = productId)
}