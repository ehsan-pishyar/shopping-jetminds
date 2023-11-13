/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/29/23, 10:51 PM
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

import com.example.cache.dao.OrdersDao
import com.example.cache.models.OrdersResponseEntity
import com.example.domain.models.OrdersResponse
import com.example.domain.repositories.OrdersRepository
import com.example.network.ApiService
import com.example.network.models.OrdersResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class OrdersRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: OrdersDao
): OrdersRepository {

    override fun getOrders(): Flow<List<OrdersResponse>> {
        return dao.fetchOrders().map { ordersEntity ->
            ordersEntity.map(OrdersResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshOrders()
            }
        }
    }

    override fun getOrderDetails(orderId: Int): Flow<OrdersResponse> {
        return dao.fetchOrderDetails(orderId = orderId).map(OrdersResponseEntity::toDomain)
    }

    override suspend fun refreshOrders() {
        api.getOrders().also { ordersResponseDtos ->
            dao.deleteAndInsertOrders(
                orders = ordersResponseDtos.map(
                    OrdersResponseDto::toEntity
                )
            )
        }
    }
}