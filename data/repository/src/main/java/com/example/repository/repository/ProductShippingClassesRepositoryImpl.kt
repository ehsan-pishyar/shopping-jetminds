/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 5/25/23, 12:36 AM
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

import com.example.cache.dao.ProductShippingClassesDao
import com.example.cache.models.ProductShippingClassesResponseEntity
import com.example.domain.models.ProductShippingClassesResponse
import com.example.domain.repositories.ProductShippingClassesRepository
import com.example.network.ApiService
import com.example.network.models.ProductShippingClassesResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductShippingClassesRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ProductShippingClassesDao
): ProductShippingClassesRepository {

    override fun getProductShippingClasses(): Flow<List<ProductShippingClassesResponse>> {
        return dao.fetchProductShippingClasses().map { shippingClassesEntity ->
            shippingClassesEntity.map(ProductShippingClassesResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProductShippingClasses()
            }
        }
    }

    override suspend fun refreshProductShippingClasses() {
        api.getProductShippingClasses().also { productShippingClassesResponseDtos ->
            dao.deleteAndInsertProductShippingClasses(
                productShippingClasses = productShippingClassesResponseDtos.map(
                    ProductShippingClassesResponseDto::toEntity
                )
            )
        }
    }
}