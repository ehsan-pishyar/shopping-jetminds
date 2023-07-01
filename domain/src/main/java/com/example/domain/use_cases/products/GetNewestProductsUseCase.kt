package com.example.domain.use_cases.products

import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.ProductsRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetNewestProductsUseCase constructor(
    private val repository: ProductsRepository
) {
    operator fun invoke(): Flow<ServiceResult<List<ProductsResponse>>> =
        repository.getNewestProducts().asResult()
}