/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/29/23, 10:57 PM
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

import com.example.cache.dao.ProductTagsDao
import com.example.cache.models.ProductTagsResponseEntity
import com.example.domain.models.ProductTagsResponse
import com.example.domain.repositories.ProductTagsRepository
import com.example.network.ApiService
import com.example.network.models.ProductTagsResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductTagsRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ProductTagsDao
): ProductTagsRepository {

    override fun getProductTags(): Flow<List<ProductTagsResponse>> {
        return dao.fetchProductTags().map { tagsEntity ->
            tagsEntity.map(ProductTagsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProductTags()
            }
        }
    }

    override fun getProductTagDetails(tagId: Int): Flow<ProductTagsResponse> {
        return dao.fetchProductTagDetails(tagId = tagId).map(ProductTagsResponseEntity::toDomain)
    }

    override suspend fun refreshProductTags() {
        api.getProductTags().also { tagsDto ->
            dao.deleteAndInsertProductTags(
                tags = tagsDto.map(
                    ProductTagsResponseDto::toEntity
                )
            )
        }
    }
}