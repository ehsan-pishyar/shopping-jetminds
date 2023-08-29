package com.example.domain.use_cases.products

import com.example.domain.repositories.ProductsRepository

class UpdateFavoriteProductUseCase constructor(
    private val repository: ProductsRepository
) {

    suspend operator fun invoke(productId: Int, isFavorite: Boolean) {
        repository.updateFavoriteProduct(productId = productId, isFavorite = isFavorite)
    }
}