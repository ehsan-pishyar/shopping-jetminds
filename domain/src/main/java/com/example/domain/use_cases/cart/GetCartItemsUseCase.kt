package com.example.domain.use_cases.cart

import com.example.domain.models.Cart
import com.example.domain.repositories.CartRepository
import kotlinx.coroutines.flow.Flow

class GetCartItemsUseCase constructor(
    private val repository: CartRepository
) {
    operator fun invoke(): Flow<List<Cart>> = repository.fetchItems()
}