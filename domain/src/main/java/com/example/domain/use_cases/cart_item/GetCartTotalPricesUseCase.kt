package com.example.domain.use_cases.cart_item

import com.example.domain.repositories.CartItemRepository
import kotlinx.coroutines.flow.Flow

class GetCartTotalPricesUseCase constructor(
    private val repository: CartItemRepository
) {

    operator fun invoke(): Flow<Int?> = repository.fetchTotalPrices()
}