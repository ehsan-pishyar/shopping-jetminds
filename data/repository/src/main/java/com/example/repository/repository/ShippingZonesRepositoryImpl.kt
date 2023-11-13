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

import com.example.cache.dao.ShippingZonesDao
import com.example.cache.models.ShippingZonesResponseEntity
import com.example.domain.models.ShippingZonesResponse
import com.example.domain.repositories.ShippingZonesRepository
import com.example.network.ApiService
import com.example.network.models.ShippingZonesResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ShippingZonesRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ShippingZonesDao
): ShippingZonesRepository {

    override fun getShippingZones(): Flow<List<ShippingZonesResponse>> {
        return dao.fetchShippingZones().map { zonesEntity ->
            zonesEntity.map(ShippingZonesResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshShippingZones()
            }
        }
    }

    override suspend fun refreshShippingZones() {
        api.getShippingZones().also { zonesDto ->
            dao.deleteAndInsertShippingZones(
                shippingZones = zonesDto.map(
                    ShippingZonesResponseDto::toEntity
                )
            )
        }
    }
}