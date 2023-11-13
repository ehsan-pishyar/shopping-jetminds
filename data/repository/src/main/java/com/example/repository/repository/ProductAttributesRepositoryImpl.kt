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

import com.example.cache.dao.ProductAttributesDao
import com.example.cache.models.ProductAttributesResponseEntity
import com.example.domain.models.ProductAttributesResponse
import com.example.domain.repositories.ProductAttributesRepository
import com.example.network.ApiService
import com.example.network.models.ProductAttributesResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductAttributesRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ProductAttributesDao
): ProductAttributesRepository {

    override fun getProductAttributes(): Flow<List<ProductAttributesResponse>> {
        return dao.fetchProductAttrs().map { attrsEntity ->
            attrsEntity.map(ProductAttributesResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProductAttributes()
            }
        }
    }

    override fun getProductAttributeDetails(attrId: Int): Flow<ProductAttributesResponse> {
        return dao.fetchProductAttrDetails(attrId = attrId).map(ProductAttributesResponseEntity::toDomain)
    }

    override suspend fun refreshProductAttributes() {
        api.getProductAttributes().also { attrsDto ->
            dao.deleteAndInsertProductAttributes(
                attrs = attrsDto.map(
                    ProductAttributesResponseDto::toEntity
                )
            )
        }
    }
}