package com.example.domain.use_cases.cart

import com.example.domain.models.Cart
import com.example.domain.repositories.CartRepository

class InsertCartItemUseCase constructor(
    private val repository: CartRepository
) {
    suspend operator fun invoke(item: Cart) = repository.insertItem(item = item)
}