/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/27/23, 9:36 PM
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

package com.example.domain.repositories

import com.example.domain.models.ProductsResponse
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    suspend fun insertProductDetails(productDetails: ProductsResponse)
    fun getProducts(): Flow<List<ProductsResponse>>
    fun getProductsByCategoryId(categoryId: Int): Flow<List<ProductsResponse>>
    fun getProductsByTagId(tagId: Int): Flow<List<ProductsResponse>>
    fun getProductsByAttrId(attrId: Int): Flow<List<ProductsResponse>>
    suspend fun getProductDetails(productId: Int): Flow<ProductsResponse>

    fun getNewestProducts(): Flow<List<ProductsResponse>>
    fun getPopularProducts(): Flow<List<ProductsResponse>>
    fun getTopRatedProducts(): Flow<List<ProductsResponse>>
    fun getOnSalesProducts(): Flow<List<ProductsResponse>>
    fun getTopSalesProducts(): Flow<List<ProductsResponse>>
    fun getLowestPriceProducts(): Flow<List<ProductsResponse>>
    fun getHighestPriceProducts(): Flow<List<ProductsResponse>>

    suspend fun refreshProducts()
}