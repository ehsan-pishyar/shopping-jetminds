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

import com.example.cache.dao.CouponsDao
import com.example.cache.models.CouponsResponseEntity
import com.example.domain.models.CouponsResponse
import com.example.domain.repositories.CouponsRepository
import com.example.network.ApiService
import com.example.network.models.CouponsResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CouponsRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: CouponsDao
): CouponsRepository{

    override fun getCoupons(): Flow<List<CouponsResponse>> {
        return dao.fetchCoupons().map { couponsEntity ->
            couponsEntity.map(CouponsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshCoupons()
            }
        }
    }

    override fun getCouponDetails(couponId: Int): Flow<CouponsResponse> {
        return dao.fetchCouponDetails(couponId = couponId).map(CouponsResponseEntity::toDomain)
    }

    override suspend fun refreshCoupons() {
        api.getCoupons().also { couponsResponseDtos ->
            dao.deleteAndInsertCoupons(
                coupons = couponsResponseDtos.map(
                    CouponsResponseDto::toEntity
                )
            )
        }
    }
}