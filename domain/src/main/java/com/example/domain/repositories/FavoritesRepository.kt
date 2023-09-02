package com.example.domain.repositories

import com.example.domain.models.ProductsResponse
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {

    fun getFavoriteProducts(): Flow<List<ProductsResponse>>
    suspend fun updateFavoriteProduct(isFavorite: Boolean, productId: Int)
}