package com.example.domain.repositories

import com.example.domain.models.CustomersResponse
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {

    fun getCustomer(customerId: Int): Flow<CustomersResponse>
    suspend fun insertCustomer(customer: CustomersResponse)
    suspend fun refreshCustomer(customerId: Int)
}