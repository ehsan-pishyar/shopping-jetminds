package com.example.domain.use_cases.products

import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.ProductsRepository
import com.example.domain.utils.Result
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetProductDetailsUseCase constructor(
    private val repository: ProductsRepository
) {

    suspend operator fun invoke(productId: Int): Flow<Result<ProductsResponse>> =
        repository.getProductDetails(productId).asResult()
}