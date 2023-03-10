package com.example.domain.use_cases.products

import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.ProductsRepository
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase constructor(
    private val productsRepository: ProductsRepository
) {

    operator fun invoke(): Flow<ServiceResult<List<ProductsResponse>>> =
        productsRepository.getProducts()
}