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