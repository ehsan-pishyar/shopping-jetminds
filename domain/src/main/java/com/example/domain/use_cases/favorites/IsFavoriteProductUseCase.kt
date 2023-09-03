package com.example.domain.use_cases.favorites

import com.example.domain.repositories.FavoritesRepository
import kotlinx.coroutines.flow.Flow

class IsFavoriteProductUseCase constructor(
    private val repository: FavoritesRepository
) {

    operator fun invoke(productId: Int): Flow<Boolean?> =
        repository.isFavoriteProduct(productId = productId)
}