/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/29/23, 11:12 PM
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

import com.example.cache.dao.ProductVariationsDao
import com.example.cache.models.ProductVariationsResponseEntity
import com.example.domain.models.ProductVariationsResponse
import com.example.domain.repositories.ProductVariationsRepository
import com.example.network.ApiService
import com.example.network.models.ProductVariationsResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductVariationsRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ProductVariationsDao
): ProductVariationsRepository {

    override fun getProductVariations(productId: Int): Flow<List<ProductVariationsResponse>> {
        return dao.fetchProductVariations(productId).map { variationsEntity ->
            variationsEntity.map(ProductVariationsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProductVariations(productId)
            }
        }
    }

    override fun getProductVariationDetails(
        productId: Int,
        variationId: Int
    ): Flow<ProductVariationsResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshProductVariations(productId: Int) {
        api.getProductVariations(productId).also { variationsDto ->
            dao.deleteAndInsertProductVariations(
                variations = variationsDto.map(
                    ProductVariationsResponseDto::toEntity
                )
            )
        }
    }
}