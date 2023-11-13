/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/3/23, 11:50 PM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
        """
            SELECT 
                id, images, name, price, sale_price, average_rating, categories, is_favorite
            FROM `products_table`
            WHERE stock_status = :stockStatus
            AND status = :status
            AND catalog_visibility = :catalogVisibility
            ORDER BY date_created DESC
        """
    )
    fun fetchProducts(
        stockStatus: String = "instock",
        status: String = "publish",
        catalogVisibility: String = "visible"
    ): Flow<List<ProductsResponseEntity>>

    @Query("SELECT * FROM `products_table` WHERE id = :productId")
    fun fetchProductDetails(productId: Int): Flow<ProductsResponseEntity>

    @Transaction
    @Query(
        """
            SELECT 
                id, images, name, price, sale_price, average_rating, categories 
            FROM products_table
            WHERE id IN
            (
                SELECT product_id FROM product_category_cross_ref_table
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
//                "WHERE tt.tag_id = :tagId"
//    )
    @Transaction
    @Query(
        """
            SELECT id, images, name, price, sale_price, average_rating, categories FROM products_table
            WHERE id IN
            (
                SELECT product_id FROM product_tag_cross_ref_table
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
//                "WHERE at.product_id = :attrId"
//    )
    @Transaction
    @Query(
        """
            SELECT id, images, name, price, sale_price, average_rating, categories FROM products_table
            WHERE id IN
            (
                SELECT product_id FROM product_attr_cross_ref_table
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
        "SELECT id, images, name, price, sale_price, average_rating, categories FROM `products_table` " +
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
        "SELECT id, images, name, price, sale_price, average_rating, categories FROM `products_table` " +
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
        "SELECT id, images, name, price, sale_price, average_rating, categories FROM `products_table` " +
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
        "SELECT id, images, name, price, sale_price, average_rating, categories FROM `products_table` " +
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
        "SELECT id, images, name, price, sale_price, average_rating, categories FROM `products_table` " +
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
        "SELECT id, images, name, price, sale_price, average_rating, categories FROM `products_table` " +
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
        "SELECT id, images, name, price, sale_price, average_rating, categories FROM `products_table` " +
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

    @Query("DELETE FROM `products_table`")
    suspend fun deleteProducts()

    @Transaction
    suspend fun deleteAndInsertProducts(products: List<ProductsResponseEntity>) {
        deleteProducts()
        insertOrIgnoreProducts(products)
    }
}