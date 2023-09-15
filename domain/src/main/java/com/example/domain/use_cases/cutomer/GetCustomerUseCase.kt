package com.example.domain.use_cases.cutomer

import com.example.domain.models.CustomersResponse
import com.example.domain.repositories.CustomerRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetCustomerUseCase constructor(
    private val repository: CustomerRepository
) {

    operator fun invoke(customerId: Int): Flow<ServiceResult<CustomersResponse>> =
        repository.getCustomer(customerId = customerId).asResult()
}