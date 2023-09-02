package com.example.domain.use_cases.favorites

import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.FavoritesRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteProductsUseCase constructor(
    private val repository: FavoritesRepository
) {

    operator fun invoke(): Flow<List<ProductsResponse>> =
        repository.getFavoriteProducts()
}