package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cache.models.ProductsResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Query("SELECT * FROM `products_table` WHERE in_cart = :inCart ORDER BY added_to_cart_date ASC")
    fun fetchItems(
        inCart: Boolean = true
    ): Flow<List<ProductsResponseEntity>>

    @Query("UPDATE `products_table` SET in_cart = :inCart AND added_to_cart_date = :addedToCartDate WHERE id = :productId")
    suspend fun updateInCartProduct(
        productId: Int,
        inCart: Boolean,
        addedToCartDate: String = ""
    )

    @Query("SELECT in_cart FROM `products_table` WHERE id = :productId AND in_cart = :inCart")
    fun isInCart(
        productId: Int,
        inCart: Boolean = true
    ): Flow<Boolean?>

    @Query("SELECT COUNT(*) FROM `products_table` WHERE in_cart = :inCart")
    fun itemCountInCart(
        inCart: Boolean = true
    ): Flow<Int?>
}