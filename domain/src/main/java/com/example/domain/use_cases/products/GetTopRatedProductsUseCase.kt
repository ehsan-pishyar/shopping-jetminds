package com.example.domain.use_cases.products

import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.ProductsRepository
import com.example.domain.utils.Result
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetTopRatedProductsUseCase constructor(
    private val repository: ProductsRepository
) {
    operator fun invoke(): Flow<Result<List<ProductsResponse>>> =
        repository.getTopRatedProducts().asResult()
}