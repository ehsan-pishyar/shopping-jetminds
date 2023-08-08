package com.example.domain.use_cases.cart

import com.example.domain.models.Cart
import com.example.domain.repositories.CartRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetCartItemsUseCase constructor(
    private val repository: CartRepository
) {
    operator fun invoke(): Flow<ServiceResult<List<Cart>>> = repository.fetchItems().asResult()
}