package com.example.domain.use_cases.cart_item

import com.example.domain.models.Cart
import com.example.domain.repositories.CartItemRepository
import kotlinx.coroutines.flow.Flow

class GetCartItemsUseCase constructor(
    private val repository: CartItemRepository
){

    operator fun invoke(): Flow<List<Cart>> = repository.fetchItems()
}