package com.example.domain.use_cases.cart_item

import com.example.domain.repositories.CartItemRepository
import kotlinx.coroutines.flow.Flow

class GetCartItemCountUseCase constructor(
    private val repository: CartItemRepository
) {

    operator fun invoke(productId: Int): Flow<Int?> = repository.fetchItemCount(productId = productId)
}