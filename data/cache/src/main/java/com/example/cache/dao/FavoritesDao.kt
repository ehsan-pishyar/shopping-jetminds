package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cache.models.ProductsResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {

    @Query(
        """
            SELECT * FROM `products_table`
            WHERE is_favorite = :isFavorite
        """
    )
    fun fetchFavoriteProducts(
        isFavorite: Boolean = true
    ): Flow<List<ProductsResponseEntity>>

    @Query("UPDATE `products_table` SET is_favorite = :isFavorite WHERE id = :id")
    suspend fun updateIsFavoriteProduct(id: Int, isFavorite: Boolean)

    @Query("SELECT is_favorite FROM `products_table` WHERE id = :productId AND is_favorite = :isFavorite")
    fun isFavoriteProduct(productId: Int, isFavorite: Boolean = true): Flow<Boolean?>
}