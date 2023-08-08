package com.example.domain.use_cases.cart

import com.example.domain.repositories.CartRepository

class DeleteCartItemUseCase constructor(
    private val repository: CartRepository
) {
    suspend operator fun invoke(itemId: Int) = repository.deleteItem()
}