package com.example.repository.repository

import com.example.cache.dao.FavoritesDao
import com.example.cache.models.ProductsResponseEntity
import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.FavoritesRepository
import com.example.repository.mappers.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoritesRepositoryImpl @Inject constructor(
    private val dao: FavoritesDao
): FavoritesRepository {

    override fun getFavoriteProducts(): Flow<List<ProductsResponse>> {
        return dao.fetchFavoriteProducts().map { favorites ->
            favorites.map(ProductsResponseEntity::toDomain)
        }
    }

    override suspend fun updateFavoriteProduct(isFavorite: Boolean, productId: Int) =
        dao.updateIsFavoriteProduct(id = productId, isFavorite = isFavorite)

    override fun isFavoriteProduct(productId: Int): Flow<Boolean?> {
        return dao.isFavoriteProduct(
            productId = productId
        ).flowOn(Dispatchers.IO)
    }
}