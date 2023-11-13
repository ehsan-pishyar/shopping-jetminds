/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/5/23, 12:30 AM
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

import com.example.cache.dao.CustomersDao
import com.example.cache.models.CustomersResponseEntity
import com.example.domain.models.CustomersResponse
import com.example.domain.repositories.CustomerRepository
import com.example.network.ApiService
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CustomerRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: CustomersDao
): CustomerRepository {

    override fun getCustomer(customerId: Int): Flow<CustomersResponse> {
        return dao.fetchCustomer(customerId = customerId).map(CustomersResponseEntity::toDomain).onEach {
            if (it == null) {
                refreshCustomer(customerId = customerId)
            }
        }
    }

    override suspend fun insertCustomer(customer: CustomersResponse) {
        dao.insertOrIgnoreCustomer(customer = customer.toEntity())
    }

    override suspend fun refreshCustomer(customerId: Int) {
        api.getCustomer(customerId = customerId).also { customerDto ->
            dao.deleteAndInsertCustomers(customer = customerDto.toEntity())
        }
    }
}