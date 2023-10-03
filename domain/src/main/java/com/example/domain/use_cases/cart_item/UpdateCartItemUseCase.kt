package com.example.domain.use_cases.cart_item

import com.example.domain.repositories.CartItemRepository

class UpdateCartItemUseCase constructor(
    private val repository: CartItemRepository
) {

    suspend operator fun invoke(
        productId: Int,
        count: Int,
        price: Int
    ) {
        val newPrice = price * count
        repository.updateItem(
            productId = productId,
            count = count,
            newPrice = newPrice
        )
    }
}