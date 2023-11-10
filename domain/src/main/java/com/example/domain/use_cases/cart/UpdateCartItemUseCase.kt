package com.example.domain.use_cases.cart

import com.example.domain.repositories.CartRepository

class UpdateCartItemUseCase constructor(
    private val repository: CartRepository
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