package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.cache.models.ProductsResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreProducts(products: List<ProductsResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProductsDetails(productDetails: ProductsResponseEntity)

    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility " +
                "ORDER BY date_created DESC"
    )
    fun fetchProducts(
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): Flow<List<ProductsResponseEntity>>

    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE id = :productId " +
                "ORDER BY date_created"
    )
    fun fetchProductDetails(productId: Int): Flow<ProductsResponseEntity>

//    @Query(
//        "SELECT * FROM `products_table` pt " +
//                "INNER JOIN `mtm_product_category_table` ct ON pt.id = ct.product_id " +
//                "WHERE ct.category_id = :categoryId " +
//                "AND stock_status = :stockStatus " +
//                "AND status = :status " +
//                "AND catalog_visibility = :catalogVisibility"
//    )
    @Transaction
    @Query(
        """
            SELECT * FROM products_table
            WHERE id IN
            (
                SELECT product_id FROM mtm_product_category_table
                WHERE category_id IN (:categoryId)
            )
            ORDER BY date_created DESC
        """
    )
    fun fetchProductsByCategoryId(
        categoryId: Int
    ): Flow<List<ProductsResponseEntity>>

//    @Query(
//        "SELECT * FROM `products_table` pt " +
//                "INNER JOIN `mtm_product_tag_table` tt ON pt.id = tt.product_id " +
//                "WHERE tt.tag_id = :tagId " +
//                "AND stock_status = :stockStatus " +
//                "AND status = :status " +
//                "AND catalog_visibility = :catalogVisibility"
//    )
    @Transaction
    @Query(
        """
            SELECT * FROM products_table
            WHERE id IN
            (
                SELECT product_id FROM mtm_product_tag_table
                WHERE tag_id IN (:tagId)
            )
            AND stock_status = :stockStatus
            AND status = :status
            AND catalog_visibility = :catalogVisibility
            ORDER BY date_created DESC
        """
    )
    fun fetchProductsByTagId(
        tagId: Int,
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): Flow<List<ProductsResponseEntity>>

//    @Query(
//        "SELECT * FROM `products_table` pt " +
//                "INNER JOIN `mtm_product_attr_table` at ON pt.id = at.product_id " +
//                "WHERE at.product_id = :attrId " +
//                "AND stock_status = :stockStatus " +
//                "AND status = :status " +
//                "AND catalog_visibility = :catalogVisibility"
//    )
    @Transaction
    @Query(
        """
            SELECT * FROM products_table
            WHERE id IN
            (
                SELECT product_id FROM mtm_product_attr_table
                WHERE attr_id IN (:attrId)
            )
            AND stock_status = :stockStatus
            AND status = :status
            AND catalog_visibility = :catalogVisibility
            ORDER BY date_created DESC
        """
    )
    fun fetchProductsByAttrId(
        attrId: Int,
        stockStatus: String = "instock",
        status: String = "status",
        catalogVisibility: String = "visible"
    ): Flow<List<ProductsResponseEntity>>

    // OnSale Products
    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE on_sale = :onSale " +
                "AND stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility"
    )
    fun fetchOnSaleProducts(
        onSale: Boolean = true,
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): Flow<List<ProductsResponseEntity>>

    // Popular Products
    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility " +
                "ORDER BY total_sales DESC"
    )
    fun fetchPopularProducts(
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): Flow<List<ProductsResponseEntity>>

    // Top Sales Products
    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility " +
                "ORDER BY total_sales DESC"
    )
    fun fetchTopSalesProducts(
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): Flow<List<ProductsResponseEntity>>

    // Newest Products
    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility " +
                "ORDER BY date_created DESC"
    )
    fun fetchNewestProducts(
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): Flow<List<ProductsResponseEntity>>

    // Top Rated Products
    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility " +
                "ORDER BY average_rating DESC"
    )
    fun fetchTopRatedProducts(
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): Flow<List<ProductsResponseEntity>>

    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility " +
                "ORDER BY regular_price ASC"
    )
    fun fetchLowestPriceProducts(
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): Flow<List<ProductsResponseEntity>>

    @Query(
        "SELECT * FROM `products_table` " +
                "WHERE stock_status = :stockStatus " +
                "AND status = :status " +
                "AND catalog_visibility = :catalogVisibility " +
                "ORDER BY regular_price ASC"
    )
    fun fetchHighestPriceProducts(
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): Flow<List<ProductsResponseEntity>>

    @Query(
        """
            SELECT * FROM `products_table`
            WHERE is_favorite = :isFavorite
            ORDER BY date_created DESC
        """
    )
    fun fetchFavoriteProducts(
        isFavorite: Boolean = true
    ): Flow<List<ProductsResponseEntity>>

    @Query("UPDATE `products_table` SET is_favorite = :isFavorite WHERE id = :id")
    suspend fun updateIsFavoriteProduct(id: Int, isFavorite: Boolean)

    @Query("DELETE FROM `products_table`")
    suspend fun deleteProducts()

    @Transaction
    suspend fun deleteAndInsertProducts(products: List<ProductsResponseEntity>) {
        deleteProducts()
        insertOrIgnoreProducts(products)
    }
}