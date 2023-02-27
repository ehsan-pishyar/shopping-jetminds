package com.example.domain.use_cases.products

import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.ProductsRepository
import com.example.domain.utils.ServiceResult

class GetProductDetailsUseCase constructor(
    private val productsRepository: ProductsRepository
) {

    suspend operator fun invoke(productId: Int): ServiceResult<ProductsResponse> =
        productsRepository.getProductDetails(productId)
}