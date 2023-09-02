package com.example.domain.use_cases.favorites

import com.example.domain.repositories.FavoritesRepository

class UpdateFavoriteProductUseCase constructor(
    private val repository: FavoritesRepository
) {

    suspend operator fun invoke(productId: Int, isFavorite: Boolean) {
        repository.updateFavoriteProduct(productId = productId, isFavorite = isFavorite)
    }
}