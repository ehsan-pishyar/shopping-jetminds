package com.example.domain.use_cases.products

import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.ProductsRepository
import com.example.domain.utils.Result
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetProductsByTagIdUseCase constructor(
    private val repository: ProductsRepository
) {

    operator fun invoke(tagId: Int): Flow<Result<List<ProductsResponse>>> =
        repository.getProductsByTagId(tagId).asResult()
}