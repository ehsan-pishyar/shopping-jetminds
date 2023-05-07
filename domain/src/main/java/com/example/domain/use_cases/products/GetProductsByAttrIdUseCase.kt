package com.example.domain.use_cases.products

import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.ProductsRepository
import com.example.domain.utils.Result
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetProductsByAttrIdUseCase constructor(
    private val productsRepository: ProductsRepository
) {

    operator fun invoke(attrId: Int): Flow<Result<List<ProductsResponse>>> =
        productsRepository.getProductsByAttrId(attrId).asResult()
}