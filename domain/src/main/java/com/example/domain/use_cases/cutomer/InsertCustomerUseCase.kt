package com.example.domain.use_cases.cutomer

import com.example.domain.models.CustomersResponse
import com.example.domain.repositories.CustomerRepository

class InsertCustomerUseCase constructor(
    private val repository: CustomerRepository
) {

    suspend operator fun invoke(customer: CustomersResponse) =
        repository.insertCustomer(customer = customer)
}