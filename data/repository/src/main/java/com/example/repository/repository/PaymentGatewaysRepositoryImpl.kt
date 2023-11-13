/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/15/23, 12:04 AM
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

import com.example.cache.dao.PaymentGatewaysDao
import com.example.cache.models.PaymentGatewaysResponseEntity
import com.example.domain.models.PaymentGatewaysResponse
import com.example.domain.repositories.PaymentGatewaysRepository
import com.example.network.ApiService
import com.example.network.models.PaymentGatewaysResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class PaymentGatewaysRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: PaymentGatewaysDao
): PaymentGatewaysRepository {

    override fun getPaymentGateways(): Flow<List<PaymentGatewaysResponse>> {
        return dao.fetchPaymentGateways().map { gatewaysEntity ->
            gatewaysEntity.map(PaymentGatewaysResponseEntity::toDomain)
        }.onEach { gateways ->
            if (gateways.isEmpty()) {
                refreshGateways()
            }
        }
    }

    override fun getPaymentGatewayDetails(gatewayId: String): Flow<PaymentGatewaysResponse> {
        return dao.fetchPaymentGatewayDetails(gatewayId = gatewayId).map(
            PaymentGatewaysResponseEntity::toDomain
        )
    }

    override suspend fun refreshGateways() {
        api.getProductPaymentGateways().also { gatewaysDto ->
            dao.deleteAndInsertPaymentGateways(
                gateways = gatewaysDto.map(
                    PaymentGatewaysResponseDto::toEntity
                )
            )
        }
    }
}