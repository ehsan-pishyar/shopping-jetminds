/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/29/23, 10:54 PM
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

import com.example.cache.dao.ProductReviewsDao
import com.example.cache.models.ProductReviewsResponseEntity
import com.example.domain.models.ProductReviewsResponse
import com.example.domain.repositories.ProductReviewsRepository
import com.example.network.ApiService
import com.example.network.models.ProductReviewsResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductReviewsRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ProductReviewsDao
): ProductReviewsRepository {

    override fun getProductReviews(productId: Int): Flow<List<ProductReviewsResponse>> {
        return dao.fetchProductReviews(productId).map { reviewsEntity ->
            reviewsEntity.map(ProductReviewsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProductReviews()
            }
        }
    }

    override fun getProductReviewDetails(reviewId: Int): Flow<ProductReviewsResponse> {
        return dao.fetchProductReviewDetails(reviewId = reviewId).map(ProductReviewsResponseEntity::toDomain)
    }

    override suspend fun refreshProductReviews() {
        api.getProductReviews().also { reviewsDto ->
            dao.deleteAndInsertProductReviews(
                reviews = reviewsDto.map(
                    ProductReviewsResponseDto::toEntity
                )
            )
        }
    }
}