package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.models.ProductsResponseEntity

@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductsResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductsDetails(productDetails: ProductsResponseEntity)

    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility"
    )
    suspend fun fetchProducts(
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): List<ProductsResponseEntity>

    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE id = :productId " +
                "ORDER BY date_created"
    )
    suspend fun fetchProductDetails(productId: Int): ProductsResponseEntity

    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE categories = :categoryId " +
                "AND stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility"
    )
    suspend fun fetchProductsByCategoryId(
        categoryId: Int,
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): List<ProductsResponseEntity>

    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE tags = :tagId " +
                "AND stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility"
    )
    suspend fun fetchProductsByTagId(
        tagId: Int,
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): List<ProductsResponseEntity>

    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE tags = :attrId " +
                "AND stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility"
    )
    suspend fun fetchProductsByAttrId(
        attrId: Int,
        stockStatus: String = "instock",
        status: String = "status",
        catalogVisibility: String = "visible"
    ): List<ProductsResponseEntity>

    // OnSale Products
    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE on_sale = :onSale " +
                "AND stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility"
    )
    suspend fun fetchOnSaleProducts(
        onSale: Boolean = true,
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): List<ProductsResponseEntity>

    // Popular Products
    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility " +
                "ORDER BY total_sales DESC"
    )
    suspend fun fetchPopularProducts(
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): List<ProductsResponseEntity>

    // Top Sales Products
    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility " +
                "ORDER BY total_sales DESC"
    )
    suspend fun fetchTopSalesProducts(
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): List<ProductsResponseEntity>

    // Newest Products
    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility " +
                "ORDER BY date_created DESC"
    )
    suspend fun fetchNewestProducts(
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): List<ProductsResponseEntity>

    // Top Rated Products
    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility " +
                "ORDER BY average_rating DESC"
    )
    suspend fun fetchTopRatedProducts(
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): List<ProductsResponseEntity>

    @Query("SELECT COUNT(*) FROM `products_table`")
    suspend fun isProductsCacheAvailable(): Int
}