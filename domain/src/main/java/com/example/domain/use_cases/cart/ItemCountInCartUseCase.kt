package com.example.domain.use_cases.cart

import com.example.domain.repositories.CartRepository
import kotlinx.coroutines.flow.Flow

class ItemCountInCartUseCase constructor(
    private val repository: CartRepository
) {

    operator fun invoke(): Flow<Int?> =
        repository.itemCountInCart()
}