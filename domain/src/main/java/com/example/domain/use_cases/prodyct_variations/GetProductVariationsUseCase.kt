package com.example.domain.use_cases.prodyct_variations

import com.example.domain.models.ProductVariationsResponse
import com.example.domain.repositories.ProductVariationsRepository
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetProductVariationsUseCase constructor(
    private val productVariationsRepository: ProductVariationsRepository
) {

    operator fun invoke(productId: Int): Flow<ServiceResult<List<ProductVariationsResponse>>> =
        productVariationsRepository.getProductVariations(productId)
}