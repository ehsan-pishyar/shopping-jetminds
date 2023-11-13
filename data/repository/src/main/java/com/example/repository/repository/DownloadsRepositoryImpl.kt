/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/2/23, 4:09 PM
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

import com.example.cache.dao.DownloadsDao
import com.example.cache.models.ProductsResponseEntity
import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.DownloadsRepository
import com.example.repository.mappers.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DownloadsRepositoryImpl @Inject constructor(
    private val dao: DownloadsDao
): DownloadsRepository {

    override fun getDownloadedProducts(): Flow<List<ProductsResponse>> {
        return dao.fetchDownloadedProducts().map { downloads ->
            downloads.map(ProductsResponseEntity::toDomain)
        }
    }

    override suspend fun updateDownloadedProducts(
        productId: Int,
        downloaded: Boolean
    ) {
        dao.updateDownloadedProduct(
            productId = productId,
            downloaded = downloaded
        )
    }
}