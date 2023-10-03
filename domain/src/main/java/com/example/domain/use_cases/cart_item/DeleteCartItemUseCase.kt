package com.example.domain.use_cases.cart_item

import com.example.domain.repositories.CartItemRepository

class DeleteCartItemUseCase constructor(
    private val repository: CartItemRepository
) {

    suspend operator fun invoke(productId: Int) = repository.deleteItem(productId = productId)
}