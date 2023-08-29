package com.example.domain.use_cases.products

import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.ProductsRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteProductsUseCase constructor(
    private val repository: ProductsRepository
) {

    operator fun invoke(): Flow<List<ProductsResponse>> =
        repository.getFavoriteProducts()
}