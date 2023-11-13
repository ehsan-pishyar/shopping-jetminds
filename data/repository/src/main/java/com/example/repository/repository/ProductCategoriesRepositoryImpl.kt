/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/30/23, 11:37 PM
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

package com.example.repository.repository

import com.example.cache.dao.ProductCategoriesDao
import com.example.cache.models.ProductCategoriesResponseEntity
import com.example.domain.models.ProductCategoriesResponse
import com.example.domain.repositories.ProductCategoriesRepository
import com.example.network.ApiService
import com.example.network.models.ProductCategoriesResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductCategoriesRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ProductCategoriesDao
): ProductCategoriesRepository {

    override fun getProductCategories(): Flow<List<ProductCategoriesResponse>> {
        return dao.fetchProductCategories().map { categoriesEntity ->
            categoriesEntity.map(ProductCategoriesResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshCategories()
            }
        }
    }

    override fun getProductCategoryDetails(categoryId: Int): Flow<ProductCategoriesResponse> {
        return dao.fetchProductCategoryDetails(categoryId).map(ProductCategoriesResponseEntity::toDomain)
    }


    override suspend fun refreshCategories() {
        api.getProductCategories().also { categoriesDto ->
            dao.deleteAndInsertCategories(
                categories = categoriesDto.map(
                    ProductCategoriesResponseDto::toEntity
                )
            )
        }
    }
}